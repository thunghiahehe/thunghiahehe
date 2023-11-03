--1. Tìm các nhân viên làm việc ở phòng số 4
select * from NHANVIEN nv where nv.PHG=4

--2. Tìm các nhân viên có mức lương trên 30000
select * from NHANVIEN nv where nv.LUONG>30000

--3. Tìm các nhân viên có mức lương trên 25,000 ở phòng 4 
--hoặc các nhân viên có mức lương trên 30,000 ở phòng 5
select * from NHANVIEN nv where nv.PHG=4 and nv.LUONG>25000 or nv.PHG=5 and nv.LUONG>30000

--4. Cho biết họ tên đầy đủ của các nhân viên ở TP HCM
select HONV+' '+TENLOT+' '+TENNV as Hoten, DCHI from NHANVIEN where DCHI like N'%Tp [hcm]%'
select * from NHANVIEN

--5. Cho biết họ tên đầy đủ của các nhân viên có họ bắt đầu bằng ký tự 'N'
select HONV+' '+TENLOT+' '+TENNV as Hoten from NHANVIEN where HONV like '%N'

--6. Cho biết ngày sinh và địa chỉ của nhân viên Dinh Ba Tien
select NGSINH,DCHI from NHANVIEN where HONV=N'Đinh' and TENLOT=N'Bá' and TENNV=N'Tiên'
