use QLNT
go
--Câu 1:
IF OBJECT_ID('sp_Insert_NGUOIDUNG') is not null
   DROP PROC sp_Insert_NGUOIDUNG
go
CREATE PROC sp_Insert_NGUOIDUNG 
	@MaND  nvarchar(10),
	@TenND  nvarchar(100),
	@Gioitinh  nvarchar(10),
	@DienThoai  nvarchar(10),
	@DiaChi  nvarchar(250),
	@MaQuan  nvarchar(10),
	@email  nvarchar(250)
AS
BEGIN
	BEGIN TRY
		INSERT NGUOIDUNG 
		VALUES (@MaND, @TenND, @Gioitinh, @DienThoai, @DiaChi, @MaQuan, @email)
		PRINT N'Thêm thành công'
	END TRY
	BEGIN CATCH
		PRINT N'Thêm thất bại: ' + ERROR_MESSAGE()
	END CATCH
END
go
EXEC sp_Insert_NGUOIDUNG 'ND22', N'Nguyễn Thu Nghĩa', N'Nữ', '0834045324', N'Hà Nội', 'PK4', 'nghiantt@gmmail.com'
go
SELECT * FROM NGUOIDUNG
go
--
IF OBJECT_ID('sp_Insert_NHATRO') is not null
   DROP PROC sp_Insert_NHATRO
go
CREATE PROC sp_Insert_NHATRO
	@MANHATRO nvarchar(10),
	@MALN nvarchar(10),
	@DIENTICH float,
	@GIAPHONG money,
	@DIACHI nvarchar(250),
	@MAQUAN nvarchar(10),
	@MOTA nvarchar(250),
	@NGAYDANG date,
	@NGUOILIENHE nvarchar(10)
AS
BEGIN
	BEGIN TRY
		INSERT NHATRO
		VALUES (@MANHATRO, @MALN, @DIENTICH, @GIAPHONG, @DIACHI, @MAQUAN, @MOTA, @NGAYDANG, @NGUOILIENHE)
		PRINT N'Thêm thành công'
	END TRY
	BEGIN CATCH
		PRINT N'Thêm thất bại: ' + ERROR_MESSAGE()
	END CATCH
END
go
EXEC sp_Insert_NHATRO @MANHATRO ='023', @MALN ='LN3', @DIENTICH =24.9, @GIAPHONG =3326850, @DIACHI = N'Cấu Giấy, Hà Nội', @MAQUAN ='PK2', @MOTA =N'Cho thuê nguyên căn', @NGAYDANG ='2022-01-15', @NGUOILIENHE ='ND7'
go
SELECT * FROM NHATRO
go
--
IF OBJECT_ID('sp_Insert_DANHGIA') is not null
   DROP PROC sp_Insert_DANHGIA
go
CREATE PROC sp_Insert_DANHGIA
	@MADG nvarchar(10) ,
	@MAND nvarchar(10) ,
	@MANHATRO nvarchar(10) ,
	@LIKES bit ,
	@NOIDUNGDANHGIA nvarchar(30)
AS
BEGIN
	BEGIN TRY
		INSERT DANHGIA
		VALUES (@MADG, @MAND, @MANHATRO, @LIKES, @NOIDUNGDANHGIA)
		PRINT N'Thêm thành công'
	END TRY
	BEGIN CATCH
		PRINT N'Thêm thất bại: ' + ERROR_MESSAGE()
	END CATCH
END
go
EXEC sp_Insert_DANHGIA 'D08','ND1', '001', 0, N'Giá cao'
go
SELECT * FROM DANHGIA
go

--Câu 2
--2a
IF OBJECT_ID('sp_TTNT') is not null
   DROP PROC sp_TTNT
go
CREATE PROC sp_TTNT @TenQuan nvarchar(50) =N'%', 
					@MinS float =0, 
					@MaxS float =1000,
					@MinNGDANG date = null,
					@MaxNGDANG date = null,
					@MinGiaPhong money =0,
					@MaxGiaPhong money =10000000,
					@TenLN nvarchar(50) =N'%'
AS
BEGIN
	IF @MinNGDANG is null
		SELECT @MinNGDANG = MIN(NGAYDANG) FROM NHATRO
	IF @MinNGDANG is null
		SELECT @MinNGDANG = GETDATE()

	SELECT nt.DIACHI + N' Quận '+ TenQuan as N'Cho thuê tại', 
		   (REPLACE(CONVERT(varchar,DIENTICH,103),'.',',') + ' m2') as 'Diện Tích',
		   (REPLACE(LEFT(CONVERT(varchar,GIAPHONG,1),LEN(CONVERT(varchar,GIAPHONG,1))-3),',','.') + N' VNĐ') as N'Giá Phòng',
		   CONVERT(varchar, NGAYDANG, 105) as NgayDangTin,
		   IIF(Gioitinh like N'Nam', 'A.'+TenND, 'C.'+TenND) as NguoiLienHe,
		   DIENTHOAI as SoDienThoai,
		   nt.DIACHI as DiaChiNguoiLH
	FROM NhaTro nt join Quan q on nt.MaQuan = q.MaQuan
					join LoaiNha ln on nt.MaLN = ln.MaLN
					join NguoiDung nd on nt.NGUOILIENHE = nd.MaND
	WHERE TenQuan like @TenQuan
			and DienTich between @MinS and @MaxS
			and NGAYDANG between @MinNGDANG and @MaxNGDANG
			and GiaPhong between @MinGiaPhong and @MaxGiaPhong
			and TenLN like @TenLN
