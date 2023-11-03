/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nghiantt_ph37410;

import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class NhanVien {

    Scanner sc = new Scanner(System.in);
    private String maNV;
    private String tenNV;
    private double luong;
    private int namSinh;

    public NhanVien() {
    }

    public NhanVien(String maNV, String tenNV, double luong, int namSinh) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.luong = luong;
        this.namSinh = namSinh;
    }

    public void nhap() {
        System.out.print("Nhap ma NV: ");
        maNV = sc.nextLine();
        System.out.print("Nhap ten NV: ");
        tenNV = sc.nextLine();
        System.out.print("Nhap luong: ");
        luong = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap nam sinh: ");
        namSinh = Integer.parseInt(sc.nextLine());

    }

    public void inThongTin() {
        System.out.println("Ma NV: " + maNV + " | " + "Ten NV: " + tenNV + " | " + "Luong: " + luong + " | " + "Tuoi: " + (2021 - namSinh) + " | " + "Trang thai: " + getTrangThai());
    }

    String getTrangThai() {
        String trangThai;
        if (luong > 5000) {
            return trangThai = "Tot";
        } else {
            return trangThai = "Binh thuong";
        }

    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

}
