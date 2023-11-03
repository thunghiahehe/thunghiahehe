--Câu 1 (1.5 điểm): Tạo CSDL có tên SU23_COM2034_[Mã số sinh viên] gồm các bảng sau:
--XeHoi(MaXeHoi, TenXeHoi, NamSanXuat, XuatXu, HangXe)
--HopDong(MaHopDong, NgayKy, GiaTriMuaBan)
--HopDongChiTiet(MaXeHoi, MaHopDong, TinhTrangXe(bit))
--Trường in đậm không được NULL, in nghiêng là khóa ngoại, gạch chân là khóa chính.

CREATE DATABASE SU23_COM2034_PH37410
go
use SU23_COM2034_PH37410
go
CREATE TABLE XeHoi(
MaXeHoi nvarchar(10) primary key, 
TenXeHoi nvarchar(50) not null, 
NamSanXuat int not null, 
XuatXu nvarchar(50), 
HangXe nvarchar(50),
SucChua int not null
)
go
CREATE TABLE HopDong(
MaHopDong nvarchar(10) primary key, 
NgayKy date, 
GiaTriMuaBan money not null
)
go
CREATE TABLE HopDongChiTiet(
MaXeHoi nvarchar(10), 
MaHopDong nvarchar(10), 
TinhTrangXe bit not null,
PRIMARY KEY(MaXeHoi, MaHopDong),
FOREIGN KEY(MaXeHoi) REFERENCES XeHoi(MaXeHoi),
FOREIGN KEY(MaHopDong) REFERENCES HopDong(MaHopDong)
)
go
--Câu 2 (3 điểm): Tạo Thủ tục THÊM dữ liệu cho 3 bảng.
--Với mỗi thủ tục, viết sẵn 3 lời gọi thành công.
IF OBJECT_ID('sp_insert_XeHoi') is not null
DROP PROC sp_insert_XeHoi
go
CREATE PROC sp_insert_XeHoi(
					@MaXeHoi nvarchar(10), 
					@TenXeHoi nvarchar(50), 
					@NamSanXuat int, 
					@XuatXu nvarchar(50), 
					@HangXe nvarchar(50),
					@SucChua int
					)
AS
BEGIN
	BEGIN TRY
		IF @MaXeHoi is null or @TenXeHoi is null or @NamSanXuat is null or @SucChua is null
			PRINT 'Vui long nhap day du thong tin'
		ELSE
			BEGIN
				INSERT XeHoi VALUES(@MaXeHoi, @TenXeHoi, @NamSanXuat, @XuatXu, @HangXe, @SucChua)
				PRINT 'Them thanh cong'
			END
	END TRY
	BEGIN CATCH
		PRINT 'Them that bai' + ERROR_MESSAGE()
	END CATCH
END
go
EXEC sp_insert_XeHoi 'XH01', 'Xe 1', 2020, N'Viet Nam', 'H1',4
EXEC sp_insert_XeHoi 'XH02', 'Xe 2', 2022, N'Nhat', 'H2',5
EXEC sp_insert_XeHoi 'XH03', 'Xe 3', 2021, N'Mi', 'H3',7
go
--
IF OBJECT_ID('sp_insert_HopDong') is not null
DROP PROC sp_insert_HopDong
go
CREATE PROC sp_insert_HopDong(
					@MaHopDong nvarchar(10), 
					@NgayKy date, 
					@GiaTriMuaBan money
					)
AS
BEGIN
	BEGIN TRY
		IF @MaHopDong is null or @GiaTriMuaBan is null
			PRINT 'Vui long nhap day du thong tin'
		ELSE
			BEGIN
				INSERT HopDong VALUES(@MaHopDong, @NgayKy, @GiaTriMuaBan)
				PRINT 'Them thanh cong'
			END
	END TRY
	BEGIN CATCH
		PRINT 'Them that bai' + ERROR_MESSAGE()
	END CATCH
END
go
EXEC sp_insert_HopDong 'HD1','2022-12-03',4000
EXEC sp_insert_HopDong 'HD2','2020-09-05',5000
EXEC sp_insert_HopDong 'HD3','2023-02-12',7000
go
--
IF OBJECT_ID('sp_insert_HopDongChiTiet') is not null
DROP PROC sp_insert_HopDongChiTiet
go
CREATE PROC sp_insert_HopDongChiTiet(
						@MaXeHoi nvarchar(10), 
						@MaHopDong nvarchar(10), 
						@TinhTrangXe bit
						)
AS
BEGIN
	BEGIN TRY
		IF @MaXeHoi is null or @MaHopDong is null or @TinhTrangXe is null
			PRINT 'Vui long nhap day du thong tin'
		ELSE
			BEGIN
				INSERT HopDongChiTiet VALUES(@MaXeHoi, @MaHopDong, @TinhTrangXe)
				PRINT 'Them thanh cong'
			END
	END TRY
	BEGIN CATCH
		PRINT 'Them that bai' + ERROR_MESSAGE()
	END CATCH
