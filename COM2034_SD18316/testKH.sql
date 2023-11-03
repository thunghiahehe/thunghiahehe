--1. Tạo cơ sở dữ liệu như sau (Lưu ý: Sinh viên có thể viết code hoặc dùng tool) (1 điểm)
--     Khachhang (Makh, tenkh, diachi, dienthoai, gioitinh)
--     DonDH (Madh, ngaydh, ngaygh, makh)
CREATE DATABASE TEST
GO
USE TEST
GO
CREATE TABLE KHACHHANG(
MAKH VARCHAR(10) PRIMARY KEY, 
TENKH NVARCHAR(100) NOT NULL, 
DIACHI NVARCHAR(100) NOT NULL, 
DIENTHOAI VARCHAR(10) NOT NULL, 
GIOITINH VARCHAR(3) NOT NULL
)
GO
CREATE TABLE DONDH (
MADH VARCHAR(10) PRIMARY KEY, 
NGAYDH DATE NOT NULL, 
NGAYGH DATE NOT NULL, 
MAKH VARCHAR(10),
FOREIGN KEY(MAKH) REFERENCES KHACHHANG(MAKH)
)
GO
--2. Xây dựng thủ tục Stored Procedure (SP) với các tham số đầu vào phù hợp thêm thông tin vào các bảng trên 
-- Với mỗi SP viết 2 lời gọi thành công. (2 điểm)
IF OBJECT_ID('SP_Insert_KhachHang') is not null
DROP PROC SP_Insert_KhachHang
GO
CREATE PROC SP_Insert_KhachHang(
@MAKH VARCHAR(10), 
@TENKH NVARCHAR(100), 
@DIACHI NVARCHAR(100), 
@DIENTHOAI VARCHAR(10), 
@GIOITINH VARCHAR(3)
)
AS
BEGIN
	BEGIN TRY
		IF @MAKH is null or @TENKH is null or @DIACHI is null or @DIENTHOAI is null or @GIOITINH is null
			PRINT 'Vui long nhap day du thong tin'
		ELSE
			BEGIN
				INSERT KHACHHANG VALUES(@MAKH, @TENKH, @DIACHI, @DIENTHOAI, @GIOITINH)
				PRINT 'Them thanh cong'
			END
	END TRY
	BEGIN CATCH
		PRINT 'Them that bai '+ERROR_MESSAGE()
	END CATCH
END
go
EXEC SP_Insert_KhachHang 'N01',N'Khach hang 1',N'Ha Noi','0869574653',N'Nam'
EXEC SP_Insert_KhachHang 'N02',N'Khach hang 2',N'HCM','0869574653',N'Nu'
EXEC SP_Insert_KhachHang 'N03',N'Khach hang 3',N'Ha Noi','0869574653',N'Nam'
go
--
IF OBJECT_ID('SP_Insert_DonDH') is not null
DROP PROC SP_Insert_DonDH
GO
CREATE PROC SP_Insert_DonDH(
@MADH VARCHAR(10), 
@NGAYDH DATE, 
@NGAYGH DATE, 
@MAKH VARCHAR(10)
)
AS
BEGIN
	BEGIN TRY
		IF @MADH is null or @NGAYDH is null or @NGAYGH is null or @MAKH is null
			PRINT 'Vui long nhap day du thong tin'
		ELSE
			BEGIN
				INSERT DONDH VALUES(@MADH, @NGAYDH, @NGAYGH, @MAKH)
				PRINT 'Them thanh cong'
			END
	END TRY
	BEGIN CATCH
		PRINT 'Them that bai '+ERROR_MESSAGE()
	END CATCH
END
go
EXEC SP_Insert_DonDH 'A01','2020-10-31','2020-12-01','N01'
EXEC SP_Insert_DonDH 'A02','2022-09-04','2022-10-11','N01'
EXEC SP_Insert_DonDH 'A03','2021-08-05','2021-11-07','N02'
SELECT *FROM DONDH
SELECT *FROM KHACHHANG
go
--3. Xây dựng hàm có đầu vào là MaKH, hàm trả về tổng số lần mua hàng của MaKH truyền vào Viết lời gọi hàm. (2.5 điểm)
IF OBJECT_ID('fn_TongSL_MuaHang') is not null
DROP FUNCTION fn_TongSL_MuaHang
GO
CREATE FUNCTION fn_TongSL_MuaHang(@MaKH varchar(10))
RETURNS INT
AS
BEGIN
	RETURN(SELECT COUNT(MADH)
			FROM DONDH
			WHERE MAKH = @MaKH)
END
GO
SELECT dbo.fn_TongSL_MuaHang('N01') as [Tổng số lần mua hàng]
go
--5. Xây dựng hàm có đầu vào là email fpt của SV poly. Hàm trả về MSSV của SV: 
--VD: đầu vào là DangLMPH00123@fpt.edu.vn
--Hàm trả về: PH00123
IF OBJECT_ID('F_GetMSSV') is not null
DROP FUNCTION F_GetMSSV
GO
CREATE FUNCTION F_GetMSSV(@email varchar(200))
RETURNS varchar(200)
AS
BEGIN
	RETURN(SELECT SUBSTRING(@email, CHARINDEX('ph', @email, 1), 7))
END
GO
SELECT dbo.F_GetMSSV('DangLMPH00123@fpt.edu.vn') as MSSV

--7. Xây dựng thủ tục xóa có đầu vào là MaKH.
--Thủ tục thực hiện xóa thông tin Đơn hàng và thông tin của KhachHang của MaKH truyền vào. (2.5 điểm)
--Yêu cầu: Sử dụng giao dịch trong thân SP, để đảm bảo tính toàn vẹn dữ liệu khi một thao tác xóa thực hiện không thành công. Viết lời gọi SP thành công.
IF OBJECT_ID('SP_XoaTT') is not null
DROP PROC SP_XoaTT
GO
CREATE PROC SP_XoaTT (@MaKH varchar(10))
AS
BEGIN
	BEGIN TRY
		BEGIN TRAN
			DELETE FROM DONDH
			WHERE MAKH = @MaKH
			DELETE FROM KHACHHANG
			WHERE MAKH = @MaKH
		COMMIT
		PRINT 'Xoa thanh cong'
	END TRY
	BEGIN CATCH
		PRINT 'Xoa that bai'
	END CATCH
END
GO
EXEC SP_XoaTT 'N02'
SELECT * FROM DONDH
SELECT * FROM KHACHHANG
GO

--8. Xây dựng View thông tin đặt hàng, bao gồm: MaKH, TenKH, DiaChi, MaDH, NgayDH, NgayGH(2 điểm)
--Trong đó:  TenKH có thêm tiền tố Anh/chị tùy theo giới tính. VD: Anh Lê Minh Đăng.
---	NgayGH, ngayDH: hiển thị kiểu dd/mm/yyyy
IF OBJECT_ID('V_TTDH') is not null
DROP VIEW V_TTDH
GO
CREATE VIEW V_TTDH
AS
	SELECT dh.MAKH,
	IIF(TENKH like N'Nam',N'Anh '+TENKH, N'Chị '+TENKH) AS [TenKH], 
	DIACHI, MADH,
	CONVERT(varchar,NGAYDH,105) AS NgayDH, 
	CONVERT(varchar,NGAYGH,105) AS NgayGH
	FROM DONDH dh join KHACHHANG kh ON dh.MAKH = kh.MAKH
go
SELECT * FROM V_TTDH
