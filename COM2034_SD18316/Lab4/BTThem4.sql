--Bài 1
	BEGIN TRY
		INSERT DEAN
		VALUES 
		(N'Cáp quang',7,N'Hà Nội','4')
		print 'Them du lieu thanh cong'
	END TRY
	BEGIN CATCH
		print 'Error'
		print 'Error_Mesage: '+ ERROR_MESSAGE()
		print 'Them du lieu that bai'
	END CATCH

	SELECT * FROM DEAN
go
--Bài 2
SELECT MANV, TENNV,
	   IIF(PHAI like 'Nam', 'Mr','Ms') as GioiTinh, NGSINH, 
	   DATEDIFF(YEAR,NGSINH,GETDATE()) as Tuoi,
	   CASE
			when (DATEDIFF(YEAR,NGSINH,GETDATE())) <18 then N'Trẻ em'
			when (DATEDIFF(YEAR,NGSINH,GETDATE())) <60 then N'Lao động'
			else N'Tuổi già'
	   END as [Trạng thái]
FROM NHANVIEN