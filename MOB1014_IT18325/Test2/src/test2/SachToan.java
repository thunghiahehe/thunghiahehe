/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test2;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class SachToan extends Sach {

    private Double giaSach;

    public SachToan() {
    }

    public SachToan(Double giaSach, String tenSach, String nhaXuatBan, int namSX) {
        super(tenSach, nhaXuatBan, namSX);
        this.giaSach = giaSach;
    }

    public Double getGiaSach() {
        return giaSach;
    }

    public void setGiaSach(Double giaSach) {
        this.giaSach = giaSach;
    }

    @Override
    public void nhap() {
        super.nhap(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    @Override
    public void xuatTTSach() {
        super.xuatTTSach(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        System.out.println("Gia sach: " + getGiaSach());
    }

}
