/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoiso06.doituong;

import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class oTo {

    Scanner sc = new Scanner(System.in);
    //tạo thuộc tính(đặc điểm)
    String hang;
    double gia;

    //Hành vi = mô tả bằng phương thức
    /*
    2 phương thức cơ bản là nhập và xuất thông tin cho đối tượng
     */
    void nhap() {
        System.out.print("Nhập hãng oto: ");
        hang = sc.nextLine();
        System.out.print("Nhập giá oto: ");
        gia = Double.parseDouble(sc.nextLine());
    }

    void xuat() {
        System.out.println(hang + "-" + gia);
    }

    void moCua() {
        System.out.println("Cửa ơi mở ra!!!");
    }
}
