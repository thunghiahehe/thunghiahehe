/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai5;

import java.io.Serializable;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class MonHoc implements Serializable{

    private String ma, ten;
    private int soTinChi;

    public MonHoc() {
    }

    public MonHoc(String ma, String ten, int soTinChi) {
        this.ma = ma;
        this.ten = ten;
        this.soTinChi = soTinChi;
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

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    @Override
    public String toString() {
        return "MonHoc{" + "ma=" + ma + ", ten=" + ten + ", soTinChi=" + soTinChi + '}';
    }

    Object[] toDataRow() {
        return new Object[]{this.getMa(), this.getTen(), this.getSoTinChi()};
    }
}
