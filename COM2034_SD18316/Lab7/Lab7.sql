use QLDA
go
--Bài 1:
--Viết các hàm:
-- Nhập vào MaNV cho biết tuổi của nhân viên này.
IF OBJECT_ID('fn_TuoiNV') is not null
DROP FUNCTION fn_TuoiNV
go
CREATE FUNCTION fn_TuoiNV(@MaNV nvarchar(9))
RETURNS int
as
BEGIN
	RETURN (SELECT (YEAR(GETDATE())-YEAR(NGSINH))
			FROM NHANVIEN
			WHERE MANV = @MaNV
			)
END
go
SELECT dbo.fn_TuoiNV('001') as TuoiNV
go

-- Nhập vào Manv cho biết số lượng đề án nhân viên này đã tham gia
IF OBJECT_ID('fn_SLDA_tg') is not null
DROP FUNCTION fn_SLDA_tg
go
CREATE FUNCTION fn_SLDA_tg(@MaNV nvarchar(9))
RETURNS int
as
BEGIN
	RETURN(SELECT COUNT(*)
		   FROM PHANCONG
		   WHERE MA_NVIEN = @Manv)
END
go
SELECT dbo.fn_SLDA_tg('001') as SLDA
go

-- Truyền tham số vào phái nam hoặc nữ, xuất số lượng nhân viên theo phái
IF OBJECT_ID('fn_Phai') is not null
DROP FUNCTION fn_Phai
go
CREATE FUNCTION fn_Phai(@Phai nvarchar(3) = N'Nam')
RETURNS int
BEGIN
	RETURN(SELECT COUNT(MANV)
		   FROM NHANVIEN
		   WHERE PHAI = @Phai
		  )
END
go
SELECT dbo.fn_Phai(N'Nữ') as SLNV
go

-- Truyền tham số đầu vào là tên phòng, tính mức lương trung bình của phòng đó, Cho biết
--họ tên nhân viên (HONV, TENLOT, TENNV) có mức lương trên mức lương trung bình của phòng đó.
IF OBJECT_ID('fn_LuongTB') is not null
DROP FUNCTION fn_LuongTB
go
CREATE FUNCTION fn_LuongTB(@TenPHG int)
RETURNS TABLE
as
	RETURN (SELECT HONV+' '+TENLOT+' '+TENNV as Hoten, LUONG
			FROM NHANVIEN
			WHERE LUONG > (SELECT AVG(LUONG) FROM NHANVIEN)
			and PHG = @TenPHG
			)
go
SELECT * FROM fn_LuongTB(1)
go

-- Truyền tham số đầu vào là Mã Phòng, cho biết tên phòng ban, họ tên người trưởng phòng
--và số lượng đề án mà phòng ban đó chủ trì.
IF OBJECT_ID('fn_SLDA_pb') is not null
DROP FUNCTION fn_SLDA_pb
go
CREATE FUNCTION fn_SLDA_pb(@MaPHG nvarchar(9))
RETURNS TABLE
as
	RETURN(SELECT TENPHG, HONV+' '+TENLOT+' '+TENNV as 'Họ tên'
		   
		   FROM PHONGBAN pb join NHANVIEN nv ON pb.MAPHG = nv.PHG
							join PHANCONG pc ON pc.MA_NVIEN = nv.MANV
		   WHERE TRPHG = @MaPHG
		   and MANV = TRPHG)
go
SELECT * FROM fn_SLDA_pb('006')
go

--Bài 2:
--Hiển thị thông tin HoNV,TenNV,TenPHG, DiaDiemPhg.
IF OBJECT_ID('vw_TTNV') is not null
DROP VIEW vw_TTNV
go
CREATE VIEW vw_TTNV
AS
	SELECT HONV, TENNV, TENPHG, DIADIEM
	FROM PHONGBAN pb
		 inner join NHANVIEN nv ON nv.PHG = pb.MAPHG
		 inner join DIADIEM_PHG dp ON pb.MAPHG = dp.MAPHG
go
SELECT * FROM vw_TTNV
go

--Hiển thị thông tin TenNv, Lương, Tuổi.
IF OBJECT_ID('vw_TTNV_2') is not null
DROP VIEW vw_TTNV_2
go
CREATE VIEW vw_TTNV_2
AS
	SELECT TENNV, LUONG, DATEDIFF(YEAR, NGSINH, GETDATE()) as TUOI
	FROM NHANVIEN
go
SELECT * FROM vw_TTNV_2
go

--Hiển thị tên phòng ban và họ tên trưởng phòng của phòng ban có đông nhân viên nhất.
IF OBJECT_ID('vw_TTNV_3') is not null
DROP VIEW vw_TTNV_3
go
CREATE VIEW vw_TTNV_3
AS
	SELECT TENPHG,HONV,TENNV 
	FROM NHANVIEN inner join PHONGBAN ON PHG = MAPHG
	WHERE TRPHG = MANV
	and MAPHG in (SELECT TOP(1) PHG FROM NHANVIEN
					GROUP BY PHG
					ORDER BY COUNT(*) DESC)
go
SELECT * FROM vw_TTNV_3
