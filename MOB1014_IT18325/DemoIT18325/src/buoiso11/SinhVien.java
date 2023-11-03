/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoiso11;

import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class SinhVien {

    Scanner sc = new Scanner(System.in);
    String hoTen;
    double diem;

    void nhap() {
        System.out.print("Nhap ho ten: ");
        hoTen = sc.nextLine();
        System.out.print("Nhap diem: ");
        diem = Double.parseDouble(sc.nextLine());
    }

    void xuat() {
        System.out.println("Ho ten: " + hoTen + " - " + "Diem: " + diem);
    }
}
