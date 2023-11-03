/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nguyenthithunghia_ph37410_test;

import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QlyGiaoVien qly = new QlyGiaoVien();
        do {
            System.out.println("+---------------- MENU ----------------+");
            System.out.println("1. Nhap danh sach giao vien");
            System.out.println("2. Xuat danh sach ");
            System.out.println("3. Xuat DSGV theo khoang Tuoi");
            System.out.println("4. Tim GV theo ho ten");
            System.out.println("5. Sap xep theo ho ten giam dan");
            System.out.println("6. Xoa GV theo ho ten nhap vao");
            System.out.println("7. Ke thua");
            System.out.println("8. Thoat");
            System.out.println("+--------------------------------------+");
            System.out.print("Chon chuc nang: ");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    qly.nhapDS();
                    break;
                case 2:
                    qly.xuatDS();
                    break;
                case 3:
                    qly.xuatTheoKhoangTuoi();
                    break;
                case 4:
                    qly.timTheoHoTen();
                    break;
                case 5:
                    qly.sxTheoHotenGiamDan();
                    break;
                case 6:
                    qly.xoaTheoHoTen();
                    break;
                case 7:
                    qly.keThua();
                    break;
                case 8:
                    qly.thoat();
                    break;
                default:
                    System.out.println("Vui long chon lai chuong trinh!!!");
            }
        } while (true);
    }
}
