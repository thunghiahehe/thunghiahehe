/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test2;

import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class Sach {

    Scanner sc = new Scanner(System.in);
    private String tenSach;
    private String nhaXuatBan;
    private int namSX;

    public Sach() {
    }

    public Sach(String tenSach, String nhaXuatBan, int namSX) {
        this.tenSach = tenSach;
        this.nhaXuatBan = nhaXuatBan;
        this.namSX = namSX;
    }

    public void nhap() {
        System.out.print("Nhap ten sach: ");
        tenSach = sc.nextLine();
        System.out.print("Nhap nha xuat ban: ");
        nhaXuatBan = sc.nextLine();
        System.out.print("Nhap nam san xuat: ");
        namSX = Integer.parseInt(sc.nextLine());

    }

    public void xuatTTSach() {
        System.out.println(tenSach + " | " + nhaXuatBan + " | " + namSX);
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public int getNamSX() {
        return namSX;
    }

    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }

}
