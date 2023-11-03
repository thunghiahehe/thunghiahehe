/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class MainNhanVien {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanLyNhanVien qly = new QuanLyNhanVien();
        int choose;
        do {
            System.out.println("+------------------------MENU------------------------------+");
            System.out.println("Y1. Nhap danh sach nhan vien tu ban phim.");
            System.out.println("Y2. Xuat danh sach nhan vien ra man hinh.");
            System.out.println("Y3. Tim va hien thi nhan vien theo ma nhap tu ban phim.");
            System.out.println("Y4. Xoa nhan vien theo ma nhap tu ban phim.");
            System.out.println("Y5. Cap nhat thong tin nhan vien theo ma nhap tu ban phim.");
            System.out.println("Y6. Tim nhan vien theo khoang luong nhap tu ban phim.");
            System.out.println("Y7. Sap xep nhan vien theo ho va ten.");
            System.out.println("Y8. Sap xep nhan vien theo thu nhap.");
            System.out.println("Y9. Xuat 5 nhan vien co thu nhap cao nhat.");
            System.out.println("0. Thoat");
            System.out.println("+-----------------------------------------------------------+");
            System.out.print("Moi ban chon yeu cau: ");
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    qly.nhapDS();
                    break;
                case 2:
                    qly.xuatDS();
                    break;
                case 3:
                    qly.timTheoMa();
                    break;
                case 4:
                    qly.xoaTheoMa();
                    break;
                case 5:
                    qly.capNhatTheoMa();
                    break;
                case 6:
                    qly.timNVienTheoKhoang();
                    break;
                case 7:
                    qly.sxTheoHoTen();
                    break;
                case 8:
                    qly.sxTheoThuNhap();
                    break;
                case 9:
                    qly.xuatNVienTNhapMax();
                    break;
                case 0:
                    qly.thoat();
                    break;
                default:
                    System.out.print("Ban nhap sai vui long nhap lai!");
            }
        } while (true);
    }
}
