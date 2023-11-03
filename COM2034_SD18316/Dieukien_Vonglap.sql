use QLDA
go
--VD1
DECLARE @Diem float =8.5
	IF @Diem < 5
		print N'Xếp loại: Trượt'
	ELSE
		begin 
		print N'Xếp loại: Đạt'
		print N'Xếp loại: Đạt'
		end
go
DECLARE @DiemTB float = 8.5
	if @DiemTB < 5 
		print N'Trượt'
	else if @DiemTB <6
		print N'Trung bình'
	else if @DiemTB <7
		print N'TB Khá'
	else if @DiemTB <8
		print N'Khá'
	else if @DiemTB <9
		print N'Giỏi'
	else
		print N'Xuất sắc'
go
-- VD2
	if (SELECT COUNT(*) FROM NHANVIEN WHERE LUONG >50000) >0
		SELECT MANV, TENNV, LUONG FROM NHANVIEN WHERE LUONG >50000
	else
		print N'Không có NV nào có lương > 50000'
go
	if exists (SELECT * FROM NHANVIEN WHERE LUONG>50000)
		BEGIN
		print N'Danh sách NV có lương >50000'
		SELECT * FROM NHANVIEN WHERE LUONG>50000
		END
	else
		print N'Không có NV nào có lương > 50000'

-- VD3
-- IIF(<điều kiện>, <giá trị đúng>, <giá trị sai>)
	SELECT MANV, TENNV, LUONG,
		   IIF(LUONG>30000, N'Trưởng phòng', N'Nhân viên') as Chucvu
	FROM NHANVIEN

go

/* CASE
1. CASE đơn giản
		CASE
			when <giá trị 1> then kq1
			when <giá trị 2> then kq2
			when <giá trị 3> then kq3
			...
			else kqn
		END
2. Searched CASE
		CASE
			when <điều kiện 1> then kq1
			when <điều kiện 2> then kq2
			when <điều kiện 3> then kq3
			...
			else kqn
		END
*/
-- Simple CASE
	SELECT MANV, PHAI,
		   CASE PHAI 
				when N'Nam' then 'Mr.' + TENNV
				when N'Nữ' then 'Ms.' + TENNV
				else 'Free.' + TENNV
			END as Lienhe
	FROM NHANVIEN
go
-- Searched CASE
	SELECT MANV, PHAI,
		   CASE 
				when PHAI like N'Nam' then 'Mr.' + TENNV
				when PHAI like N'Nữ' then 'Ms.' + TENNV
				else 'Free.' + TENNV
			END as Lienhe
	FROM NHANVIEN
go

-- WHILE
	DECLARE @tong int =0,
			@count int =1 
	WHILE @count <=10
		BEGIN
			SET @tong = @tong + @count -- set @tong += @count
			SELECT @count = @count + 1
		END
	print N'Tổng từ 1 - 10: '+ CAST(@tong as nvarchar)
go
	DECLARE @tong int =0,
			@count int =2 
	WHILE @count <=10
		BEGIN
			SET @tong = @tong + @count -- set @tong += @count
			SELECT @count += 2
		END
	print N'Tổng số chẵn từ 1 - 10: '+ CAST(@tong as nvarchar)

go
	DECLARE @tong int =0,
			@count int =0
	WHILE @count <10
		BEGIN
			SELECT @count += 2
			if(@count =4) CONTINUE
			SET @tong += @count
		END
	print N'Tổng số chẵn từ 1 - 10 bỏ qua 4: '+ CAST(@tong as nvarchar)

-- TRY...CATCH
/*	BEGIN TRY
	--Nội dung đặt trong TRY
	END TRY
	BEGIN CATCH
	--Xử lí lỗi đặt trong CATCH
	END CATCH
*/
--VD1: Thực hiện 1 ví dụ có lỗi (in chuỗi + số) => in ra thông báo lỗi
	BEGIN TRY
		print 'TODAY IS '+GETDATE()
	END TRY
	BEGIN CATCH
		print 'ERROR'
		print 'Error_Number: '+ CAST(ERROR_NUMBER() as nvarchar)
		print 'Error_Message: '+ ERROR_MESSAGE()
	END CATCH
go
/* VD2: Thực hiện chèn thêm một dòng dữ liệu vào bảng PhongBan theo 2 bước:
	-- Nhận thông báo “ Them du lieu thanh cong” từ khối Try
	-- Chèn sai kiểu dữ liệu cột MaPHG để nhận thông báo lỗi “Them du lieu that bai” 
	từ khối Catch
*/
	BEGIN TRY
		INSERT PHONGBAN
		VALUES 
		(N'Kế toán',23,'006','2023-05-24')
		print 'Them du lieu thanh cong'
	END TRY
	BEGIN CATCH
		print 'Error'
		print 'Error_Mesage: '+ ERROR_MESSAGE()
		print 'Them du lieu that bai'
	END CATCH

	SELECT * FROM PHONGBAN

