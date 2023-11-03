/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoiso01;

import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class main {

    public static void main(String[] args) {
        //XUẤT DỮ LIỆU
        //Tự động xuống dòng
        System.out.println("Hello, chao MOB1014");
        System.out.println("Van con nguoi choi dien tu trong lop");
        //Không ngắt dòng
        System.out.print("Hello, chao MOB1014");
        System.out.print("Van con nguoi choi dien tu trong lop");
        //Xuất dữ liệu ra màn hình có sử dụng ký tự định dạng DL
        //không tự động ngắt dòng
        System.out.printf("Hello, chao MOB1014\n");
        System.out.printf("Van con nguoi choi dien tu trong lop. Cho %d diem\n", 0);
        //NHẬP VÀO 1 SỐ NGUYÊN VÀ IN RA MÀN HÌNH
        //1.Khai báo biến
        int a;
        //2.Nhập
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao so nguyen: ");
        a = sc.nextInt();
        System.out.printf("So vua nhap: %d\n", a);
        //=> Biến kiểu int thì gọi nextInt()
        //=> Biến kiểu double thì gọi là nextDouble()
        //=> Biến kiểu String thì gọi là nextLine()

    }
}
