/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ph37410_baitonghop2;

import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
    QlyDoVat qly = new QlyDoVat();
    int choose;
        do {            
            System.out.println("+----------------- MENU -----------------+");
            System.out.println("1. Nhap danh sach");
            System.out.println("2. Xuat danh sach");
            System.out.println("3. Tim theo chat lieu");
            System.out.println("4. Xoa theo ten");
            System.out.println("5. Xoa theo chat lieu");
            System.out.println("6. Sap xep danh sach theo ma");
            System.out.println("7. Ke thua");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    qly.nhapDS();
                    break;
                case 2:
                    qly.xuatDS();
                    break;
                case 3:
                    qly.timTheoChatLieu();
                    break;
                case 4:
                    qly.xoaTheoTen();
                    break;
                case 5:
                    qly.xoaTheoChatLieu();
                    break;
                case 6:
                    qly.sxTheoMa();
                    break;
                case 7:
                    qly.keThua();
                    break;
                case 0:
                    qly.thoat();
                    break;
                default:
                    System.out.println("Vui long chon lai chuc nang!!!");
            }
        } while (true);
    }
}
