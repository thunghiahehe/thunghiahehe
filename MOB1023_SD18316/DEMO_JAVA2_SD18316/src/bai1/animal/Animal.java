/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai1.animal;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class Animal {

    private String ten;
    private int chieuCao, canNang;

    public Animal() {
    }

    public Animal(String ten, int chieuCao, int canNang) {
        this.ten = ten;
        this.chieuCao = chieuCao;
        this.canNang = canNang;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getChieuCao() {
        return chieuCao;
    }

    public void setChieuCao(int chieuCao) {
        this.chieuCao = chieuCao;
    }

    public int getCanNang() {
        return canNang;
    }

    public void setCanNang(int canNang) {
        this.canNang = canNang;
    }

    @Override
    public String toString() {
        return "Animal{" + "ten=" + ten + ", chieuCao=" + chieuCao + ", canNang=" + canNang + '}';
    }

}
