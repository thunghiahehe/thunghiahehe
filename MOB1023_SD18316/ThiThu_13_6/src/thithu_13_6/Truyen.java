/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thithu_13_6;

import java.io.Serializable;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class Truyen implements Serializable {

    private String ma, ten, theLoai;
    private int nam;

    String getLoai() {
        if (this.theLoai.equalsIgnoreCase("hien dai")) {
            return "Nang dong";
        } else if (this.theLoai.equalsIgnoreCase("kiem hiep")) {
            return "Manh me";
        } else {
            return "Tinh cam";
        }
    }

    public Truyen() {
    }

    public Truyen(String ma, String ten, String theLoai, int nam) {
        this.ma = ma;
        this.ten = ten;
        this.theLoai = theLoai;
        this.nam = nam;
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

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    @Override
    public String toString() {
        return "Truyen{" + "ma=" + ma + ", ten=" + ten + ", theLoai=" + theLoai + ", nam=" + nam + '}';
    }

    Object[] toDataRow() {
        return new Object[]{this.ma, this.ten, this.nam, this.theLoai, this.getLoai()};
    }
}
