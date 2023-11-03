--slide 3- COM2034
-- Bài 3: Các hàm hệ thống và xử lý chuỗi

use QLDA
go

--1. Các hàm chuyển đổi kiểu dữ liệu Slide 5-18
--a. Chuyển đổi ngầm (tự đông chuyển kiểu thấp => cao)
--b. Chuyển đổi tường minh dùng cast hoặc convert
-- * cú pháp: cast(biểu thức as kiểu_dl)
	print N'Today is ' + CAST(GETDATE() as varchar)
	print N'Today is ' + CAST(GETDATE() as varchar(10))

	SELECT MANV, LUONG,
	CAST(LUONG as int) as intLuong, CAST(LUONG as varchar(15)) as varcharLuong
	FROM NHANVIEN
---------------------------------------------------------------
--* Convert: chuyển đổi tường minh
-- cú pháp: convert(kiểu_dữ_liệu, biểu thức [,định đạng])
-- Định dạng khi chuyển số sang chuỗi:xem link: http://msdn.microsoft.com/en-us/library/ms187928.aspx
-- VD1: dùng cast, convert=> in câu Ngày hôm này là + ngày hiện tại
	print N'Today is ' + CAST(GETDATE() as varchar)
	print N'Today is ' + CONVERT(varchar, getdate())
	print N'Today is ' + CONVERT(varchar, getdate(),1)
	print N'Today is ' + CONVERT(varchar, getdate(),101)

-- VD2: lấy thông tin Nhanvien: manv, hoten, ngaysinh, ngaysinh 
-- trong đó ngày sinh hiển thị theo các kiểu 
--'mm/dd/yyyy','dd/mm/yyyy','dd-mm-yyyy','mm-dd-yyyy'
	SELECT MANV, HONV+' '+TENLOT+' '+TENNV as Hoten, NGSINH,
		   CONVERT(varchar, NGSINH,101) as 'mm/dd/yyyy',
		   CONVERT(varchar, NGSINH,103) as 'dd/mm/yyyy',
		   CONVERT(varchar, NGSINH,105) as 'dd-mm-yyyy',
		   CONVERT(varchar, NGSINH,110) as 'mm-dd-yyyy'
	FROM NHANVIEN

-- VD3: Hiển thị tiền (money) theo 1 vài kiểu định dạng convert (VD1,2)
	DECLARE @Luong money = 721998122.20412272
	SELECT @Luong as TienLuong,
	CONVERT(varchar,@Luong) as column1,
	CONVERT(varchar,@Luong,0) as column2,
	CONVERT(varchar,@Luong,1) as column3,
	CONVERT(varchar,@Luong,2) as column4
---------------------------------------------------------------------
-- 2. Các hàm toán học
--VD: Thử hàm sqrt, round
	SELECT SQRT(25) as Can5, 
		   PI() as SoPi,
		   ROUND(7232.98,24) as Lamtron1
--------------------------------------
--3. Các hàm xử lý chuỗi (slide 21)
--	a. Thực hiện các thao tác với chuỗi: ' FPT POLYTECHNIC '
--	lấy độ dài, cắt khoảng trắng thừa trái, phải, cả 2.
	SELECT LEN(' FPT POLYTECHNIC ') as 'length',
		   LTRIM(' FPT POLYTECHNIC ') as KhoangTrangBenTrai,
		   RTRIM(' FPT POLYTECHNIC ') as KhoangTrangBenTrai,
		   RTRIM(LTRIM(' FPT POLYTECHNIC ')) as KhoangTrang2ben
	
--	b. Thực hiện thử hàm left,right với chuỗi 'Ha noi'
	SELECT LEFT('Ha noi',2) as catTrai,
		   RIGHT('Ha noi',3) as catPhai
	
--	c. Thử hàm subString với chuỗi: 'FPT POLYTECHNIC' --=> lấy chữ poly
--	SUBSTRING(string,start,length) => giống hàm mid trong excel
	SELECT SUBSTRING('FPT POLYTECHNIC',5,4)
	
--	d. Thử hàm CHARINDEX với chuỗi 'SQL Server'
--		select CHARINDEX('chuoicon','chuoicha',vitri bắt đầu tìm): tim vi tri 
--		xuat hien chuoi con trong chuoi cha
	SELECT CHARINDEX('er','SQL Server',1),
		   CHARINDEX('er','SQL Server',7),
		   CHARINDEX('er','SQL Server',10)

--	e. Thử hàm REPLACE: thay thế dấu phẩy -> chấm: '0973-456-226'
--	REPLACE(chuỗi_cha,chuỗi_con,chuỗi_thay_thế): 
--	VD1: 
	SELECT REPLACE('0834-045-324','-','.')
	

-- Ass: Chuyển giá phòng (money) -> về dạng 1.700.000
--(dấu chấm phân cách phần nghìn,
--dấu phẩy phân cách phần thập phân
--có 2 chữ số sau phần thập phân) 
--HD: convert dạng 1. lấy left. chuyển phẩy thành chấm.


--4. Các hàm về ngày tháng
--  Lưu ý khi nhập ngày tháng: 'mm/dd/yyyy', 'mm-dd-yyyy', 'yyyy/mm/dd','yyyy-mm-dd'
	SELECT GETDATE() as NgayGioHienTai,
		   CONVERT(date, GETDATE()) as NgayHienTai,
		   CONVERT(time, GETDATE()) as GioHienTai

	SELECT YEAR(GETDATE()) as Nam,
		   MONTH(GETDATE()) as Thang,
		   DAY(GETDATE()) as Ngay
-- DATENAME ( datepart , date ) : lấy thông tin của date theo thành phần date part
	SELECT DATENAME (YEAR, GETDATE()),
		   DATENAME (DAYOFYEAR, GETDATE()),
		   DATENAME (WEEKDAY, GETDATE()),
		   DATENAME (HOUR, GETDATE()),
		   DATENAME (MILLISECOND, GETDATE())

-- DATEADD (datepart , number , date ) : cộng number vào date theo thành phần date part
	SELECT GETDATE() as NgayHienTai,
		   DATEADD(DAY, 2, GETDATE()) as cong2Ngay,
		   DATEADD(WEEK, 2, GETDATE()) as cong2Tuan,
		   DATEADD(HOUR, 2, GETDATE()) as cong2Gio
-- DATEDIFF ( datepart , startdate , enddate ) : tính khoảng cách giữa startdate và enddate 
-- theo thành phần datepart
	SELECT MANV, TENNV, NGSINH,
		   YEAR(GETDATE()) - YEAR(NGSINH) as Tuoi,
		   DATEDIFF(YEAR,NGSINH,GETDATE()) as Tuoi,
		   DATEDIFF(MONTH,NGSINH,GETDATE()) as soThang,
		   DATEDIFF(DAY,NGSINH,GETDATE()) as soNgay,
		   DATEDIFF(WEEK,NGSINH,GETDATE()) as soTuan,
		   DATEDIFF(HOUR,NGSINH,GETDATE()) as soGio
	FROM NHANVIEN

	SELECT DATENAME(WEEKDAY, GETDATE()) as Thu,
		   DATENAME(DAYOFYEAR, GETDATE()) as NgayTrongNam,
		   DATENAME(WEEK, GETDATE()) as TuanTrongNam


