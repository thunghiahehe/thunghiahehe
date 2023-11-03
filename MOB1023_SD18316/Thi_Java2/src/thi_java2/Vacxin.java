/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thi_java2;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class Vacxin implements Serializable {

    private String ma, ten, xuatXu, hinhThuc;
    private int nam;

    String getPhanLoai() {
        if (this.xuatXu.equalsIgnoreCase("viet nam")) {
            return "hang noi dia";
        } else if (this.xuatXu.equalsIgnoreCase("an do")) {
            return "hang re";
        } else {
            return "hang co thue";
        }
    }

    public String getMaRandom() {
        String text = "ggddfueyfwbdhhgfhdvskaafdakeuurgbvn";
        String kyTu = "!+-_";

        StringBuilder ma = new StringBuilder();
        int index;
        for (int i = 0; i < 4; i++) {
            index = new Random().nextInt(text.length());
            ma.append(text.charAt(index));
        }
        for (int i = 0; i < 3; i++) {
            index = new Random().nextInt(text.length());
            ma.append(text.toUpperCase().charAt(index));
        }
        for (int i = 0; i < 2; i++) {
            index = new Random().nextInt(9);
            ma.append(index);
        }
        index = new Random().nextInt(kyTu.length());
        ma.append(kyTu.charAt(index));
        return ma.toString();
    }

    public Vacxin() {
    }

    public Vacxin(String ma, String ten, String xuatXu, String hinhThuc, int nam) {
        this.ma = ma;
        this.ten = ten;
        this.xuatXu = xuatXu;
        this.hinhThuc = hinhThuc;
        this.nam = nam;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public String getHinhThuc() {
        return hinhThuc;
    }

    public void setHinhThuc(String hinhThuc) {
        this.hinhThuc = hinhThuc;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    @Override
    public String toString() {
        return "Vacxin{" + "ma=" + ma + ", ten=" + ten + ", xuatXu=" + xuatXu + ", hinhThuc=" + hinhThuc + ", nam=" + nam + '}';
    }

    Object[] toDataRow() {
        return new Object[]{this.ma, this.ten, this.hinhThuc, this.nam, this.xuatXu, this.getPhanLoai()};
    }
}
