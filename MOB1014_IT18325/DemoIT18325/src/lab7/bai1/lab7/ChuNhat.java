/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai1.lab7;

import java.net.Socket;

/**
 *
 * @author nthha
 */
public class ChuNhat {
    //1. Thuộc tính
    private double rong, dai;
    
    //2. Hàm tạo 2 tham số
    public ChuNhat(double rong, double dai) {
        this.rong = rong;
        this.dai = dai;
    }
    
    //3. Phương thức tính chu vi, diện tích
    public double getChuVi(){
        return (dai+rong)*2;
    }
    public double getDienTich(){
        return dai*rong;
    }
    
    //4. phương thức xuất
    public void xuat(){
        System.out.println("C.dai = "+dai);
        System.out.println("C.rong = "+rong);
        System.out.println("Chu vi = "+getChuVi());
        System.out.println("Dien tich = "+getDienTich());
    }
    
    //5. Tạo getter and setter

    public double getRong() {
        return rong;
    }

    public void setRong(double rong) {
        this.rong = rong;
    }

    public double getDai() {
        return dai;
    }

    public void setDai(double dai) {
        this.dai = dai;
    }
    
}
