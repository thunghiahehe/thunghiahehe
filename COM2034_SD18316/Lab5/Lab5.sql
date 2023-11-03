--Bài 1:
--Viết stored-procedure:
/* In ra dòng ‘Xin chào’ + @ten với @ten là tham số đầu vào là tên Tiếng Việt có dấu của bạn. Gợi ý:
	-- sử dụng UniKey để gõ Tiếng Việt
	-- chuỗi unicode phải bắt đầu bởi N (vd: N’Tiếng Việt’) 
	-- dùng hàm cast (<biểuThức> as <kiểu>) để đổi thành kiểu <kiểu> của<biểuThức>.
*/
IF OBJECT_ID ('sp_name') is not null
	DROP PROC sp_name
go
CREATE PROC sp_name @name nvarchar(20) 
AS
BEGIN
	PRINT N'Xin chào: ' + CAST(@name as nvarchar(20))
END
go
EXEC sp_name N'Nguyễn Thu Nghĩa'
go

-- Nhập vào 2 số @s1,@s2. In ra câu ‘Tổng là : @tg’ với @tg=@s1+@s2.
IF OBJECT_ID ('sp_tong') is not null
	DROP PROC sp_tong
go
CREATE PROC sp_tong @so1 int, @so2 int
AS
BEGIN
	DECLARE @tg int =0
	SET @tg = @so1 + @so2 
	PRINT N'Tổng là: ' + CONVERT(varchar, @tg)
END
go
EXEC sp_tong 12,7
go

-- Nhập vào số nguyên @n. In ra tổng các số chẵn từ 1 đến @n.
IF OBJECT_ID ('sp_soNguyen') is not null
	DROP PROC sp_soNguyen
go
CREATE PROC sp_soNguyen @n int
AS
BEGIN
	DECLARE @tong int =0, @count int =2
	WHILE @count <= @n
	BEGIN
		SET @tong = @tong + @count
		SELECT @count +=2
	END
	PRINT N'Tổng các số chẵn từ 1 - n là: ' + CONVERT(varchar, @tong)
END
go
EXEC sp_soNguyen 10
go

/* Nhập vào 2 số. In ra ước chung lớn nhất của chúng theo gợi ý dưới đây:
	-- b1. Không mất tính tổng quát giả sử a <= A 
	-- b2. Nếu A chia hết cho a thì : (a,A) = a ngược lại : (a,A) = (A%a,a) hoặc (a,A) = (a,A-a) 
	-- b3. Lặp lại b1,b2 cho đến khi điều kiện trong b2 được thỏa mãn
*/
IF OBJECT_ID ('sp_UCLN') is not null
	DROP PROC sp_UCLN
go
CREATE PROC sp_UCLN @a int, @b int
AS
BEGIN
	WHILE @a != @b
	BEGIN
		IF(@a > @b)
			SET @a = @a - @b
		ELSE
			SET @b = @b - @a
	END
	PRINT N'Ước chung lớn nhất là: '+ CAST(@a as varchar)
END
go
EXEC sp_UCLN 7,12
go

--Bài 2:
--Sử dụng cơ sở dữ liệu QLDA, Viết các Proc:
use QLDA
go
--Nhập vào @Manv, xuất thông tin các nhân viên theo @Manv.
IF OBJECT_ID ('sp_TTNV') is not null
	DROP PROC sp_TTNV
go
CREATE PROC sp_TTNV @maNV nvarchar(9)
AS
BEGIN
	SELECT * 
	FROM NHANVIEN
	WHERE MANV = @maNV
END
go
EXEC sp_TTNV '002'
EXEC sp_TTNV '007'
go

--Nhập vào @MaDa (mã đề án), cho biết số lượng nhân viên tham gia đề án đó
IF OBJECT_ID ('sp_DA1') is not null
	DROP PROC sp_DA1
go
CREATE PROC sp_DA1 @MaDA nvarchar(15)
AS
BEGIN
	SELECT MADA, COUNT(*) as 'So Luong NV' FROM PHANCONG
	GROUP BY MADA
	HAVING MADA = @MaDa
END
go
EXEC sp_DA1 10
go

--Nhập vào @MaDa và @Ddiem_DA (địa điểm đề án), cho biết số lượng nhân viên tham gia 
--đề án có mã đề án là @MaDa và địa điểm đề án là @Ddiem_DA
IF OBJECT_ID ('sp_DA') is not null
	DROP PROC sp_DA
go
CREATE PROC sp_DA @MaDA nvarchar(15), @Ddiem_DA nvarchar(15)
AS
BEGIN
	SELECT pb.MADA, COUNT(*) as 'So Luong NV'
	FROM PHANCONG pb inner join DEAN da ON da.MADA = pb.MADA
	WHERE da.MADA = @MaDA and DDIEM_DA = @Ddiem_DA
	GROUP BY pb.MADA
END
go
EXEC sp_DA 3, N'TP HCM'
go

--Nhập vào @Trphg (mã trưởng phòng), xuất thông tin các nhân viên có trưởng phòng là 
--@Trphg và các nhân viên này không có thân nhân.
IF OBJECT_ID ('sp_TTNV') is not null
	DROP PROC sp_TTNV
go
CREATE PROC sp_TTNV @Trphg nvarchar(9)
AS
BEGIN
	SELECT * 
	FROM NHANVIEN
	WHERE MA_NQL = @Trphg 
	AND MANV not in (SELECT DISTINCT MA_NVIEN FROM THANNHAN)
END
go
EXEC sp_TTNV '001'
EXEC sp_TTNV '002'
EXEC sp_TTNV '005'
go
--Nhập vào @Manv và @Mapb, kiểm tra nhân viên có mã @Manv có thuộc phòng ban có mã @Mapb hay không
IF OBJECT_ID ('sp_KTNV') is not null
	DROP PROC sp_KTNV
go
CREATE PROC sp_KTNV @MaNV nvarchar(9), @MaPB int
AS
BEGIN
	IF EXISTS (SELECT * FROM NHANVIEN
				WHERE PHG = @MaPB AND MANV = @MaNV)
		PRINT N'Có thuộc'
	ELSE
		PRINT N'Không thuộc'
END
go
EXEC sp_KTNV '001',4
EXEC sp_KTNV '001',5

