--Câu 1: Tạo cơ sở dữ liệu QLDA gồm 3 bảng. 
--DUAN(MADA,TenDA, DiaDiemDA)
--NHANVIEN(MANV, HOTEN, GIOITINH, LUONG)
--CTDA(MANV, MADA, SoGio)
CREATE DATABASE QLDA
GO
USE QLDA
GO
CREATE TABLE DUAN(
MaDA NVARCHAR(10) PRIMARY KEY,
TenDA NVARCHAR(50) not null, 
DiaDiemDA NVARCHAR(100) not null
)

CREATE TABLE NHANVIEN(
MANV NVARCHAR(10) PRIMARY KEY,
HOTEN NVARCHAR(50) not null, 
GIOITINH NVARCHAR(3), 
LUONG money
)

CREATE TABLE CTDA(
MANV NVARCHAR(10), 
MADA NVARCHAR(10), 
SoGio int not null,
PRIMARY KEY(MANV, MADA),
FOREIGN KEY(MADA) REFERENCES DUAN(MaDA),
FOREIGN KEY(MANV) REFERENCES NHANVIEN(MANV)
)
go
--Câu 2: Chèn thông tin vào các bảng 
--- Tạo Stored Procedure (SP) với các tham số đầu vào phù hợp DUDAN, NHANVIEN, CTDA
--- Yêu cầu mỗi SP phải kiểm tra tham số đầu vào. Với các cột không chấp nhận thuộc tính Null. Với mỗi SP viết 3 lời gọi thành công.
IF OBJECT_ID('sp_Insert_DUDA') is not null
DROP PROC sp_Insert_DUDA
go
CREATE PROC sp_Insert_DUDA(
						@MaDA NVARCHAR(10),
						@TenDA NVARCHAR(50), 
						@DiaDiemDA NVARCHAR(100)
						)
AS
BEGIN
	BEGIN TRY
		IF @MaDA is null or @TenDA is null or @DiaDiemDA is null
			PRINT N'Vui long nhap day du thong tin'
		ELSE
			BEGIN
				INSERT DUAN VALUES(@MaDA, @TenDA, @DiaDiemDA)
				PRINT N'Them thanh cong'
			END
	END TRY
	BEGIN CATCH
		PRINT N'Them that bai' + ERROR_MESSAGE()
	END CATCH
END
go
EXEC sp_Insert_DUDA  'A01',N'Du an 1',N'Ha Noi'
EXEC sp_Insert_DUDA  'A02',N'Du an 2',N'HCM'
EXEC sp_Insert_DUDA  'A03',N'Du an 3',N'Ha Noi'
EXEC sp_Insert_DUDA  NULL,N'Du an 1',N'Ha Noi'
go
--
IF OBJECT_ID('sp_Insert_NHANVIEN') is not null
DROP PROC sp_Insert_NHANVIEN
go
CREATE PROC sp_Insert_NHANVIEN(
						@MANV NVARCHAR(10),
						@HOTEN NVARCHAR(50), 
						@GIOITINH NVARCHAR(3), 
						@LUONG money
						)
AS
BEGIN
BEGIN TRY
		IF @MANV is null or @HOTEN is null or @GIOITINH is null or @LUONG is null
			PRINT N'Vui long nhap day du thong tin'
		ELSE
			BEGIN
				INSERT NHANVIEN VALUES(@MANV, @HOTEN, @GIOITINH, @LUONG)
				PRINT N'Them thanh cong'
			END
	END TRY
	BEGIN CATCH
		PRINT N'Them that bai' + ERROR_MESSAGE()
	END CATCH
END
go
EXEC sp_Insert_NHANVIEN  'N01',N'Nguyen Thu Nghia',N'Nữ',1500
EXEC sp_Insert_NHANVIEN  'N02',N'Nguyen The Anh',N'Nam',2500
EXEC sp_Insert_NHANVIEN  'N03',N'Nguyen Duc Dinh',N'Nam',1000
EXEC sp_Insert_NHANVIEN  NULL,N'Nguyen Duc Dinh',N'Nam',1000
go
--
IF OBJECT_ID('sp_Insert_CTDA') is not null
DROP PROC sp_Insert_CTDA
go
CREATE PROC sp_Insert_CTDA(
						@MANV NVARCHAR(10), 
						@MADA NVARCHAR(10), 
						@SoGio int
						)
