/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoiso03;

import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class BTThemSo3 {

    public static void main(String[] args) {
        //In menu và thực hiện chọn chức năng
        sinhVien();
    }

    static void Crush() {
        //Khai báo 1 biến crush - kiểu doube chạy từ 12 đến 20
        double crush = 12 + 8 * Math.random();
        //Kt giá trị của crush và đưa ra kết quả.
    }

    static void sinhVien() {
        Scanner sc = new Scanner(System.in);
        int hanhKiem;
        boolean check = true;
        // Nâng cấp sử dụng switch
        do {
            System.out.print("Nhập vào hạnh kiểm: ");
            hanhKiem = sc.nextInt();
            switch (hanhKiem) {
                case 1,2,3:
                    check = false;
                    break;
                default:
                    System.out.println("Hanh kiem la cac gia tri: 1(Tốt)-2(Khá)-3(Trung bình) ");
            }
        } while (check);
        System.out.println("Hạnh kiểm = " + (hanhKiem == 1 ? "Tốt" : hanhKiem == 2 ? "Khá" : "Trung Bình"));
        //Nâng cấp sử dụng if
        check = true;
        do {
            System.out.print("Nhập vào hạnh kiểm 2: ");
            hanhKiem = sc.nextInt();
            if (hanhKiem == 1 || hanhKiem == 2 || hanhKiem == 3) {
                check = false;
            } else {
                System.out.println("Hanh kiem la cac gia tri: 1(Tốt)-2(Khá)-3(Trung bình)");
            }
        } while (check);
        System.out.println("Hạnh kiểm 2= " + (hanhKiem == 1 ? "Tốt" : hanhKiem == 2 ? "Khá" : "Trung Bình"));
    }

    static void thoat() {

    }

}