END
go 
EXEC sp_TTNT
EXEC sp_TTNT @TenQuan = N'Cầu Giấy', @MinS =15, @MaxS =90, @MinNGDANG ='01-01-2020', @MaxNGDANG ='12-31-2022', @MinGiaPhong =3000, @MaxGiaPhong =5000, @TenLN ='CCMN'
go

--2b
IF OBJECT_ID('fn_MaNguoiDung') is not null
DROP FUNCTION fn_MaNguoiDung
GO
CREATE FUNCTION fn_MaNguoiDung(
		@TenND nvarchar(50) = N'%',
		@Dienthoai nvarchar(50) = N'%',
		@DiaChi nvarchar(50) = N'%',
		@Quan nvarchar(50) = N'%')
RETURNS TABLE
RETURN (
		SELECT MAND, TENND, TENQUAN
		FROM NGUOIDUNG nd join QUAN q ON nd.MAQUAN = q.MAQUAN
		WHERE (TENND like @TenND)
		and (DIACHI like @Diachi)
		and (TENQUAN like @Quan)
		and (DIENTHOAI like @Dienthoai)
		)
go
SELECT * FROM dbo.fn_MaNguoiDung(N'%Nguyễn%', default, default, default)
go

--2c
IF OBJECT_ID ('fn_TongLike') is not null
DROP FUNCTION fn_TongLike
GO
CREATE FUNCTION fn_TongLike(@MaNhaTro nvarchar(10))
RETURNS INT
AS
BEGIN
	RETURN (SELECT COUNT(LIKES) FROM DANHGIA
		WHERE MANHATRO = @MANHATRO
		AND LIKES = 1)
END
go
IF OBJECT_ID ('fn_TongDislike') is not null
DROP FUNCTION fn_TongDislike
go
CREATE FUNCTION fn_TongDislike(@MaNhaTro nvarchar(10))
RETURNS INT
AS
BEGIN
	RETURN (
		SELECT COUNT(LIKES) 
		FROM DANHGIA
		WHERE MANHATRO = @MaNhaTro and LIKES = 0)
END
go
SELECT MANHATRO,TENLN,
	(REPLACE(CONVERT(varchar,DIENTICH,103),'.',',') + ' m2') as 'Diện Tích',
	(REPLACE(LEFT(CONVERT(varchar,GIAPHONG,1),LEN(CONVERT(varchar,GIAPHONG,1))-3),',','.') + N' VNĐ') as N'Giá Phòng',
	NHATRO.DiaChi as N'Địa Chỉ',
	dbo.fn_TongLike(MaNhaTro) as N'Tổng Like',
	dbo.fn_TongDislike(MaNhaTro) as N'Tổng Dislike',
	MOTA as N'Thông Tin Nhà Trọ',
	NGAYDANG as N'Ngày Đăng',
	NGUOIDUNG.TENND as 'Người Đăng'
from NHATRO
join NGUOIDUNG on NHATRO.NGUOILIENHE = NGUOIDUNG.MAND
join LOAINHA on NHATRO.MALN = LOAINHA.MALN
go

--2d
IF OBJECT_ID ('TOP10') is not null
DROP VIEW TOP10
GO
CREATE VIEW TOP10
AS
	SELECT TOP 10 NHATRO.MANHATRO as 'Mã nhà trọ',
		(REPLACE(CONVERT(varchar,DIENTICH,103),',',',') +' m2') as 'Diện Tích',
		(REPLACE(LEFT(CONVERT (varchar,GIAPHONG,1),LEN(CONVERT(varchar,GIAPHONG,1))-3),',','.') + N' VNĐ') as 'Giá Phòng',
		MOTA as 'Thông Tin Nhà Trọ',
		(NHATRO.DiaChi) as 'Địa chỉ nhà trọ',
		dbo.fn_TongLike(MaNhaTro) as 'Tổng Like',
		NGAYDANG as 'Ngày Đăng',
		NGUOIDUNG.TENND as 'Người Đăng',
		(NGUOIDUNG.DIACHI +', '+ NGUOIDUNG.DIACHI) as 'Địa chỉ liên hệ',
		NGUOIDUNG.DienThoai as 'Điện thoại',
		NGUOIDUNG.Email as "Email"
	from NHATRO
	join NGUOIDUNG on NHATRO.NGUOILIENHE = NGUOIDUNG.MAND
	join LOAINHA on NHATRO.MALN = LOAINHA.MALN
	ORDER BY N'Tổng Like' DESC
go
SELECT * FROM TOP10
go

--2e
IF OBJECT_ID('sp_TTNT_Like') is not null
   DROP PROC sp_TTNT_Like
