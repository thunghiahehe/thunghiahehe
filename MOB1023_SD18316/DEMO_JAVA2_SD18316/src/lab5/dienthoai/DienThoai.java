/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5.dienthoai;

import java.io.Serializable;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class DienThoai implements Serializable{

    private String ten, hang;
    private double gia;

    public String getLoai() {
        if (this.gia > 25) {
            return "Cao cấp";
        } else if (this.gia > 15) {
            return "Đắt";
        } else {
            return "Trung bình";
        }
    }

    public DienThoai() {
    }

    public DienThoai(String ten, String hang, double gia) {
        this.ten = ten;
        this.hang = hang;
        this.gia = gia;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    Object[] toDataRow() {
        return new Object[]{this.getTen(), this.getHang(), this.getGia(), this.getLoai()};
    }
}
