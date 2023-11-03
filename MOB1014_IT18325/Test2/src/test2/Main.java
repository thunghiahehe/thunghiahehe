/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test2;

import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QLSach qly = new QLSach();;
        do {
            System.out.println("+----------------- MENU -----------------+");
            System.out.println("1. nhap 1 danh sach doi tuong");
            System.out.println("2. Xuat danh sach doi tuong");
            System.out.println("3. Xoa 1 doi tuong khoi danh sach");
            System.out.println("4. Tim theo khoang nam xuat ban");
            System.out.println("5. Ke thua");
            System.out.println("0. Thoat");
            System.out.println("+----------------------------------------+");
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
                    qly.xoa1DoiTuong();
                    break;
                case 4:
                    qly.timTheoKhoangNam();
                    break;
                case 5:
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
