/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai2.mylove;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class MyLove {

    private String hoTen;
    private String gioiTinh;
    private int tuoi;

    public MyLove() {
    }

    public MyLove(String hoTen, String gioiTinh, int tuoi) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.tuoi = tuoi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    Object[] toDataRow() {
        return new Object[]{this.getHoTen(), this.getTuoi(), this.getGioiTinh()};
    }

    @Override
    public String toString() {
        return "MyLove{" + "hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", tuoi=" + tuoi + '}';
    }

}
