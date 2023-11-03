use QLDA
go
/*1. TẠO HÀM GIÁ TRỊ VÔ HƯỚNG
	CREATE FUNCTION TENHAM(
		@ts1 kieuDL = GiaTriMacDinh_NeuCo
		@ts2 kieuDL = GiaTriMacDinh_NeuCo
		.......
	)
	RETURNS kieuDL vô hướng

	AS
	BEGIN
		RETURN biểu thức vô hướng
	END
*/
--VD1: Xây dựng hàm tính tuổi: Đầu vào: năm sinh
IF OBJECT_ID ('fn_TinhTong') is not null
	DROP FUNCTION fn_TinhTong
go
CREATE FUNCTION fn_TinhTong (@namsinh int =2004)
RETURNS INT
AS
BEGIN
	RETURN(YEAR(GETDATE()) - @namsinh)
END
--Gọi hàm vô hướng: phải có dbo.
SELECT dbo.fn_TinhTuoi(2020)
SELECT dbo.fn_TinhTuoi(default) --dùng giá trị mặc định
PRINT N'Tuổi ' +CAST(dbo.fn_TinhTuoi(2020) as varchar)
--
DECLARE @kq int
SET @kq = dbo.fn_TinhTuoi(2020)
PRINT N'Tuổi ' +CAST(@kq as varchar)
IF @kq < 16
	PRINT N'Học sinh'
ELSE IF @kq < 16
	PRINT N'Vị thành niên'
ELSE
	PRINT N'Trưởng thành'
go
--VD2:
IF OBJECT_ID ('fn_tongNV') is not null 
	DROP FUNCTION fn_tongNV
go
	CREATE FUNCTION fn_tongNV() 
	RETURNS int 
	AS
	BEGIN
		RETURN (SELECT COUNT(MANV) FROM NHANVIEN)
	END
--Gọi hàm
SELECT dbo.fn_tongNV() as TongNV
go
--VD3: Đếm số lượng nhân viên theo phái
IF OBJECT_ID('fn_DemNVPhai') is not null
	DROP FUNCTION fn_DemNVPhai
go
CREATE FUNCTION fn_DemNVPhai(@phai nvarchar(3) ='Nam')
RETURNS int
AS
BEGIN
	RETURN(SELECT COUNT(MANV) 
			FROM NHANVIEN
			WHERE PHAI like @phai)
END
go
--Gọi hàm
SELECT dbo.fn_DemNVPhai(default) as SoNVNam
SELECT dbo.fn_DemNVPhai(N'Nữ') as SoNVNu
go
/*2. HÀM GIÁ TRỊ BẢNG ĐƠN GIẢN
	CREATE FUNCTION TENHAM(
		@ts1 kieuDL = GiaTriMacDinh_NeuCo
		@ts2 kieuDL = GiaTriMacDinh_NeuCo
		.......
	)
	RETURNS TABLE
	AS
		RETURN <câu lệnh> SELECT
*/
--VD1: Tạo hàm đầu vào MAPHG. Hàm trả về thông tin NV của phòng truyền vào thông tin: MANV, HOTEN, PHAI
IF OBJECT_ID('fn_TTNV_Phong_da') is not null
	DROP FUNCTION fn_TTNV_Phong_da
go
CREATE FUNCTION fn_TTNV_Phong_da(@MaPHG int)
	RETURNS TABLE
AS
	RETURN(SELECT MANV, HONV+' '+TENLOT+' '+TENNV as Hoten, PHAI 
			FROM NHANVIEN
			WHERE PHG like @MaPHG)
go
--Gọi hàm BẢNG ĐƠN CÂU LỆNH: KHÔNG BẮT BUỘC có dbo.
SELECT * FROM fn_TTNV_Phong_da(5)
SELECT * FROM fn_TTNV_Phong_da(5) fn join NHANVIEN nv ON fn.MANV = nv.MANV
go

/*3. HÀM GIÁ TRỊ BẢNG ĐA CÂU LỆNH
	CREATE FUNCTION TENHAM(
		@ts1 kieuDL = GiaTriMacDinh_NeuCo
		@ts2 kieuDL = GiaTriMacDinh_NeuCo
		.......
	)
	RETURNS @BienBang TABLE
		(--giống cú pháp tạo bảng
			TenCot1 kieuDL,
			TenCot2 kieuDL,
			...
		)
	AS
	BEGIN
		--Các lệnh. Nên có lệnh INSERT để dữ liệu vào @BienBang
		RETURN
	END
*/

IF OBJECT_ID('fn_TTNV_Phong_da') is not null
	DROP FUNCTION fn_TTNV_Phong_da
go
CREATE FUNCTION fn_TTNV_Phong_da(@MaPHG int)
	RETURNS @Bang TABLE(
						MaNV nvarchar(9),
						Hoten nvarchar(47),
						Phai nvarchar(3)
						)
AS
BEGIN
	INSERT @Bang
	SELECT MANV, HONV+' '+TENLOT+' '+TENNV as Hoten, PHAI 
			FROM NHANVIEN
			WHERE PHG like @MaPHG
	RETURN
END
go
--Gọi hàm BẢNG ĐA CÂU LỆNH: KHÔNG BẮT BUỘC có dbo.
SELECT * FROM fn_TTNV_Phong_da(5)
SELECT * FROM fn_TTNV_Phong_da(5) fn join NHANVIEN nv ON fn.MANV = nv.MANV

/*VIEW
	--Cú pháp:
	CREATE VIEW TenView
	AS
		<câu lệnh> SELECT
	--Xem dữ liệu:
	SELECT * FROM TenView
*/