AS
BEGIN
	BEGIN TRY
		IF @MANV is null or @MADA is null or @SoGio is null
			PRINT N'Vui long nhap day du thong tin'
		ELSE
			BEGIN
				INSERT CTDA VALUES(@MANV, @MADA, @SoGio)
				PRINT N'Them thanh cong'
			END
	END TRY
	BEGIN CATCH
		PRINT N'Them that bai' + ERROR_MESSAGE()
	END CATCH
END
go
EXEC sp_Insert_CTDA 'N01','A01',3 
EXEC sp_Insert_CTDA 'N01','A02',3 
EXEC sp_Insert_CTDA 'N02','A03',3 
EXEC sp_Insert_CTDA 'N03','A03',3 
EXEC sp_Insert_CTDA NULL,'A03',3 
go
SELECT * FROM DUAN
SELECT * FROM NHANVIEN
SELECT * FROM CTDA

--Câu 3: Xây dựng hàm đầu vào là MaNV. Hàm trả về tổng số dự án mà NV này tham gia.
IF OBJECT_ID('fn_TSDA') is not null
DROP FUNCTION fn_TSDA
go
CREATE FUNCTION fn_TSDA(@MaNV NVARCHAR(10))
RETURNS INT
AS
BEGIN
	RETURN(SELECT COUNT(MADA)
		   FROM CTDA
		   WHERE MANV = @MaNV)
END
go
SELECT dbo.fn_TSDA ('N01') as [TongSoDA]
go

--Câu 3b: Xây dựng hàm đầu vào là MaNV. Hàm trả về tổng số giờ mà Nhân viên này đã thực hiện.
IF OBJECT_ID('fn_TongSoGio') is not null
DROP FUNCTION fn_TongSoGio
go
CREATE FUNCTION fn_TongSoGio(@MaNV nvarchar(10))
RETURNS INT
AS
BEGIN
	RETURN(SELECT SUM(SoGio)
			FROM CTDA
			WHERE MANV = @MaNV)
END
go
SELECT dbo.fn_TongSoGio ('N01') as [Tổng số giờ]
go
--Câu 3c: Xây dựng hàm đầu vào là MaDA. Hàm trả về tổng số nhân viên thực hiện dự án truyền vào.
IF OBJECT_ID('fn_TSNV') is not null
DROP FUNCTION fn_TSNV
go
CREATE FUNCTION fn_TSNV (@MaDA nvarchar(10))
RETURNS INT
AS
BEGIN
	RETURN(SELECT COUNT(MANV)
			FROM CTDA
			WHERE MADA = @MaDA
			)
END
go
SELECT dbo.fn_TSNV ('A01') as [Tổng số nhân viên]
go

--Câu 3d: Xây dựng hàm đầu vào là MaDA. Hàm trả về tổng giờ thực hiện của dự án truyền vào.
IF OBJECT_ID('fn_TongSoGio_DA') is not null
DROP FUNCTION fn_TongSoGio_DA
go
CREATE FUNCTION fn_TongSoGio_DA(@MaDA nvarchar(10))
RETURNS INT
AS
BEGIN
	RETURN(SELECT SUM(SoGio)
			FROM CTDA
			WHERE MADA = @MaDA)
END
go
SELECT dbo.fn_TongSoGio_DA ('A01') as [Tổng giờ thực hiện DA]
SELECT dbo.fn_TongSoGio_DA ('A02') as [Tổng giờ thực hiện DA]
go

--Câu 3e: Xây dựng hàm đầu vào là Tên đăng nhập (Phần đầu của email). Hàm trả về kết quả là MSSV:
--VD: DangLMPH00123 => trả về MSSV: PH00123.
IF OBJECT_ID('fn_MSSV') is not null
DROP FUNCTION fn_MSSV
go
CREATE FUNCTION fn_MSSV(@TenDN VARCHAR(250))
RETURNS VARCHAR(250)
BEGIN
	RETURN(SELECT SUBSTRING(@TenDN, CHARINDEX('PH',@TenDN, 1), 7))
END
go
SELECT dbo.fn_MSSV ('DangLMPH00123') AS MSSV
go
--Câu 3f: Xây dựng hàm đầu vào là số giờ công. Hàm trả về tiền lương cơ bản của tháng. 
--Biết tiền lương cơ bản = số giờ * 22 * 50000
IF OBJECT_ID('fn_LuongCoBan') is not null
DROP FUNCTION fn_LuongCoBan
go
CREATE FUNCTION fn_LuongCoBan (@SoGioCong int)
RETURNS MONEY
AS
BEGIN
	RETURN(SELECT(@SoGioCong * 22 * 50000))
