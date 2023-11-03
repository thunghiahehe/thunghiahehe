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
public class SinhVienIT extends SinhVienPoly{
    Scanner sc = new Scanner(System.in); //bài 4
    
    //1. Thuộc tính
    private double java, html, css;
        
    //ghi đè phương thức getDiem
    @Override
    public double getDiem() {
        return (2*java+html+css)/4;// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    //getter and setter
    public double getJava() {
        return java;
    }

    public void setJava(double java) {
        this.java = java;
    }

    public double getHtml() {
        return html;
    }

    public void setHtml(double html) {
        this.html = html;
    }

    public double getCss() {
        return css;
    }

    public void setCss(double css) {
        this.css = css;
    }

    //Bài 4
    @Override
    public void setNhap() {
        super.setNhap();
        System.out.print("Nhập điểm java: ");
        java = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập điểm html: ");
        html = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập điểm css: ");
        css = Double.parseDouble(sc.nextLine());
    // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
