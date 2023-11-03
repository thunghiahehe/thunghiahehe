--Bài 1
use QLDA
go
IF OBJECT_ID('sp_Insert_CONGVIEC') is not null
   DROP PROC sp_Insert_CONGVIEC
go
CREATE PROC sp_Insert_CONGVIEC
	@MaDA int,
	@STT int,
	@Ten_cong_viec nvarchar(50)
AS
BEGIN
	BEGIN TRY
		IF @MaDA is null or @Ten_cong_viec is null
			PRINT N'Vui lòng nhập đầy đủ MaDA, Ten_cong_viec'
		ELSE IF EXISTS (SELECT * FROM CONGVIEC WHERE STT = @STT and MADA = @MaDA)
			PRINT N'Khóa chính đã tồn tại, không thêm được'
		ELSE IF NOT EXISTS (SELECT * FROM DEAN WHERE MADA = @MaDA)
				PRINT N'Khóa ngoại không tồn tại, không thêm được'
		ELSE
			BEGIN
				INSERT CONGVIEC
				VALUES (@MaDA, @STT, @Ten_cong_viec)
				PRINT N'Thêm thành công'
			END
	END TRY
	BEGIN CATCH
		PRINT N'Thêm thất bại: ' + ERROR_MESSAGE()
	END CATCH
END
go
EXEC sp_Insert_CONGVIEC 5, 11, N'Lắp đặt cáp quang'
SELECT * FROM CONGVIEC
go
--Bài 2
IF OBJECT_ID('sp_TTCV') is not null
   DROP PROC sp_TTCV
go
CREATE PROC sp_TTCV @MaDA int =2
AS
BEGIN
	SELECT * FROM CONGVIEC
	WHERE MADA = @MaDA
END
go
EXEC sp_TTCV
EXEC sp_TTCV 3