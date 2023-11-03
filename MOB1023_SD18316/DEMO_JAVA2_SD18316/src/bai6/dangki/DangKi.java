/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai6.dangki;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class DangKi {

    private String maSV, trangThai, gioiTinh;

    public DangKi() {
    }

    public DangKi(String maSV, String trangThai, String gioiTinh) {
        this.maSV = maSV;
        this.trangThai = trangThai;
        this.gioiTinh = gioiTinh;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    Object[] toDataRow() {
        return new Object[]{this.maSV, this.trangThai, this.gioiTinh};
    }
}
