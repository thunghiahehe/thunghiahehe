CREATE DATABASE QLYTHUVIEN
USE QLYTHUVIEN
--t?o b?ng tác gi?
CREATE TABLE TACGIA(
MaTacGia varchar(10) PRIMARY KEY,
TenTacGia nvarchar(50)
)
---t?o b?ng sách
CREATE TABLE SACH(
MaSach varchar(10) PRIMARY KEY,
TenSach nvarchar(50),
NamXuatBan int,
SoLuong int,
MaTacGia varchar(10),
FOREIGN KEY (MaTacGia) REFERENCES TACGIA(MaTacGia)
)

--2, Vi?t m?t Stored Procedure ?? thêm m?t tác gi? m?i vào b?ng TacGia. 
--Stored Procedure này s? nh?n các tham s? ??u vào là MaTacGia và TenTacGia. 
--Hãy ki?m tra các ?i?u ki?n sau:
---  	MaTacGia không ???c ?? tr?ng và ph?i là duy nh?t.
---  	TenTacGia không ???c ?? tr?ng.

CREATE PROC sp_tacgia @ma varchar(10),@ten nvarchar(50)
AS
BEGIN
	IF @ma is null or @ten is null 
	PRINT N'Không ???c ?? tr?ng d? li?u'
	ELSE
	BEGIN TRY
	INSERT INTO TACGIA VALUES(@ma,@ten)
	PRINT N'Thêm thành công'
	END TRY
	BEGIN CATCH
	PRINT N'Thêm th?t b?i'
	END CATCH
END

EXEC sp_tacgia 'TG1',N'Nguy?n Quang Huy'
EXEC sp_tacgia 'TG2',NULL
SELECT * FROM TACGIA

--3, Vi?t m?t Stored Procedure ?? thêm m?t sách m?i vào b?ng Sach.
--Stored Procedure này s? nh?n các tham s? ??u vào là MaSach, TenSach, NamXuatBan, SoLuong và MaTacGia.
--Hãy ki?m tra các ?i?u ki?n sau:
---   	MaSach không ???c ?? tr?ng và ph?i là duy nh?t.
---   	TenSach không ???c ?? tr?ng.
---   	MaTacGia ph?i t?n t?i trong b?ng TacGia.

CREATE PROC sp_sach @maSach varchar(10), @tenSach nvarchar(50), @namXB int,@sl int , @maTG varchar(10)
AS
BEGIN
	IF @maSach is null or @tenSach is null or @maTG is null
	PRINT N'Không ???c ?? tr?ng d? li?u'
	ELSE
	BEGIN TRY
	INSERT INTO SACH VALUES(@maSach,@tenSach,@namXB,@sl,@maTG)
	PRINT N'Thêm thành công'
	END TRY
	BEGIN CATCH
	PRINT N'Thêm th?t b?i'
	END CATCH
END

EXEC sp_sach 'S1',N'SQL server',2022,2,'TG1'
SELECT * FROM SACH

--4, Update Stored procedure ? câu s? 3, thêm 2 ?i?u ki?n:
---   	NamXuatBan không ???c ?? tr?ng và không v??t quá n?m hi?n t?i
---   	SoLuong ph?i là m?t s? nguyên không âm
ALTER PROC sp_sach @maSach varchar(10), @tenSach nvarchar(50), @namXB int,@sl int , @maTG varchar(10)
AS
BEGIN
	IF @maSach is null or @tenSach is null or @maTG is null or @namXB is null or @sl is null
	PRINT N'Không ???c ?? tr?ng d? li?u'
	ELSE
	IF @namXB > YEAR(GETDATE())
	PRINT N'N?m xu?t b?n không ???c v??t quá n?m hi?n t?i'
	ELSE
	IF @sl<0
	PRINT N'S? l??ng không ???c âm'
	ELSE
	BEGIN TRY
	INSERT INTO SACH VALUES(@maSach,@tenSach,@namXB,@sl,@maTG)
	PRINT N'Thêm thành công'
	END TRY
	BEGIN CATCH
	PRINT N'Thêm th?t b?i'
	END CATCH
END
EXEC sp_sach 'S2',N'SQL server',2022,2,'TG1'
SELECT * FROM SACH

--5, Vi?t m?t Stored Procedure truy?n vào tên 1 tác gi? và xóa ?i tác gi? ?ó bao g?m t?t c? sách c?a tác gi? ?ó.
--Ki?m tra check l?i các ?i?u ki?n có th? x?y ra.

CREATE PROC sp_xoaTG @ten nvarchar(50)
AS
BEGIN
IF @ten is null
PRINT N'Không ???c ?? tr?ng tên tác gi?'
ELSE
BEGIN TRY
	DECLARE @tbTacGia TABLE (MaTG varchar(10))
	INSERT INTO @tbTacGia 
	SELECT MaTacGia FROM TACGIA WHERE TenTacGia LIKE @ten
	DELETE FROM SACH WHERE MaTacGia IN (SELECT MATG FROM @tbTacGia)
	DELETE FROM TACGIA WHERE MaTacGia IN (SELECT MATG FROM @tbTacGia)
END TRY 
BEGIN CATCH
 PRINT N'Xóa th?t b?i'
END CATCH
END

EXEC sp_xoaTG N'Nguy?n Quang Huy'
SELECT * FROM SACH
SELECT * FROM TACGIA