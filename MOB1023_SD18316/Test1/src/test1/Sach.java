/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test1;

import java.io.Serializable;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class Sach implements Serializable {

    private String ten, theLoai;
    double gia;

    public Sach() {
    }

    public Sach(String ten, String theLoai, double gia) {
        this.ten = ten;
        this.theLoai = theLoai;
        this.gia = gia;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "Sach{" + "ten=" + ten + ", theLoai=" + theLoai + ", gia=" + gia + '}';
    }

    Object[] toDataRow() {
        return new Object[]{this.ten, this.theLoai, this.gia};
    }
}
