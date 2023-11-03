/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai4;

import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class TryCatch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String hoTen = null;
        int tuoi;
        //Tên: các chữ cái + dấu cách
        //Tuổi: 0-120
        System.out.print("Moi nhap ho ten: ");
        hoTen = sc.nextLine();
        if (hoTen.matches("[a-zA-Z ]+")) {
            System.out.println("Ho ten dung dinh dang");
        } else {
            System.out.println("Ho ten sai dinh dang!!!");
        }
        System.out.print("Moi nhap tuoi: ");
        try {
            tuoi = sc.nextInt();
            if (tuoi < 0 || tuoi > 120) {
                System.out.println("Tuoi sai du lieu");
            } else {
                System.out.println("Tuoi: " + tuoi);
            }
        } catch (Exception e) {
            System.out.println("Tuoi khong phai la so!");
        }

    }
}
