--Câu 1:
--Lấy thông tin sau, sắp giảm dần theo MaKhachHang:
--MaKhachHang, Họ tên, MaHoaDon, NgayMuaHang, MaSanPham, TenSP, Số lượng mua, Thành Tiền. Trong đó Thành tiền = số lượng mua * DonGia

SELECT KhachHang.MaKhachHang, HovaTenLot + ' ' + Ten as HoTen,
		HoaDon.MaHoaDon, NgayMuaHang, SanPham.MaSanPham,TenSP,
		HoaDonChiTiet.SoLuong as SoLuongMua,
		HoaDonChiTiet.SoLuong* DonGia as ThanhTien
FROM KhachHang join HoaDon ON KhachHang.MaKhachHang = HoaDon.MaKhachHang
				join HoaDonChiTiet ON HoaDon.MaHoaDon = HoaDonChiTiet.MaHoaDon
				join SanPham ON SanPham.MaSanPham = HoaDonChiTiet.MaSanPham
ORDER BY KhachHang.MaKhachHang DESC


--Câu 2:  Hiển thị thông tin các hóa đơn mua hàng trong tháng 9 năm 2019, sắp tăng dần theo makhachhang: MaKhacHang, họ tên, mahoadon, ngày mua hàng.

SELECT KhachHang.MaKhachHang, HovaTenLot + ' ' + Ten as HoTen,
	MaHoaDon, NgayMuaHang
FROM KhachHang join HoaDon ON KhachHang.MaKhachHang = HoaDon.MaKhachHang
WHERE MONTH(NgayMuaHang)=9 and YEAR(NgayMuaHang)=2019
ORDER BY KhachHang.MaKhachHang ASC


--Câu 3: 
--Cho biết thông tin mua hàng của các khách hàng có địa chỉ ở Hà nội (kể cả khách hàng không mua hàng lần nào): 
--MaKhachHang, họ và tên, số lần mua.

SELECT KhachHang.MaKhachHang, KhachHang.HovaTenLot, KhachHang.Ten, COUNT (HoaDon.MaHoaDon) AS 'SoLanMua' 

FROM KhachHang

LEFT JOIN HoaDon ON KhachHang.MaKhachHang = HoaDon.MaKhachHang

LEFT JOIN HoaDonChiTiet ON HoaDon.MaHoaDon = HoaDonChiTiet.MaHoaDon 

WHERE KhachHang.Diachi LIKE '%Hà Nội%'

GROUP BY KhachHang.MaKhachHang, KhachHang.HovaTenLot, KhachHang.Ten


--Câu 4: Cho biết top 1 số sản phầm được mua nhiều lần nhất: masanpham, tenSP, số lần mua.

SELECT TOP 1 HoaDonChiTiet.MaSanPham, TenSP, COUNT(*) as SoLanMua 

FROM HoaDonChiTiet JOIN SanPham ON HoaDonChiTiet.MaSanPham = SanPham.MaSanPham 

GROUP BY HoaDonChiTiet.MaSanPham, TenSP

ORDER BY SoLanMua DESC

--Câu 5: cho biết những sản phẩm chưa được mua lần nào: masanpham, tên sản phẩm, so luong, đơn giá.

SELECT HoaDonChiTiet.MaSanPham, TenSP, HoaDonChiTiet.SoLuong, DonGia 

FROM SanPham

LEFT JOIN HoaDonChiTiet ON SanPham.MaSanPham = HoaDonChiTiet.MaSanPham

WHERE HoaDonChiTiet.MaSanPham IS NULL

--Câu 5a: cho biết những Khách hàng chưa mua hàng lần nào: MaKH, họ tên, địa chỉ, điện thoại.

SELECT KhachHang.MakhachHang, HovaTenLot, Ten, Diachi, DienThoai 

FROM KhachHang 

LEFT JOIN HoaDon ON KhachHang.MaKhachHang = HoaDon.MakhachHang

WHERE HoaDon.MaHoaDon IS NULL
