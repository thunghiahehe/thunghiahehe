/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baikt;

import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class HoaQua {

    Scanner sc = new Scanner(System.in);
    private String ma;
    private String ten;
    private double donGia;
    private String nguonGoc;

    public HoaQua() {
    }

    public HoaQua(String ma, String ten, double donGia, String nguonGoc) {
        this.ma = ma;
        this.ten = ten;
        this.donGia = donGia;
        this.nguonGoc = nguonGoc;
    }

    void nhap() {
        System.out.print("Nhap ma: ");
        ma = sc.nextLine();
        System.out.print("Nhap ten: ");
        ten = sc.nextLine();
        System.out.print("Nhap gia: ");
        donGia = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap nguon goc: ");
        nguonGoc = sc.nextLine();
    }

    void xuat() {
        System.out.println(ma + " - " + ten + " - " + donGia + " - " + nguonGoc);
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getNguonGoc() {
        return nguonGoc;
    }

    public void setNguonGoc(String nguonGoc) {
        this.nguonGoc = nguonGoc;
    }

}