END
go
EXEC sp_insert_HopDongChiTiet 'XH01','HD1',0
EXEC sp_insert_HopDongChiTiet 'XH02','HD2',1
EXEC sp_insert_HopDongChiTiet 'XH03','HD1',1
EXEC sp_insert_HopDongChiTiet 'XH03','HD3',0
go
SELECT* FROM HopDongChiTiet
SELECT* FROM XeHoi
--Câu 3 (1 điểm): Tạo và sử dụng Khung nhìn có tên: V_HDCT_Full.
--Hiển thị chi tiết hợp đồng bao gồm: Mã xe hơi, Mã hợp đồng, 
--Tình trạng xe (1 là new, 0 là used), Giá trị mua bán 
-- và tổng tiền phải trả (nếu tình trạng xe là xe mới thì tổng tiền phải trả = giá trị mua bán + 10% thuế)
IF OBJECT_ID('V_HDCT_Full') is not null
DROP VIEW V_HDCT_Full
go
CREATE VIEW V_HDCT_Full
AS
	SELECT MaXeHoi, hdct.MaHopDong,
		   IIF(TinhTrangXe = 1, 'new', 'used') as [Tình trạng xe],
		   GiaTriMuaBan,
		   CASE TinhTrangXe
				WHEN 1 THEN GiaTriMuaBan * 110/100
				ELSE GiaTriMuaBan
		   END as [Tổng tiền phải trả]
	FROM HopDongChiTiet hdct join HopDong hd ON hdct.MaHopDong = hd.MaHopDong
go
SELECT * FROM V_HDCT_Full
go

--Câu 4 (1 điểm): Tạo và sử dụng Khung nhìn có tên V_TopCN.
--Hiển thị top 3 xe có lượng mua bán nhiều nhất (Mã xe hơi, Tên xe hơi, Số lần mua bán)
IF OBJECT_ID('V_TopCN') is not null
DROP VIEW V_TopCN
go
CREATE VIEW V_TopCN
AS
	SELECT TOP(3) XeHoi.MaXeHoi, TenXeHoi, COUNT(MaHopDong) as [Số lần mua bán]
	FROM XeHoi join HopDongChiTiet ON XeHoi.MaXeHoi = HopDongChiTiet.MaXeHoi
	GROUP BY XeHoi.MaXeHoi, TenXeHoi
	ORDER BY [Số lần mua bán] DESC
go
SELECT * FROM V_TopCN
go

--Câu 5 (2 điểm): Tạo và sử dụng Hàm có tên F_LoaiXe nhận vào một Mã xe hơi, trả về kết quả là loại của xe đó 
--(nếu xe đó có dưới 4 chỗ ngồi thì là xe Couple, 4 chỗ thì là Sedan, trên 4 chỗ thì là SUV). 
IF OBJECT_ID('F_LoaiXe') is not null
DROP FUNCTION F_LoaiXe
GO
CREATE FUNCTION F_LoaiXe(@MaXH nvarchar(10))
RETURNS nvarchar(10)
AS
BEGIN
	RETURN(SELECT
				CASE
					WHEN SucChua <4 THEN 'Couple'
					WHEN SucChua =4 THEN 'Sedan'
					WHEN SucChua >4 THEN 'SUV'
				END
			FROM XeHoi
			WHERE MaXeHoi = @MaXH
			)
END
go
SELECT dbo.F_LoaiXe('XH01') AS [Loại xe]
SELECT dbo.F_LoaiXe('XH02') AS [Loại xe]
SELECT dbo.F_LoaiXe('XH03') AS [Loại xe]
go

--Câu 6 (1 điểm): Tạo và sử dụng Thủ tục có tên SP_XoaXeHoi truyền vào mã xe hơi và thực hiện xóa xe hơi ở các bảng liên quan.
IF OBJECT_ID('SP_XoaXeHoi') is not null
DROP PROC SP_XoaXeHoi
go
CREATE PROC SP_XoaXeHoi @MaXH nvarchar(10)
AS
BEGIN
	BEGIN TRY
		BEGIN TRAN
			DELETE FROM HopDongChiTiet
			WHERE MaXeHoi = @MaXH
			DELETE FROM XeHoi
			WHERE MaXeHoi = @MaXH
		COMMIT
		PRINT 'Xoa thanh cong'
	END TRY
	BEGIN CATCH
		ROLLBACK TRAN
		PRINT 'Xoa that bai'
	END CATCH
END
GO
EXEC SP_XoaXeHoi 'XH03'
SELECT * FROM XeHoi
SELECT * FROM HopDongChiTiet
--CHÚ Ý: Các thủ tục thêm dữ liệu có kiểm tra dữ liệu đầu vào hợp lý. 
--Với dữ liệu nhập sai hoặc không phù hợp, có hiển thị tin nhắn hướng dẫn người dùng nhập lại chính xác. (0.5 điểm)