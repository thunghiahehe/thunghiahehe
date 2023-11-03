/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class TiepThi extends NhanVien {

    private double doanhSo, hoaHong;

    public TiepThi(String maNV, String hoTen, double doanhSo, double hoaHong, double luong) {
        super(maNV, hoTen, luong);
        this.doanhSo = doanhSo;
        this.hoaHong = hoaHong;
    }
    
    public double getDoanhSo() {
        return doanhSo;
    }

    public void setDoanhSo(double doanhSo) {
        this.doanhSo = doanhSo;
    }

    public double getHoaHong() {
        return hoaHong;
    }

    public void setHoaHong(double hoaHong) {
        this.hoaHong = hoaHong;
    }
    
    
    @Override
    double getThuNhap() {
        return luong + doanhSo + hoaHong;
    }

}
