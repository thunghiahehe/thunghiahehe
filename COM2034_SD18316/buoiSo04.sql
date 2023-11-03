/* Ngôn ngữ truy vấn T-SQL
	1. Biến (Slide 23,24)
	a. Biến vô hướng: chứa đơn giá trị (giá trị dữ liệu chuẩn)
		--Khai báo biến:
			DECLARE @tenBien <kiểu dữ liệu> = giaTriMacDinhNeuCo, @tenBien2 <kiểu dữ liệu>

		--Gán giá trị:
			SET @tienBien = bieuThuc
		or
			SELECT @tenBien = bieuThuc
		or
			SELECT @tenBien = bieuThucCot, @tenBien2 = bieuThucCot
			FROM...

		--Truy xuất:
		SELECT @tenBien
*/
--VD1: Tính chu vi HCN
	DECLARE @chieuDai int = 4, @chieuRong int, @chuVi int, @dienTich int
	SET @chieuRong = 2
	SET @chuVi = (@chieuDai + @chieuRong) *2
	SET @dienTich = @chieuDai * @chieuRong 
	print N'Chu vi là: ' + CAST(@chuVi as nvarchar) --CAST: ép kiểu
	print N'Diện tích là: ' + CONVERT(nvarchar, @dienTich) --CONVERT: ép kiểu
	SELECT @chuVi as Chuvi, @dienTich as Dientich
--Sử dụng CSDL QLDA
	use QLDA
	go
--VD2: Cho biết tổng số nhân viên
	DECLARE @tongNV int
	SELECT @tongNV = COUNT(MANV) FROM NHANVIEN
	print N'Tổng số nhân viên là: '+ CAST(@tongNV as nvarchar)

--b. Biến bảng (Slide 27-29)
--	--Khai báo:
--		DECLARE @tenBang TABLE
--			(--giống cú pháp tạo bảng
--				tenCot1 <kiểu dữ liệu>,
--				...
--			)

--VD1: Tạo biến bảng chứa các NV Nữ: MaNV, hoTen
	DECLARE @NVNu TABLE
		(
		MaNV nvarchar(9),
		Hoten nvarchar(47)
		)
	--Thêm NV nữ vào biến bảng
	INSERT INTO @NVNu
	SELECT MANV, HONV+' '+TENLOT+' '+TENNV as Hoten
	FROM NHANVIEN WHERE PHAI like N'[Nữ]'

	SELECT * FROM @NVNu

	SELECT * 
	FROM @NVNu nu join NHANVIEN nv ON nv.MANV = nu.MaNV
	UPDATE @NVNu
	SET Hoten = N'Nguyễn Thu Nghĩa'
	WHERE MaNV=1
	SELECT * FROM @NVNu
