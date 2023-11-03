/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nguyenthithunghia_ph37410_test;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class GiaoVienCoHuu extends GiaoVien {

    private int nam;

    public GiaoVienCoHuu() {
    }

    public GiaoVienCoHuu(int nam, String hoTen, int tuoi, double luong) {
        super(hoTen, tuoi, luong);
        this.nam = nam;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    @Override
    public void nhap() {
        super.nhap(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void xuat() {
        super.xuat(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        System.out.println("Nam ki hop dong: " + getNam());
    }

}
