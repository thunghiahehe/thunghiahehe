/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class Profile {

    private String ten, nhomMau, queQuan;
    private double thuNhap;

    public Profile() {
    }

    public Profile(String ten, String nhomMau, String queQuan, double thuNhap) {
        this.ten = ten;
        this.nhomMau = nhomMau;
        this.queQuan = queQuan;
        this.thuNhap = thuNhap;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNhomMau() {
        return nhomMau;
    }

    public void setNhomMau(String nhomMau) {
        this.nhomMau = nhomMau;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public double getThuNhap() {
        return thuNhap;
    }

    public void setThuNhap(double thuNhap) {
        this.thuNhap = thuNhap;
    }

    @Override
    public String toString() {
        return "Profile{" + "ten=" + ten + ", nhomMau=" + nhomMau + ", queQuan=" + queQuan + ", thuNhap=" + thuNhap + '}';
    }

    Object[] toDataRow() {
        return new Object[]{this.ten, this.thuNhap, this.nhomMau, this.queQuan};
    }
}
