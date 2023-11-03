--1. Cho biêt nhân viên có lương cao nhất 
declare @maxLuong float
set @maxLuong=(
	select MAX(luong) from nhanVien
)
select * from nhanVien
where nhanVien.luong=@maxLuong
--2. Cho biết họ tên nhân viên (HONV, TENLOT, TENNV) có mức lương trên mức lương trung bình của phòng "Nghiên cứu” 
--declare @luongTrungBinh float
--set @luongTrungBinh =(
--	select AVG(nhanVien.luong) from nhanVien join phongBan on nhanVien.phG=phongBan.maPB
--	where nhanVien.phG=phongBan.maPB and phongBan.tenPB=N'Nghiên cứu'
--)
declare @luongTrungBinh float
set @luongTrungBinh = (
	select AVG(luong) from nhanVien join phongBan on nhanVien.phG=phongBan.maPB
	where phongBan.tenPB=N'Nghiên cứu'
)

select hoNV+tenLot+tenNV as N'Mức lương trên trung bình'
-- 3. Với các phòng ban có mức lương trung bình trên 30,000, liệt kê tên phòng ban và số lượng nhân viên của phòng ban đó.
DECLARE @lab2_3 TABLE (MAPHG int, TENPHG varchar(15), LUONG float, SoLuong int)
INSERT INTO @lab2_3
SELECT nv.PHG, pb.TENPHG, AVG(nv.LUONG), COUNT(nv.MANV) 
FROM NHANVIEN nv JOIN PHONGBAN pb ON nv.PHG = pb.MAPHG 
GROUP BY nv.PHG, pb.TENPHG
HAVING AVG(nv.LUONG) > 30000
SELECT * FROM @lab2_3;

-- 4. Với mỗi phòng ban, cho biết tên phòng ban và số lượng đề án mà phòng ban đó chủ trì
DECLARE @lab2_4 TABLE (TENPHG varchar(15), SoLuong int)
INSERT INTO @lab2_4
SELECT pb.TENPHG, COUNT(da.MADA) 
FROM PHONGBAN pb JOIN DEAN da ON pb.MAPHG = da.PHONG
GROUP BY pb.TENPHG
SELECT * FROM @lab2_4