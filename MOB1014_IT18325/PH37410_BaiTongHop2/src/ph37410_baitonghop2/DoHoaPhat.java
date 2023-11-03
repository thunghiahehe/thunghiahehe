/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ph37410_baitonghop2;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class DoHoaPhat extends DoVat{
    private int loai;

    public DoHoaPhat(int loai, String maDoVat, String tenDoVat, String chatLieu) {
        super(maDoVat, tenDoVat, chatLieu);
        this.loai = loai;
    }

    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }

    @Override
    public void nhap() {
        super.nhap(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    @Override
    public void inThongTin() {
        super.inThongTin();
        System.out.println("Loai: "+getLoai());
    }
    
    
}
