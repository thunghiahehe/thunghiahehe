/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai3.sinhvien;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class SinhVien {//data

    private String ten;
    private double diem;
    private String nganh;

    //Phương thức
    String getHocLuc() {
        if (this.diem >= 9) {
            return "Giỏi";
        } else // diem<9
        if (this.diem >= 7) {
            return "Khá";
        } else if (this.diem >= 5) {
            return "Trung bình";
        } else //diem<5
        {
            return "Bạn đã trúng thưởng 900k";
        }
    }

    boolean getThuong() {
        if (this.diem >= 9) {
            return true;
        } else {
            return false;
        }
    }

    Object[] toDataRow() {
        return new Object[]{this.getTen(), this.getDiem(), this.getNganh(), this.getHocLuc(), this.getThuong()};
    }

    public SinhVien() {
    }

    public SinhVien(String ten, double diem, String nganh) {
        this.ten = ten;
        this.diem = diem;
        this.nganh = nganh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    @Override
    public String toString() {
        return "SinhVien{" + "ten=" + ten + ", diem=" + diem + ", nganh=" + nganh + '}';
    }

}
