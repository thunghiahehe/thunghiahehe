use QLDA
go
--1. TRIGGER FOR: INSERT/ UPDATE/ DELETE
/*Cú pháp:
	CREATE TRIGGER <ten_trigger> ON <TenBang>
		FOR INSERT/ UPDATE/ DELETE
	AS
		<lệnh SQL>
*/

--VD1: VD Trigger INSERT: Kiểm tra dữ liệu chèn vào bảng NHANVIEN có lương phải lớn hơn 5000
IF OBJECT_ID('tg_Insert_NHANVIEN') is not null
	DROP TRIGGER tg_Insert_NHANVIEN
go
CREATE TRIGGER tg_Insert_NHANVIEN ON NHANVIEN
	FOR INSERT
AS
IF exists (SELECT * FROM inserted WHERE LUONG <= 5000)
	BEGIN
		PRINT N'Lương nhân viên phải <= 5000'
		ROLLBACK TRAN --Hoàn tác: hoàn lại các thao tác vừa thực hiện
	END
--TEST
INSERT INTO NHANVIEN
VALUES (N'Đinh', N'Bá', N'Tiên', '019', '1960-02-11', N'Tp HCM', N'Nữ', 3000, '005', 5)
go

--VD2: TRIGGER cập nhật lương cho NHANVIEN, quy định lương >5000
IF OBJECT_ID('tg_UPDATE_NHANVIEN') is not null
	DROP TRIGGER tg_UPDATE_NHANVIEN
go
CREATE TRIGGER tg_UPDATE_NHANVIEN ON NHANVIEN
	FOR UPDATE
AS
IF exists (SELECT * FROM inserted WHERE LUONG > 5000)
	BEGIN
		PRINT N'UPDATE lương nhân viên phải > 5000'
		ROLLBACK TRAN --Hoàn tác: hoàn lại các thao tác vừa thực hiện
	END
--TEST
UPDATE NHANVIEN
SET LUONG = 1 WHERE MANV like '001'
go

--VD3: VD tạo TRIGGER DELETE không cho phép xóa nhân viên có mã '001'
IF OBJECT_ID('TG_DELETE_NHANVIEN') is not null
	DROP TRIGGER TG_DELETE_NHANVIEN
go
CREATE TRIGGER TG_DELETE_NHANVIEN ON NHANVIEN
	FOR DELETE
AS
IF exists (SELECT * FROM deleted WHERE MANV like '018')
	BEGIN
		PRINT N'Không được xóa nhân viên có mã 018'
		ROLLBACK TRAN --Hoàn tác
	END
--TEST
DELETE FROM NHANVIEN
WHERE MANV like '018'
go

--2. TRIGGER AFTER: xảy ra sau khi các hoạt động INSERT/ UPDATE/ DELETE đã thực hiện hoàn chỉnh
/*Cú pháp:
	CREATE TRIGGER <ten_trigger> ON <TenBang>
		AFTER INSERT/ UPDATE/ DELETE
	AS
		<lệnh SQL>
*/

--VD: Viết TRIGGER đếm số lượng NHANVIEN bị xóa khi có câu lệnh xóa trên bảng NHANVIEN
IF OBJECT_ID('TG_AFTER_DeleteNV') is not null
	DROP TRIGGER TG_AFTER_DeleteNV
go
CREATE TRIGGER TG_AFTER_DeleteNV ON NHANVIEN
	AFTER DELETE
AS
BEGIN
	DECLARE @soNV int =0
	SELECT @soNV = COUNT(MANV)
	FROM deleted

	PRINT N'Số NV đã xóa: ' + CAST(@soNV as nvarchar)
END
--TEST
DELETE FROM NHANVIEN
WHERE MANV like '011'
go

--3. TRIGGER INSTEAD OF: được thực thi thay thế cho các hoạt động INSERT/ UPDATE/ DELETE
/*Cú pháp:
	CREATE TRIGGER <ten_trigger> ON <TenBang>
		INSTEAD OF INSERT/ UPDATE/ DELETE
	AS
	BEGIN
		--Các lệnh
	END
*/

--VD: Tạo TRIGGER sao cho khi xóa NHANVIEN thì tự động xóa THANNHAN
IF OBJECT_ID('TG_DELETE_NV') is not null
	DROP TRIGGER TG_DELETE_NV
go
CREATE TRIGGER TG_DELETE_NV ON NHANVIEN
	INSTEAD OF DELETE
AS
BEGIN
	--Xóa hết dữ liệu liên quan đến bảng nhiều
	DELETE FROM THANNHAN
	WHERE MA_NVIEN in (SELECT MANV FROM deleted)
	--Xóa dữ liệu trên bảng chính
	DELETE FROM NHANVIEN
	WHERE MANV in (SELECT MANV FROM deleted)
END
--TEST
DELETE FROM NHANVIEN
WHERE MANV like '017'
