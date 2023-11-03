/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoiso07;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class MayTinh {

    int a, b, c;

    //constructor
    public MayTinh() {
    }

    public MayTinh(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public MayTinh(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    void tinhTong() {

    }

    void tinhTong(int a, int b) {
        System.out.println("tong = " + (a + b));
    }

    void tinhTong(int a, int b, int c) {
        System.out.println("tong = " + (a + b + c));
    }

    void tinhTong(double a, double b) {
        System.out.println("tong = " + (a + b));
    }
}
