--1.	Tạo cơ sở dữ liệu như sau (Lưu ý: Sinh viên có thể viết code hoặc dùng tool) 
--      Bảng MONHOC (MaMonHoc, TenMonHoc, SoTinChi)
--      Bảng DIEM: (MaSV, MaMonHoc, Diem)
CREATE DATABASE TEST
go
use TEST
go
CREATE TABLE MONHOC(
MaMonHoc NVARCHAR(20) PRIMARY KEY, 
TenMonHoc NVARCHAR(100) not null, 
SoTinChi int not null,
)
go
CREATE TABLE DIEM(
MaSV NVARCHAR(20) not null,
MaMonHoc NVARCHAR(20) not null, 
Diem FLOAT not null,
FOREIGN KEY(MaMonHoc) REFERENCES MONHOC(MaMonHoc)
)
go

--2.	Xây dựng thủ tục Stored Procedure (SP) với các tham số đầu vào phù hợp thêm thông tin vào các bảng trên. Yêu cầu mỗi SP phải kiểm tra tham số đầu vào. Với các cột không chấp nhận thuộc tính Null 
--- Với mỗi SP viết 3 lời gọi thành công
IF OBJECT_ID('sp_insert_MONHOC') is not null
DROP PROC sp_insert_MONHOC
go
CREATE PROC sp_insert_MONHOC(
	@MaMonHoc NVARCHAR(20), 
	@TenMonHoc NVARCHAR(100), 
	@SoTinChi int
)
AS
BEGIN
	BEGIN TRY
		IF @MaMonHoc is null or @TenMonHoc is null or @SoTinChi is null
			PRINT 'Vui long nhap day du thong tin'
		ELSE
			BEGIN
				INSERT MONHOC VALUES(@MaMonHoc, @TenMonHoc, @SoTinChi)
				PRINT 'Them thanh cong'
			END
	END TRY
	BEGIN CATCH
		PRINT 'Them that bai '+ERROR_MESSAGE()
	END CATCH
END
go
EXEC sp_insert_MONHOC 'N01','Java 1',3
EXEC sp_insert_MONHOC 'N02','Java 2',2
EXEC sp_insert_MONHOC 'N03','Java 3',4
go
--
IF OBJECT_ID('sp_insert_DIEM') is not null
DROP PROC sp_insert_DIEM
go
CREATE PROC sp_insert_DIEM(
	@MaSV NVARCHAR(20),
	@MaMonHoc NVARCHAR(20), 
	@Diem FLOAT
)
AS
BEGIN
	BEGIN TRY
		IF @MaSV is null or @MaMonHoc is null or @Diem is null
			PRINT 'Vui long nhap day du thong tin'
		ELSE
			BEGIN
				INSERT DIEM VALUES(@MaSV, @MaMonHoc, @Diem)
				PRINT 'Them thanh cong'
			END
	END TRY
	BEGIN CATCH
		PRINT 'Them that bai '+ERROR_MESSAGE()
	END CATCH
END
go
EXEC sp_insert_DIEM 'A01','N01',8.5
EXEC sp_insert_DIEM 'A02','N02',9
EXEC sp_insert_DIEM 'A03','N01',8
EXEC sp_insert_DIEM 'A04','N03',3
EXEC sp_insert_DIEM 'A03','N01',NULL
go
--3.	Xây dựng hàm có đầu vào là MaMonHoc, hàm trả Tổng số sinh viên thi của môn học truyền vào. 
---	Viết lời gọi hàm 
IF OBJECT_ID('fn_TSSV') is not null
DROP FUNCTION fn_TSSV
go
CREATE FUNCTION fn_TSSV(@MaMH nvarchar(20))
RETURNS INT
AS
BEGIN
	RETURN(SELECT COUNT(MaSV)
			FROM DIEM
			WHERE MaMonHoc = @MaMH)
END
go
SELECT dbo.fn_TSSV('N01') as [Tổng số sinh viên thi]
go

--4.	Xây dựng thủ tục xóa có đầu vào là MaMonHoc. 
--Thủ tục thực hiện xóa thông tin MonHoc thỏa mãn tham số đầu vào.
--	Lưu ý Xóa thông tin liên quan trên bảng nhiều.
--Yêu cầu: Sử dụng giao dịch trong thân SP, để đảm bảo tính toàn vẹn dữ liệu khi một thao tác xóa thực hiện không thành công.
--	Viết lời gọi SP thành công.
IF OBJECT_ID('sp_XoaTT_MONHOC') is not null
DROP PROC sp_XoaTT_MONHOC
go
CREATE PROC sp_XoaTT_MONHOC(@MaMH nvarchar(20))
AS
BEGIN
	BEGIN TRY
		BEGIN TRAN
			DELETE FROM DIEM
			WHERE MaMonHoc = @MaMH
			DELETE FROM MONHOC
			WHERE MaMonHoc = @MaMH
		COMMIT
		PRINT 'Xoa thanh cong'
	END TRY
	BEGIN CATCH
		ROLLBACK TRAN
		PRINT 'Xoa that bai'
	END CATCH
END
go
EXEC sp_XoaTT_MONHOC 'N03'
SELECT *FROM DIEM
SELECT *FROM MONHOC
GO

--5.	Tạo View lưu thông tin của TOP 2 Sinh viên thi nhiều lần nhất: MaSV, Số lần thi. 
IF OBJECT_ID('vw_TOP2') is not null
DROP VIEW vw_TOP2
go
CREATE VIEW vw_TOP2
AS
	SELECT TOP(2) MaSV, COUNT(DIEM.MaMonHoc) as [Số lần thi]
	FROM DIEM join MONHOC ON MONHOC.MaMonHoc = DIEM.MaMonHoc
	GROUP BY MaSV, DIEM.MaMonHoc
	ORDER BY [Số lần thi] DESC
go
SELECT * FROM vw_TOP2
GO

--6.	Tạo view lưu thông tin: MaSV, MaMH, TenMH, Diem, Trạng thái.
--Trong đó Trạng thái: Nếu điểm >=5 thì đạt, còn lại thì trượt.
IF OBJECT_ID('vw_luu_TT') is not null
DROP VIEW vw_luu_TT
go
CREATE VIEW vw_luu_TT
AS
	SELECT MaSV, d.MaMonHoc, TenMonHoc, Diem,
		 IIF(Diem>=5, 'Dat', 'Truot') as TrangThai
	FROM DIEM d join MONHOC mh ON d.MaMonHoc = mh.MaMonHoc
go
SELECT * FROM vw_luu_TT
go

--7.	Xây dựng hàm đầu vào là Tên đăng nhập (Phần đầu của email). Hàm trả về kết quả là MSSV:
--VD: DangLMPH00123 => trả về MSSV: PH00123.
IF OBJECT_ID('fn_get_mssv') is not null
DROP FUNCTION fn_get_mssv
go
CREATE FUNCTION fn_get_mssv(@username VARCHAR(255))
RETURNS VARCHAR(255)
AS
BEGIN
	RETURN(SELECT SUBSTRING(@username, CHARINDEX('PH',@username, 1), 7) AS MSSV)
END
go
SELECT dbo.fn_get_mssv('NghiaNTTPH37410') AS MSSV
