/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoiso10;

import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class SinhVien {

    Scanner sc = new Scanner(System.in);
    //thuộc tính
    private String hoTen;
    private double diemTB;
    private String maSV;
    private String nganh;

    //hàm tạo
    public SinhVien() {
    }

    public SinhVien(String hoTen, double diemTB) {
        this.hoTen = hoTen;
        this.diemTB = diemTB;
    }

    public SinhVien(String hoTen, double diemTB, String maSV, String nganh) {
        this.hoTen = hoTen;
        this.diemTB = diemTB;
        this.maSV = maSV;
        this.nganh = nganh;
    }

    //phương thức
    void nhap() {
        System.out.print("Ho ten: ");
        hoTen = sc.nextLine();
        System.out.print("MSV: ");
        maSV = sc.nextLine();
        System.out.print("Nganh: ");
        nganh = sc.nextLine();
        System.out.print("Diem TB: ");
        diemTB = Double.parseDouble(sc.nextLine());
    }

    void xuat() {
        System.out.println(hoTen + " - " + maSV + " - " + nganh + " - " + diemTB + " - " + xepLoai());
    }

    String xepLoai() {
        if (diemTB > 8) {
            return "Gioi";
        } else if (diemTB > 6.5) {
            return "Kha";
        } else {
            return "Trung binh";
        }
    }

    public double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

}
//Thực hiện các công việc sau trong package: buoihocso7.sinhvien
//- Yêu cầu 1: nâng cấp chương trình, thêm đặc tả truy xuất private cho các thuộc tính
//- Yêu cầu 2: Thực hiện nhập vào các thông tin của đối tượng sv1, xuất thông tin ra màn hình
//- Yêu cầu 3: Thực hiện thay cập nhật lại điểm TB cho đối tượng sv1, sau đó xuất thông tin ra màn hình
//- Yêu cầu 4: Thực hiện thay cập nhật lại họ tên cho đối tượng sv1, sau đó xuất thông tin ra màn hình
//- Yêu cầu 5: Thực hiện thay cập nhật lại toàn bộ thông tin cho đối tượng sv2, sau đó xuất thông tin ra màn hình
