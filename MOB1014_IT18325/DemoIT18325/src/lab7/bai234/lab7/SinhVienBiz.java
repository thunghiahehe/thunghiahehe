/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai234.lab7;

import java.util.Scanner;

/**
 *
 * @author nthha
 */

//BÀI 3
public class SinhVienBiz extends SinhVienPoly{
    Scanner sc = new Scanner(System.in); //bài 4
    
    //1. Thuộc tính
    private double marketing, sales;
    
    //ghi đè phương thức getDiem
    @Override
    public double getDiem() {
        return (2*marketing+sales)/3;// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    //getter and setter

    public double getMarketing() {
        return marketing;
    }

    public void setMarketing(double marketing) {
        this.marketing = marketing;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    
    //Bài 4
    @Override
    public void setNhap() {
        super.setNhap();
        System.out.print("Nhập điểm marketing: ");
        marketing = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập điểm sales: ");
        sales = Double.parseDouble(sc.nextLine());
     // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
