/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baikt;

import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QlyHoaQua qly = new QlyHoaQua();
        int choose;
        do {
            System.out.println("+------------------------- MENU -----------------------+");
            System.out.println("1. Nhap danh sach hoa qua");
            System.out.println("2. Xuat danh sach");
            System.out.println("3. Sap xep hoa qua theo nguon goc tang dan va in");
            System.out.println("4. Xoa hoa qua theo ma nhap vao va in lai danh sach");
            System.out.println("5. Thoat");
            System.out.println("+------------------------------------------------------+");
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
                    qly.sxNGTangDan();
                    break;
                case 4:
                    qly.xoatheoMa();
                    break;
                case 5:
                    qly.thoat();
                    break;
                default:
                    System.out.println("Vui long nhap lai chuc nang");
            }
        } while (true);
    }

}
