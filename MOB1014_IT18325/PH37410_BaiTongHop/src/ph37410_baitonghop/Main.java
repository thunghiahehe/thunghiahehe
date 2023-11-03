/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ph37410_baitonghop;

import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QlyDoAn qly = new QlyDoAn();
        int choose;
        do {
            System.out.println("+-------------------- MENU --------------------+");
            System.out.println("\t1. Nhap danh sach");
            System.out.println("\t2. Xuat danh sach");
            System.out.println("\t3. Tim theo ten");
            System.out.println("\t4. Tim theo ma");
            System.out.println("\t5. Xoa theo ten");
            System.out.println("\t6. Xoa theo ma");
            System.out.println("\t7. Tim theo khoang so luong");
            System.out.println("\t8. Tim theo khoang gia");
            System.out.println("\t9. Ke thua");
            System.out.println("\t0. Thoat");
            System.out.println("+----------------------------------------------+");
            System.out.print("Chon chuc nang: ");
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    qly.nhapDS();
                    break;
                case 2:
                    qly.xuatDS();
                    break;
                case 3:
                    qly.timTheoTen();
                    break;
                case 4:
                    qly.timTheoMa();
                    break;
                case 5:
                    qly.xoaTheoTen();
                    break;
                case 6:
                    qly.xoaTheoMa();
                    break;
                case 7:
                    qly.timTheoKhoangSL();
                    break;
                case 8:
                    qly.timTheoKhoangGia();
                    break;
                case 9:
                    qly.keThua();
                    break;
                case 0:
                    qly.thoat();
                    break;
                default:
                    System.out.println("Vui long chon lai chuong trinh!");
            }

        } while (true);
    }
}
