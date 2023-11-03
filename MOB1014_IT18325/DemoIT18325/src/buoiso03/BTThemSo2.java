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
public class BTThemSo2 {

    public static void main(String[] args) {
        //Xây dựng menu + gọi các phương thức chức năng tại đây
        Scanner sc = new Scanner(System.in);
        int chon;
        //In ra menu va chọn CN
        do {
            //1. In ra menu
            System.out.println("M_E_N_U");
            System.out.println("1.Căn bậc 2");
            System.out.println("2.Sinh viên");
            System.out.println("3.Thoát");
            System.out.println("_______");
            //2. Nhập giá trị cho biến chọn      
            System.out.println("Bạn chọn chức năng số: ");
            chon = sc.nextInt();
            sc.nextLine();//chống trôi lệnh
            //3. Chạy các chức năng sau khi chọn chức năng ở bước 2
            switch (chon) {
                case 1:
                    canBacHai();
                    break;
                case 2:
                    sinhVien();
                    break;
                case 3:
                    thoat();
                    break;
                default:
                    System.out.println("Bạn cần chọn đúng chức năng");
            }
        } while (true);
    }

    static void canBacHai() {
        //Nhập vào 1 số, Nếu là số dương tính và in căn bậc 2, nếu ko in ra "Đây là số âm"
        Scanner sc = new Scanner(System.in);
        double number;
        System.out.println("Nhập vào 1 số: ");
        number = sc.nextDouble();
        if (number > 0) {
            //In ra căn bậc 2
            System.out.printf("Căn bậc 2 của %.1f là: %.1f\n", number, Math.sqrt(number));
        } else {
            System.out.println("Đây là số âm.");
        }
    }

    static void sinhVien() {
        //Nhập các thông tin theo yêu cầu và in ra màn hình
        //Khai báo
        Scanner sc = new Scanner(System.in);
        String hoTen, lop;
        double diemTB = 0;
        //Nhập
        System.out.print("Nhập họ tên sv: ");
        hoTen = sc.nextLine();
        System.out.print("Nhập điểm TB sv: ");
        try {
            diemTB = sc.nextDouble();
        } catch (Exception e) {
            System.out.println("Bạn phải nhập vào 1 số");
        }
        sc.nextLine();//chống trôi lệnh
        System.out.print("Nhập lớp sv: ");
        lop = sc.nextLine();
        //Thực hiện CV: hiển thị TT ra màn hình
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Điểm TB: " + diemTB);
        System.out.println("Lớp: " + lop);
    }

    static void thoat() {
        System.exit(0);
    }
}
