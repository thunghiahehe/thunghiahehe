/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ph37410_baitonghop;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class DoAnNhanh extends DoAn {

    private double giamGia;

    public DoAnNhanh() {
    }

    public DoAnNhanh(double giamGia) {
        this.giamGia = giamGia;
    }

    public DoAnNhanh(double giamGia, String maDoAn, String tenDoAn, double soLuong, double donGia) {
        super(maDoAn, tenDoAn, soLuong, donGia);
        this.giamGia = giamGia;
    }

    public void xuat() {
        System.out.println("Giam gia: " + getGiamGia());
    }

    public double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(double giamGia) {
        this.giamGia = giamGia;
    }

}
