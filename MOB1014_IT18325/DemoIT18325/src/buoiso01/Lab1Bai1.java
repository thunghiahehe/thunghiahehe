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
public class Lab1Bai1 {

    public static void main(String[] args) {
        String hoTen;
        double diem;
        String lop;
        Scanner sc = new Scanner(System.in);
        System.out.print("Ho va ten sinh vien: ");
        hoTen = sc.nextLine();
        System.out.print("Diem trung binh: ");
        diem = sc.nextDouble();
        sc.nextLine(); //chống trôi lệnh sau khi nhập số
        System.out.print("Lop: ");
        lop = sc.nextLine();
    }
}
