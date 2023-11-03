/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tonghop_java1_01;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class HangXuatKhau extends HangHoa {

    //1. Thêm thuộc tính
    private String qGia;

    //2. Tạo hàm tạo có đủ tham số đầu vào
    public HangXuatKhau(String qGia, String maHang, String tenHang, double soLuong, double donGia) {
        super(maHang, tenHang, soLuong, donGia);
        this.qGia = qGia;
    }

    //3. Thuế 
    //Phương thức thuế không trả về giá trị
    public void thue() {
        System.out.println("Thue: " + getDonGia() * 0.1);
    }

    //Phương thức thuế không trả về giá trị
    public double thue2() {
        return getDonGia() * 0.1;
    }
    //4. Ghi đè phương thức xuất của lớp cha (class HangHoa)

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Quoc gia: " + qGia);
        System.out.println("Thue: " + thue2());
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public String getqGia() {
        return qGia;
    }

    public void setqGia(String qGia) {
        this.qGia = qGia;
    }

}
