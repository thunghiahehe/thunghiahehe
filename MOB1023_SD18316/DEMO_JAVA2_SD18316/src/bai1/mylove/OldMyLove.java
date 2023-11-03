/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai1.mylove;

import bai1.mylove.MyLove;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class OldMyLove extends MyLove{
    private int soThangYeuNhau;

    public OldMyLove(int soThangYeuNhau) {
        this.soThangYeuNhau = soThangYeuNhau;
    }

    public OldMyLove(int soThangYeuNhau, String hoTen, int tuoi) {
        super(hoTen, tuoi);
        this.soThangYeuNhau = soThangYeuNhau;
    }

    public int getSoThangYeuNhau() {
        return soThangYeuNhau;
    }

    public void setSoThangYeuNhau(int soThangYeuNhau) {
        this.soThangYeuNhau = soThangYeuNhau;
    }

    @Override
    void xuat() {
        super.xuat(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        System.out.println("So thang yeu nhau: "+getSoThangYeuNhau());
    }

    @Override
    void nhap() {
        super.nhap(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
