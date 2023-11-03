/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nguyenthithunghia_ph37410_test;

import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class GiaoVien {

    Scanner sc = new Scanner(System.in);
    private String hoTen;
    private int tuoi;
    private double luong;

    public GiaoVien() {
    }

    public GiaoVien(String hoTen, int tuoi, double luong) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.luong = luong;
    }

    public void nhap() {
        System.out.print("Nhap ho ten: ");
        hoTen = sc.nextLine();
        System.out.print("Nhap tuoi: ");
        tuoi = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap luong: ");
        luong = Double.parseDouble(sc.nextLine());
    }

    public void xuat() {
        System.out.println(hoTen + " | " + tuoi + " | " + luong);
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

}