END
go
SELECT dbo.fn_LuongCoBan(12) as [Tiền lương cơ bản]
go

--Câu 3g: Xây dựng hàm đầu vào là biển số xe máy. Hàm trả về tỉnh thành quản lý xe máy đó. 
--Trong đó: biển số bắt đầu là 20: Thái Nguyên, 98: Bắc Giang, 99: Bắc Ninh: còn lại: Việt Nam.
IF OBJECT_ID('fn_TTQL_XeMay') is not null
DROP FUNCTION fn_TTQL_XeMay
go
CREATE FUNCTION fn_TTQL_XeMay(@BienSoXe varchar(50))
RETURNS varchar(50)
AS
BEGIN
	RETURN(SELECT
			CASE
				WHEN LEFT(@BienSoXe, 2)='20' THEN N'Thai Nguyen'
				WHEN LEFT(@BienSoXe, 2)='98' THEN N'Bac Giang'
				WHEN LEFT(@BienSoXe, 2)='99' THEN N'Bac Ninh'
				ELSE N'Viet Nam'
			END
			)				
END
go
SELECT dbo.fn_TTQL_XeMay('99-D1 74635') AS [Tỉnh thành quản lý xe máy]
SELECT dbo.fn_TTQL_XeMay('29-S1 03820') AS [Tỉnh thành quản lý xe máy]
go

--Câu 3h:  Viết hàm các tham số đầu vào tương ứng với các cột của bảng NHANVIEN. 
--Hàm này trả về MaNV thỏa mãn các giá trị được truyền tham số.
IF OBJECT_ID('fn_TTNV') is not null
DROP FUNCTION fn_TTNV
go
CREATE FUNCTION fn_TTNV (
						@MANV NVARCHAR(10),
						@HOTEN NVARCHAR(50), 
						@GIOITINH NVARCHAR(3), 
						@LUONG money)
RETURNS TABLE
AS
	RETURN(SELECT MANV FROM NHANVIEN
			WHERE MANV = @MANV
			AND HOTEN = @HOTEN
			AND GIOITINH = @GIOITINH
			AND LUONG = @LUONG
			)
go
SELECT * FROM fn_TTNV ('N03',N'Nguyen Duc Dinh',N'Nam',1000)
go
--Câu 3i:  Viết hàm các tham số đầu vào tương ứng với các cột của bảng DUAN.
--Hàm này trả về MaDA thỏa mãn các giá trị được truyền tham số.
IF OBJECT_ID('fn_TTDA') is not null
DROP FUNCTION fn_TTDA
go
CREATE FUNCTION fn_TTDA(
	@MaDA NVARCHAR(10),
	@TenDA NVARCHAR(50), 
	@DiaDiemDA NVARCHAR(100)
)
RETURNS TABLE
AS
	RETURN(SELECT MADA
			FROM DUAN
			WHERE MaDA = @MaDA
			AND TenDA = @TenDA
			AND DiaDiemDA = @DiaDiemDA
			)
go
SELECT * FROM fn_TTDA('A03',N'Du an 3',N'Ha Noi')

--Câu 3j: Xây dựng hàm đầu vào là email FPT của SV Poly. Hàm trả về kết quả là MSSV:
--VD: DangLMPH00123@fpt.edu.vn => trả về MSSV: PH00123
IF OBJECT_ID('fn_MSSV') is not null
DROP FUNCTION fn_MSSV
go
CREATE FUNCTION fn_MSSV(@email varchar(250))
RETURNS varchar(250)
AS
BEGIN
	RETURN(SELECT SUBSTRING(@email, CHARINDEX('PH',@email, 1), 7))
END
go
SELECT dbo.fn_MSSV('NghiaNTTPH00123@fpt.edu.vn') as [MSSV]
go

--Câu 4: Tạo View lưu thông tin của TOP 2 Nhân viên có tổng số giờ làm việc nhiều nhất: MaNV, HoTen, gioiTinh, tổng số giờ. 
IF OBJECT_ID('vw_TOP2') is not null
DROP VIEW vw_TOP2
go
CREATE VIEW vw_TOP2
AS
	SELECT TOP(2) nv.MANV, HOTEN, GIOITINH, SUM(SoGio) as TongSoGioLV
	FROM NHANVIEN nv join CTDA ct ON nv.MANV = ct.MANV
	GROUP BY nv.MANV, HOTEN, GIOITINH
	ORDER BY TongSoGioLV DESC