go
CREATE PROC sp_TTNT_Like @MaNhaTro nvarchar(10)
AS
BEGIN
	SELECT hd.MANHATRO, TENND,
	IIF(LIKES =1, N'Thích', N'Không thích') as TrangThai,
	NOIDUNGDANHGIA
	FROM NGUOIDUNG nd join HOPDONGTHUE hd on nd.MAND = hd.MAND
					  join DANHGIA dg on hd.MAND = dg.MAND
									  and hd.MANHATRO = dg.MANHATRO
	WHERE hd.MANHATRO like @MaNhaTro
END
go
EXEC sp_TTNT_Like '005'
go

/*Câu 3: Xóa thông tin
	--1. Viết một SP nhận một tham số đầu vào kiểu int là số lượng DISLIKE. SP này thực hiện
	thao tác xóa thông tin của các nhà trọ và thông tin đánh giá của chúng, nếu tổng số lượng
	DISLIKE tương ứng với nhà trọ này lớn hơn giá trị tham số được truyền vào.
	Yêu cầu: Sử dụng giao dịch trong thân SP, để đảm bảo tính toàn vẹn dữ liệu khi một thao tác 
	xóa thực hiện không thành công.

	--2. Viết một SP nhận hai tham số đầu vào là khoảng thời gian đăng tin. SP này thực hiện
	thao tác xóa thông tin những nhà trọ được đăng trong khoảng thời gian được truyền vào 
	qua các tham số.
	Lưu ý: SP cũng phải thực hiện xóa thông tin đánh giá của các nhà trọ này.
	Yêu cầu: Sử dụng giao dịch trong thân SP, để đảm bảo tính toàn vẹn dữ liệu khi một thao tác 
	xóa thực hiện không thành công.
*/
--3.1
IF OBJECT_ID('sp_XoaNT_dislike') is not null
   DROP PROC sp_XoaNT_dislike
go
CREATE PROC sp_XoaNT_dislike @numdislike INT
AS
BEGIN
	BEGIN TRY
		BEGIN TRAN --bắt đầu giao dịch
			--Khai báo biến bảng chứa thông tin các MANHATRO cần xóa
			DECLARE @BangTam TABLE (MANT nvarchar(50))
			--lấy MANHATRO có số lượng dislike > @numdislike đưa vào @BangTam
			INSERT @BangTam
				SELECT MANHATRO
				FROM DANHGIA
				WHERE LIKES = 0
				GROUP BY MANHATRO
				HAVING COUNT(LIKES) > @numdislike
			--Xóa DANHGIA của MANT có trong @BangTam
			DELETE FROM DANHGIA
			WHERE MANHATRO in (SELECT MANT FROM @BangTam)
			--Xóa HOPDONGTHUE của MANT có trong @BangTam
			DELETE FROM HOPDONGTHUE
			WHERE MANHATRO in (SELECT MANT FROM @BangTam)
			--Xóa NHATRO của MANT có trong @BangTam
			DELETE FROM NHATRO
			WHERE MANHATRO in (SELECT MANT FROM @BangTam)
		COMMIT TRAN --hoàn thành giao dịch
		PRINT N'Xóa thành công'
	END TRY
	BEGIN CATCH
		PRINT N'Lỗi xóa'
		ROLLBACK TRAN
	END CATCH
END
go
EXEC sp_XoaNT_dislike 0
go
SELECT * FROM DANHGIA

--3.2
IF OBJECT_ID('sp_XoaNT_NgayDang') is not null
   DROP PROC sp_XoaNT_NgayDang
go
CREATE PROC sp_XoaNT_NgayDang @MinNGDANG datetime, @MaxNGDANG datetime
AS
BEGIN
	BEGIN TRY
		BEGIN TRAN --bắt đầu giao dịch
			--Khai báo biến bảng chứa thông tin các MANHATRO cần xóa
			DECLARE @BangTam TABLE (MANT nvarchar(50))
			--lấy MANHATRO có số lượng dislike > @numdislike đưa vào @BangTam
			INSERT @BangTam
				SELECT MANHATRO
				FROM NHATRO
				WHERE NGAYDANG between @MinNGDANG and @MaxNGDANG
			--Xóa DANHGIA của MANT có trong @BangTam
			DELETE FROM DANHGIA
			WHERE MANHATRO in (SELECT MANT FROM @BangTam)
			--Xóa HOPDONGTHUE của MANT có trong @BangTam
			DELETE FROM HOPDONGTHUE
			WHERE MANHATRO in (SELECT MANT FROM @BangTam)
			--Xóa NHATRO của MANT có trong @BangTam
			DELETE FROM NHATRO
			WHERE MANHATRO in (SELECT MANT FROM @BangTam)
		COMMIT TRAN --hoàn thành giao dịch
		PRINT N'Xóa thành công'
	END TRY
	BEGIN CATCH
		PRINT N'Lỗi xóa'
		ROLLBACK TRAN
	END CATCH
END
go
EXEC sp_XoaNT_NgayDang '2021-05-04', '2022-11-09'
go
SELECT * FROM NHATRO