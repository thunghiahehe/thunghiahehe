/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Buoi6;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class DongVat {

    private double canNang;
    private String loai;

    public DongVat(double canNang, String loai) {
        this.canNang = canNang;
        this.loai = loai;
    }

    public void tiengKeu() {
        if (loai.equals("mèo")) {
            System.out.println("meo meo");
        } else if (loai.equals("cho")) {
            System.out.println("gau gau");
        }
    }

}
