/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai234.lab7;

import java.util.Scanner;

/**
 *
 * @author nthha
 */
//BÀI 4
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Tạo 1 đối tượng quản lý hàng hóa
        QlySinhVien qLy = new QlySinhVien();
        //Viết menu tại đây
        int chon;
        do {
            //1. In ra menu
            System.out.println("________M_E_N_U______");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. Xuất danh sách sinh viên");
            System.out.println("3. Xuất danh sách sinh viên có HL giỏi");
            System.out.println("4. Sắp xếp DS sinh viên theo điểm");
            System.out.println("5. Kêt thúc");
            System.out.println("_____________________");
            //2. Nhập vào chức năng muốn sử dụng
            System.out.print("Mời bạn chọn chức năng: ");
            chon = Integer.parseInt(sc.nextLine());
            //3. Chạy chức năng vừa chọn          
            switch (chon) {
                case 1:
                    qLy.nhapDS();
                    break;
                case 2:
                    qLy.xuatDS();
                    break;
                case 3:
                    qLy.svGioi();
                    break;
                case 4:
                    qLy.sapXep();
                    break;
                case 5:
                    qLy.thoat();
                    break;
                default:
                    System.out.println("Bạn cần chọn đúng CN.");
            }
        } while (true);

    }
}

