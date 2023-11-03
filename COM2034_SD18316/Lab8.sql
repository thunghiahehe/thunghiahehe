CREATE DATABASE QLMH
go
use QLMH
go
CREATE TABLE MATHANG(
MAMH nvarchar(10) PRIMARY KEY not null,
TENMH nvarchar(100) not null,
DONGIA money not null
)
go
CREATE TABLE CHITIETDH(
MADH nvarchar(10) not null,
MAMH nvarchar(10) not null,
FOREIGN KEY(MAMH) references MATHANG,
PRIMARY KEY (MADH,MAMH),
SOLUONG int not null
)
go

--C2
IF OBJECT_ID('sp_TTMT') is not null
DROP PROC sp_TTMT
go
CREATE PROC sp_TTMT(
			@Mamh nvarchar(10),
			@Tenmh nvarchar(100),
			@DonGia money)
as
BEGIN
	BEGIN TRY
		INSERT MATHANG VALUES(@Mamh,@Tenmh,@DonGia)
		PRINT N'Thêm thành công'
	END TRY
	BEGIN CATCH
		PRINT N'Thêm thất bại' + ERROR_MESSAGE()
	END CATCH
END
go
EXEC sp_TTMT 'N01','Sp1',2000
EXEC sp_TTMT 'N02','Sp2',3000
EXEC sp_TTMT 'N03','Sp3',4000
EXEC sp_TTMT 'N04','Sp4',5000
SELECT * FROM MATHANG
--
IF OBJECT_ID('sp_CTDH') is not null
DROP PROC sp_CTDH
go
CREATE PROC sp_CTDH(
			@Madh nvarchar(10),
			@Mamh nvarchar(10),
			@Soluong int)
AS
BEGIN
	BEGIN TRY
		INSERT CHITIETDH VALUES(@Madh, @Mamh, @Soluong)
		PRINT N'Thêm thành công'
	END TRY
	BEGIN CATCH
		PRINT N'Thêm thất bại' + ERROR_MESSAGE()
	END CATCH
END
GO
EXEC sp_CTDH 'A01','N03',3
EXEC sp_CTDH 'A02','N02',4
EXEC sp_CTDH 'A03','N01',1
EXEC sp_CTDH 'A04','N03',5
SELECT * FROM CHITIETDH
go

--C3
IF OBJECT_ID('fn_SLMH') is not null
DROP FUNCTION fn_SLMH
go
CREATE FUNCTION fn_SLMH(@MaMH nvarchar(10))
RETURNS int
AS
BEGIN
	RETURN(SELECT SUM(Soluong)
			FROM CHITIETDH
			WHERE Mamh = @MaMH)
END
go
SELECT dbo.fn_SLMH('N02') as TongSL

--C4
IF OBJECT_ID('sp_XoaTT') is not NULL
DROP PROC sp_XoaTT
GO
CREATE PROC sp_XoaTT @MaMH nvarchar(10)
AS
BEGIN
	DELETE FROM MATHANG
	WHERE MAMH like @MaMH
	DELETE FROM CHITIETDH
	WHERE MAMH like @MaMH
END
GO
EXEC sp_XoaTT 'N04'
GO

--C5
IF OBJECT_ID('sp_TTDH') is not null
DROP PROC sp_TTDH
go
CREATE PROC sp_TTDH
AS
BEGIN
	SELECT mh.MAMH, TENMH, SUM(SOLUONG) as TongSL,
		   CASE
				WHEN SUM(SOLUONG)>300 THEN N'Bán chạy'
				ELSE N'Không bán chạy'
		   END as [Trạng thái]
	FROM CHITIETDH dh INNER JOIN MATHANG mh ON dh.MAMH = mh.MAMH
END
go
EXEC sp_TTDH