go
SELECT * FROM vw_TOP2
go

--Câu 4a: Tạo View lưu thông tin của TOP 2 dự án có số nhân viên nhiều nhất: MaDA, TenDA, tổng số nhân viên.
IF OBJECT_ID('vw_TOP2') is not null
DROP VIEW vw_TOP2
go
CREATE VIEW vw_TOP2
AS
	SELECT TOP(2) da.MaDA, TenDA, COUNT(MANV) as [Tổng số nhân viên]
	FROM DUAN da join CTDA ct ON da.MaDA = ct.MADA
	GROUP BY da.MADA, TenDA
	ORDER BY [Tổng số nhân viên] DESC
go
SELECT * FROM vw_TOP2
go
--Câu 5:  Viết một SP nhận một tham số đầu vào MaNV. 
--SP này thực hiện thao tác xóa thông tin nhân viên và CTDA của nhân viên thỏa mãn tham số đầu vào. 
--Yêu cầu: Sử dụng giao dịch trong thân SP, để đảm bảo tính toàn vẹn dữ liệu khi một thao tác xóa thực hiện không thành công.
IF OBJECT_ID('sp_Xoa_TTNV') is not null
DROP PROC sp_Xoa_TTNV
go
CREATE PROC sp_Xoa_TTNV @MaNV nvarchar(10)
AS
BEGIN
	BEGIN TRY
		BEGIN TRAN
			DELETE FROM CTDA
			WHERE MANV = @MaNV
			DELETE FROM NHANVIEN
			WHERE MANV = @MaNV
		COMMIT
		PRINT N'Xoa thanh cong'
	END TRY
	BEGIN CATCH
		ROLLBACK TRAN
		PRINT N'Xoa that bai'
	END CATCH
END
go
EXEC sp_Xoa_TTNV 'N02'
SELECT * FROM NHANVIEN
SELECT * FROM CTDA
go

--Câu 5b:  Viết một SP nhận một tham số đầu vào MaDA. 
--SP này thực hiện thao tác xóa thông tin dự án thỏa mãn tham số đầu vào. Lưu ý: xóa dữ liệu liên quan.
--Yêu cầu: Sử dụng giao dịch trong thân SP, để đảm bảo tính toàn vẹn dữ liệu khi một thao tác xóa thực hiện không thành công.
IF OBJECT_ID('sp_Xoa_TTDA') is not null
DROP PROC sp_Xoa_TTDA
go
CREATE PROC sp_Xoa_TTDA @MaDA nvarchar(10)
AS
BEGIN
	BEGIN TRY
		BEGIN TRAN
			DELETE FROM CTDA
			WHERE MaDA = @MaDA
			DELETE FROM DUAN
			WHERE MaDA = @MaDA
		COMMIT
		PRINT N'Xoa thanh cong'
	END TRY
	BEGIN CATCH
		ROLLBACK TRAN
		PRINT N'Xoa that bai'
	END CATCH
END
go
EXEC sp_Xoa_TTDA 'A01'
SELECT * FROM DUAN
SELECT * FROM CTDA
go

--Câu 5c:  Viết một SP nhận một tham số đầu vào luong. 
--SP này thực hiện thao tác xóa thông tin nhân viên và CTDA của nhân viên có lương < tham số truyền vào.
--Yêu cầu: Sử dụng giao dịch trong thân SP, để đảm bảo tính toàn vẹn dữ liệu khi một thao tác xóa thực hiện không thành công.
CREATE PROC sp_xoa_nv_luong @Luong money
AS
BEGIN
	BEGIN TRY
		BEGIN TRAN
			DELETE FROM CTDA
			WHERE MANV in (SELECT MANV FROM NHANVIEN WHERE LUONG < @Luong)
			DELETE FROM NHANVIEN
			WHERE LUONG < @Luong
		COMMIT
		PRINT 'Xoa thanh cong'
	END TRY
	BEGIN CATCH
		ROLLBACK TRAN
		PRINT 'Xoa that bai'
	END CATCH
END
go
EXEC sp_xoa_nv_luong 2000
SELECT * FROM NHANVIEN
SELECT * FROM CTDA