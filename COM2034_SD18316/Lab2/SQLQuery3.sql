--1. Cho biết thông tin về Phòng Ban
	SELECT * FROM PHONGBAN

--2. Cho biết thông tin về Nhân Viên
	SELECT * FROM NHANVIEN

--3. Cho biết thông tin về Công việc
	SELECT * FROM CONGVIEC

--4. Cho biết thông tin về Nhân Viên và Phòng Ban của họ: 
--Mã NV, họ tên, ngày sinh, địa chỉ, mã phòng, tên phòng, mã trưởng phòng
	SELECT MANV, HONV+' '+TENLOT+' '+TENNV as Hoten, NGSINH, DCHI, MAPHG,TENPHG,TRPHG as MaTRPhg
	FROM NHANVIEN nv join PHONGBAN pb ON nv.PHG=pb.MAPHG

--5. Giống câu 4, nhưng chỉ đưa ra thông tin các nhân viên của phòng Nghiên cứu.
	SELECT MANV, HONV+' '+TENLOT+' '+TENNV as Hoten, NGSINH, DCHI, MAPHG,TENPHG,TRPHG as MaTRPHG
	FROM NHANVIEN nv join PHONGBAN pb ON nv.PHG=pb.MAPHG WHERE TENPHG like N'Nghiên Cứu'

--6. Cho biết thông tin về nhân viên và công việc của họ: 
--MaNV, họ tên, mã phòng, Thời gian, tên công việc
	SELECT MANV, HONV+' '+TENLOT+' '+TENNV as Hoten, PHG, THOIGIAN, TEN_CONG_VIEC
	FROM NHANVIEN nv join PHANCONG pc ON nv.MANV=pc.MA_NVIEN 
					 join CONGVIEC cv ON cv.MADA=pc.MADA and cv.STT=pc.STT

--7. Cho biết thông tin công việc của phòng Điều hành: 
--MaNV, họ tên, mã phòng, Thời gian, tên công việc
	SELECT MANV, HONV+' '+TENLOT+' '+TENNV as Hoten, PHG, THOIGIAN, TEN_CONG_VIEC, TENPHG
	FROM NHANVIEN nv join PHANCONG pc ON nv.MANV=pc.MA_NVIEN 
					 join CONGVIEC cv ON cv.MADA=pc.MADA and cv.STT=pc.STT
					 join DEAN da ON da.MADA = cv.MADA
					 join PHONGBAN pb ON pb.MAPHG = da.PHONG 
					 WHERE TENPHG like N'Điều hành'
	
--8. Cho biết thông tin về Đề án của các phòng ban, kể cả những phòng ban 
--không có đề án nào: mã phòng, tên phòng, tên đề án, địa điểm đề án.
	SELECT MAPHG, TENPHG, TENDEAN, DDIEM_DA
	FROM PHONGBAN pb left join DEAN da ON pb.MAPHG=da.PHONG

--9. Cho biết thông tin về số đề án của mỗi phòng, kể cả những phòng không có đề án nào: 
--Mã phòng, tên phòng, tổng số đề án.
	SELECT MAPHG, TENPHG, COUNT(MADA) as TongSoDA
	FROM PHONGBAN pb left join DEAN da ON pb.MAPHG=da.PHONG
	GROUP BY MAPHG, TENPHG

--10. Cho biết thông tin các phòng không có đề án nào: Mã phòng, tên phòng.
	--C1*:
	SELECT MAPHG, TENPHG
	FROM PHONGBAN pb left join DEAN da ON pb.MAPHG=da.PHONG
	WHERE TENDEAN is null
	--C2:
	SELECT MAPHG, TENPHG, COUNT(MADA) as TongSoDA
	FROM PHONGBAN pb left join DEAN da ON pb.MAPHG=da.PHONG
	GROUP BY MAPHG, TENPHG
	HAVING COUNT(MADA)=0
	--C3:
	SELECT MAPHG, TENPHG
	FROM PHONGBAN WHERE MAPHG not in (SELECT DISTINCT PHONG FROM DEAN)

--11. Cho biết thông tin về số nhân viên của từng phòng ban, kể cả những phòng ban 
--không có nhân viên nào: mã phòng, tên phòng, số nhân viên.
	SELECT MAPHG, TENPHG, COUNT(PHG) as SoNV
	FROM PHONGBAN pb left join NHANVIEN nv ON pb.MAPHG = nv.PHG
	group by MAPHG, TENPHG

--12. Thêm cột quốc tịch vào bảng Nhân viên với giá trị mặc định là Việt Nam
	

--13. Cập nhật giới tính của nhân viên có mã 002 là nam
	UPDATE NHANVIEN
	SET  PHAI = 'Nam'
	WHERE MANV = '002'

--14. Thêm thân nhân vợ cho nhân viên 017, các thông tin tự nhập

--15. Cho biết mức lương cao nhất của nhân viên
	
--16. Cho biết mức lương trung bình của nhân viên