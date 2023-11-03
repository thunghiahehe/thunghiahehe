/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Buoi6;

import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
class SinhVien {
    private String maSV;
    private double diemTB;

    public SinhVien() {
    }

    public SinhVien(String maSV, double diemTB) {
        this.maSV = maSV;
        this.diemTB = diemTB;
    }

    
    public void nhapThongTin() {
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Nhap ma sinh vien: ");
        maSV=sc.nextLine();
        
        System.out.println("Nhap diem trung binh: ");
        diemTB=sc.nextDouble();
    }

    public void xuatThongTin() {
        System.out.println("Ma sinh vien: " + maSV);
        System.out.println("Diem trung binh: " + diemTB);
    }
}
