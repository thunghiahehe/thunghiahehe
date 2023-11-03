/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai1.mylove;

import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class MyLove {

    Scanner sc = new Scanner(System.in);
    private String hoTen;
    private int tuoi;

    public MyLove() {
    }

    public MyLove(String hoTen, int tuoi) {
        this.hoTen = hoTen;
        if (tuoi < 0 || tuoi > 120) {
            System.out.println("Tuoi khong hop le");
            this.tuoi = 18;
        } else // 0<=tuoi<=120
        {
            this.tuoi = tuoi;
        }
    }

    void nhap() {
        System.out.print("Nhap ten: ");
        hoTen = sc.nextLine();
        System.out.print("Nhap tuoi: ");
        tuoi = Integer.parseInt(sc.nextLine());
    }

    void xuat() {
        System.out.println(hoTen + " | " + tuoi);
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        if (tuoi < 0 || tuoi > 120) {
            this.tuoi = 18;
        } else {
            this.tuoi = tuoi;
        }
    }

}
