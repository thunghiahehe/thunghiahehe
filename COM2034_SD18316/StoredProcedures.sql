use QLDA
go

--Cú pháp
/* CREATE PROCEDURE tenThuTuc 
		@thamso1 KieuDL [input/output] --input : tham số vào
		@thamso2 KieuDL [input/output] --output : tham số ra
		...
	as
	BEGIN 
		<Các lệnh>
	END
*/
-- Gọi thủ tục
-- EXEC <tên thủ tục> <gt1>, <gt2>

--VD1 : xây dựng thủ tục tính tổng có 2 số có 2 tham số đầu vào , ko có đầu ra
IF OBJECT_ID('spTong2So') is not null
   DROP PROC spTong2So
go
CREATE PROC spTong2So @so1 INT, @so2 INT
AS
BEGIN
DECLARE @TONG int =0
	SET @TONG = @so1 + @so2
	PRINT N'Tổng 2 số là: ' + CONVERT(varchar, @TONG)
END

-- Gọi thủ tục
EXEC spTong2So  8, 9 --truyền theo vị trí
EXEC spTong2So  18, 9
EXEC spTong2So  @so1 =8, @so2 =9 --truyền theo tham số
EXEC spTong2So  @so1 =9, @so2 =8

--VD2: Xây dựng thủ tục tính tổng 2 số có 2 tham số đaauf vào, có đầu ra dùng output
IF OBJECT_ID('sp_Tong2So_out') is not null
   DROP PROC sp_Tong2So_out
go
CREATE PROC sp_Tong2So_out @so1 int, @so2 int, @tong int OUT
as
BEGIN
	SET @tong = @so1 + @so2
END
-- Gọi thủ tục có tham số output:
	--Khai báo biến nhận kết quả: @kq
	--Gọi: EXEC <tên thủ tục> <gt1>, <gt2>, @kq out
	--Làm việc với biến @kq
DECLARE @kq int
EXEC sp_Tong2So_out 7, 8, @kq OUT --truyền theo vị trí
SELECT @kq as TONG
go
-- Gọi thủ tục
DECLARE @kq int
EXEC sp_Tong2So_out @so1 =7, @so2 =8, @tong = @kq OUT --truyền theo tham số
SELECT @kq as TONG
go

/* Thủ tục CÓ RETURN: Trong thân thủ tục có lệnh RETURN số nguyên
	--Gọi thủ tục có RETURN:
		DECLARE @kq int  --Khai báo biến nhận kết quả
		EXEC @kq = tenThuTuc <gt1>, <gt2>, ... --gọi thủ tục
		SELECT @kq --Làm việc với thủ tục
*/
IF OBJECT_ID('spTong2So_return') is not null
   DROP PROC spTong2So_return
go
CREATE PROC spTong2So_return @so1 int, @so2 INT
AS
BEGIN
DECLARE @tong int =0
	SET @tong = @so1 + @so2
	return @tong
END
go
-- Gọi thủ tục
DECLARE @kq int
EXEC @kq = spTong2So_return 17, 8 --truyền theo vị trí
SELECT @kq as TONG
go
--
DECLARE @kq int
EXEC @kq = spTong2So_return @so1 =7, @so2 =28 --truyền theo tham số
SELECT @kq as TONG

--VD3: Xây dựng thủ tục tính tổng 2 số: có 2 tham số đầu vào mặc định, không có đầu ra
IF OBJECT_ID('spTong2So_Macdinh') is not null
   DROP PROC spTong2So_Macdinh
go
CREATE PROC spTong2So_Macdinh @so1 INT=9, @so2 INT=5
as
BEGIN
DECLARE @TONG int =0
	SET @TONG = @so1 + @so2
	PRINT N'Tổng 2 số là: ' + CONVERT(varchar, @TONG)
END
go
-- Gọi thủ tục
EXEC spTong2So_Macdinh --dùng giá trị mặc định
EXEC spTong2So_Macdinh 6, 13 --không dùng giá trị mặc định
EXEC spTong2So_Macdinh @so2=20 --dùng giá trị mặc định thứ nhất
go

--VD: Tạo thủ tục: Truy xuất thông tin NHANVIEN theo MANV
	IF OBJECT_ID('sp_TTNV') is not null
	   DROP PROC sp_TTNV
	go
	CREATE PROC sp_TTNV @maNV nvarchar(9)='%'
	as
	BEGIN
		 SELECT *
		 FROM NHANVIEN WHERE MANV like @maNV
	END
go
-- Gọi thủ tục
	EXEC sp_TTNV
	EXEC sp_TTNV '001'
--VD: Tạo thủ tục có đầu vào là MAPHG, cho biết số lượng đề án của phòng truyền vào
	IF OBJECT_ID('sp_SLDAPhong') is not null
	   DROP PROC sp_SLDAPhong
	go
	CREATE PROC sp_SLDAPhong @maPHG int, @soLuongDA int =0 out
	as
	BEGIN
		SELECT @soLuongDA = COUNT(MADA)
		FROM DEAN
		WHERE PHONG = @maPHG
	END
go
-- Gọi thủ tục
	DECLARE @kq int
	EXEC sp_SLDAPhong 5, @kq out
	SELECT @kq as tongDA
go

IF OBJECT_ID('sp_SLDAPhong_Re') is not null
	   DROP PROC sp_SLDAPhong_Re
	go
	CREATE PROC sp_SLDAPhong_Re @maPHG int, @soLuongDA int =0 out
	as
	BEGIN
		SELECT @soLuongDA = COUNT(MADA)
		FROM DEAN
		WHERE PHONG = @maPHG

		return @soLuongDA
	END
go
-- Gọi thủ tục
	DECLARE @kq int
	EXEC @kq = sp_SLDAPhong_Re 5
	SELECT @kq as tongDA
	
