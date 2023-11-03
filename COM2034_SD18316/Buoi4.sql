USE QLDA
SELECT * FROM NhanVien
SELECT * FROM PHANCONG
--Câu 1: Vi?t 1 function truy?n vào mã c?a 1 phòng ban, 
--s? d?ng hàm này ?? tính t?ng th?i gian ???c phân công làm vi?c c?a c? phòng ?ó (NHANVIEN, PHANCONG)

CREATE FUNCTION tinhTG (@MA INT)
RETURNS FLOAT
AS
BEGIN 
RETURN (SELECT SUM(THOIGIAN) FROM NHANVIEN INNER JOIN PHANCONG ON NHANVIEN.MANV=PHANCONG.MA_NVIEN
WHERE PHG=@MA)
END

SELECT dbo.tinhTG(4)

--Câu 2: Vi?t 1 function tr? v? h? và tên, 
--??a ch? và ??a ?i?m làm vi?c c?a nh?ng nhân viên ?ang làm vi?c ? n?i khác v?i ??a ch? c?a mình (NHANVIEN, DIADIEM_PHG)
SELECT * FROM NHANVIEN
SELECT * FROM DIADIEM_PHG
Create function checkDC()
RETURNS @diachiNV table (hoTen nvarchar(50),diachi nvarchar(50),diadiem nvarchar(50))
AS 
BEGIN
	INSERT INTO @diachiNV
	SELECT CONCAT(HONV,'',TENLOT,'',TENNV) AS HOTEN,DCHI,DIADIEM FROM NHANVIEN
	INNER JOIN DIADIEM_PHG ON NHANVIEN.PHG=DIADIEM_PHG.MAPHG
	WHERE DCHI NOT LIKE CONCAT('%',DIADIEM,'%')
	RETURN
END

SELECT * FROM dbo.checkDC()
SELECT * FROM THANNHAN
--Câu 3: Vi?t 1 function tr? v? h? và tên, tình tr?ng có thân nhân hay không
CREATE FUNCTION checkTN()
RETURNS @ketqua table (hoten nvarchar(50),tinhtrang nvarchar(50))
as
begin
	INSERT INTO @KETQUA 
	SELECT CONCAT(HONV,' ',TENLOT,' ',TENNV) AS HOTEN,
	IIF(MANV IN(SELECT DISTINCT MA_NVIEN FROM THANNHAN 
	JOIN NHANVIEN ON NHANVIEN.MANV=THANNHAN.MA_NVIEN),N'Có thân nhân',N'Không có thân nhân') AS ThanNhan
	FROM NHANVIEN
	RETURN
end

SELECT * FROM dbo.checkTN()

