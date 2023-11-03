/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab04;

import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class SanPham {

    Scanner sc = new Scanner(System.in);
    private String tenSP;
    private double donGia;
    private double giamGia;

    public SanPham() {
    }

    public SanPham(String tenSP, double donGia, double giamGia) {
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.giamGia = giamGia;
    }

    public SanPham(String tenSP, double donGia) {
        this.tenSP = tenSP;
        this.donGia = donGia;
    }

    void nhap() {
        System.out.print("Nhap ten san pham: ");
        tenSP = sc.nextLine();
        System.out.print("Nhap don gia: ");
        donGia = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap ma giam gia: ");
        giamGia = Double.parseDouble(sc.nextLine());
    }

    void xuat() {
        System.out.println("Ten san pham: " + tenSP);
        System.out.println("Don gia: " + donGia);
        System.out.println("Giam gia: " + giamGia);
        System.out.println("Thue nhap khau: " + thueNhapKhau());
    }

    private double thueNhapKhau() {
        return (donGia * 0.1);
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(double giamGia) {
        this.giamGia = giamGia;
    }
    
}
