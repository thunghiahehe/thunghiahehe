/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoiso07.sinhVien;

import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class MainSinhVien {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double diem;
        String ten;
        SinhVien sv1 = new SinhVien();
        SinhVien sv2 = new SinhVien("Nguyen Van Nam", 9.5);

        sv1.nhap();
        sv1.xuat();

        //Cập nhật lại điểm cho sv1
        //Nhập điểm
        System.out.print("Nhap diem moi: ");
        diem = Double.parseDouble(sc.nextLine());
        //Biến điểm vừa nhập thành điểm của sv1
        sv1.setDiemTB(diem);
        sv1.xuat();

        //Cập nhật lại điểm cho sv1
        //Nhập tên
        System.out.print("Ten cap nhat: ");
        ten = sc.nextLine();
        //
        sv1.setHoTen(ten);
        sv1.xuat();

        //Thay đổi TOÀN BỘ thông tin sv2
        sv2.nhap();
        sv2.xuat();
    }
}
