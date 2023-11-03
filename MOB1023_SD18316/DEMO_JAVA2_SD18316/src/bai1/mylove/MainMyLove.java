/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai1.mylove;

import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class MainMyLove {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanLy qly = new QuanLy();
        do {
            System.out.println("1. Nhap MyLove vao list");
            System.out.println("2. In DS MyLove");
            System.out.println("3. Tim MyLove theo ten");
            System.out.println("4. Xoa theo tuoi nhap vao");
            System.out.println("5. Sx theo ten MyLove");
            System.out.println("6. Ke thua");
            System.out.println("0. Thoat");
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
                    qly.timTheoTen();
                    break;
                case 4:
                    qly.xoaTheoTuoi();
                    break;
                case 5:
                    qly.sxTheoTen();
                    break;
                case 6:
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
