--SỬ DỤNG CƠ SỞ DỮ LIỆU QLDA. THỰC HIỆN CÁC CÂU TRUY VẤN SAU, SỬ DỤNG 
--IF…ELSE VÀ CASE
--Bài 1
/* Viết chương trình xem xét có tăng lương cho nhân viên hay không. Hiển thị cột thứ 1 là 
TenNV, cột thứ 2 nhận giá trị
	-- “TangLuong” nếu lương hiện tại của nhân viên nhỏ hơn trung bình lương trong 
	phòng mà nhân viên đó đang làm việc. 
	-- “KhongTangLuong “ nếu lương hiện tại của nhân viên lớn hơn trung bình lương 
	trong phòng mà nhân viên đó đang làm việc.
*/
	DECLARE @THONGKE TABLE(
		MAPB INT,
		LUONGTB FLOAT
	)
	INSERT INTO @THONGKE
		SELECT PHG, AVG(LUONG)
		FROM NHANVIEN 
		GROUP BY PHG
	SELECT TENNV,LUONG,
		   CASE
		   WHEN LUONG<LUONGTB THEN N'Không tăng lương'
		   ELSE N'Tăng lương'
		   END AS TINHTRANG
	FROM NHANVIEN NV INNER JOIN @THONGKE TK ON NV.PHG=TK.MAPB
go
-- Viết chương trình phân loại nhân viên dựa vào mức lương.
-- Nếu lương nhân viên nhỏ hơn trung bình lương mà nhân viên đó đang làm việc thì 
-- xếp loại “nhanvien”, ngược lại xếp loại “truongphong”
	DECLARE @THONGKE TABLE(
		MAPB INT,
		LUONGTB FLOAT
	)
	INSERT INTO @THONGKE
		SELECT PHG, AVG(LUONG)
		FROM NHANVIEN 
		GROUP BY PHG
	SELECT TENNV,LUONG,
		   CASE
		   WHEN LUONG<LUONGTB THEN N'Nhân viên'
		   ELSE N'Trưởng phòng'
		   END AS [Xếp loại]
	FROM NHANVIEN NV INNER JOIN @THONGKE TK ON NV.PHG=TK.MAPB

-- Viết chương trình hiển thị TenNV, tùy vào cột phái của nhân viên
	SELECT TENNV=CASE
		   WHEN PHAI='Nam' THEN 'Mr.'+TENNV
		   WHEN PHAI='Nữ' THEN 'Ms.'+TENNV
		   ELSE 'Freesex.'+TENNV
		   END
	FROM NHANVIEN