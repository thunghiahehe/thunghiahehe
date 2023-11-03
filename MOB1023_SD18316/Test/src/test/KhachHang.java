package test;


import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class KhachHang implements Serializable{

    private String ma, ten, quocTich, gioiTinh;

    public KhachHang() {
    }

    public KhachHang(String ma, String ten, String quocTich, String gioiTinh) {
        this.ma = ma;
        this.ten = ten;
        this.quocTich = quocTich;
        this.gioiTinh = gioiTinh;
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

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "ma=" + ma + ", ten=" + ten + ", quocTich=" + quocTich + ", gioiTinh=" + gioiTinh + '}';
    }

    String getPhanLoai() {
        if (this.gioiTinh.equalsIgnoreCase("nam")) {
            return "Thích giải trí";
        } else {
            return "Thích mua sắm";
        }
    }

    Object[] toDataRow() {
        return new Object[]{this.ma, this.ten, this.quocTich, this.gioiTinh, this.getPhanLoai()};
    }
}
