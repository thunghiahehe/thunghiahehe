use QLDA
go
DECLARE @LuongMax float
SELECT @LuongMax = MAX(LUONG)
FROM NHANVIEN
WHERE PHAI like N'[Nam]'
print N'Lýõng nv nam max: ' + CONVERT(nvarchar,@LuongMax)

--2
DECLARE @NV1960 TABLE(
MANV nvarchar(9),
HOTEN nvarchar(47),
NGSINH datetime,
GioiTinh nvarchar(3)
)
INSERT INTO @NV1960
	SELECT MANV, HONV+' '+TENLOT+' '+TENNV as Hoten, NGSINH, PHAI
	FROM NHANVIEN WHERE YEAR(NGSINH) = 1960
SELECT * FROM @NV1960
