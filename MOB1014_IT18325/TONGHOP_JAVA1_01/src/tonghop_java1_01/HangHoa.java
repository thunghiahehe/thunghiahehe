/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tonghop_java1_01;

import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class HangHoa {

    //Đây là lớp hàng hóa
    Scanner sc = new Scanner(System.in);
    private String maHang;
    private String tenHang;
    private double soLuong;
    private double donGia;

    public HangHoa() {
    }

    public HangHoa(String maHang, String tenHang, double soLuong, double donGia) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    

    public void nhap() {
        System.out.print("Nhap ma hang: ");
        maHang = sc.nextLine();
        System.out.print("Nhap ten hang: ");
        tenHang = sc.nextLine();
        System.out.print("Nhap so luong: ");
        soLuong = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap don gia: ");
        donGia = Double.parseDouble(sc.nextLine());
    }

    public void xuat() {
        System.out.println(maHang + " - " + tenHang + " - " + soLuong + " - " + donGia);
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String MaHang) {
        this.maHang = MaHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String TenHang) {
        this.tenHang = TenHang;
    }

    public double getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(double SoLuong) {
        this.soLuong = SoLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double DonGia) {
        this.donGia = DonGia;
    }

   
}
