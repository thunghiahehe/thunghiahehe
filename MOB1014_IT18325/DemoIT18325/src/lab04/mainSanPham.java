/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab04;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class mainSanPham {

    public static void main(String[] args) {
        SanPham sp1 = new SanPham();
        SanPham sp2 = new SanPham();
        //Nhập
        sp1.nhap();
        sp2.nhap();
        //Xuất
        sp1.xuat();
        sp2.xuat();
        //Tạo 2 sản phẩm 1 có giảm giá (3 tham số) và 1 không giảm giá (2 tham số)
        SanPham sp3= new SanPham("Banh mi", 20000, 1000);
        SanPham sp4= new SanPham("Zit nuong", 200000 );
        
        sp3.xuat();
        sp4.xuat();
    }
}
