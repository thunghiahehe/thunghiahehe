DECLARE @TongPB int
SELECT @TongPB = COUNT(MAPHG)
FROM PHONGBAN
print N'Tổng số phòng ban: '+ CONVERT(varchar, @TongPB)
print N'Tổng số phòng ban: '+ CAST(@TongPB as varchar)

DECLARE @ThongTin TABLE(
MANV nvarchar(9),
TongTgian float
)
INSERT INTO @ThongTin
SELECT MA_NVIEN, SUM(THOIGIAN) as TongTgian
FROM PHANCONG
group by MA_NVIEN

SELECT tt.MANV, tt.TongTgian, TENNV, CONVERT(varchar, NGSINH,101) as NGSINH, 
	   DATEDIFF(YEAR,NGSINH,GETDATE()) as Tuoi
FROM @ThongTin tt join NHANVIEN nv ON tt.MANV = nv.MANV 



