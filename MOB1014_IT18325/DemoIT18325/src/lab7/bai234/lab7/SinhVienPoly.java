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

//BÀI TẬP 2
abstract public class SinhVienPoly {
    Scanner sc = new Scanner(System.in);
    //1. Thuộc tính
    private String hoTen;
    private String nganh;
    
    //2. phương thức trừu tượng
    abstract public double getDiem();    
    
    //3. phương thức học lực - xuất - nhập
    public String getHocLuc(){
        if(getDiem()<5) return "Yeu";
        else if(getDiem()<6.5) return "Trung binh";
        else if(getDiem()<7.5) return "Kha";
        else if(getDiem()<9) return "Gioi";
        else return "Xuat sac";
    }
    public void xuat(){
        System.out.println("Họ tên: "+hoTen);
        System.out.println("Ngành: "+nganh);
        System.out.println("Điểm: "+getDiem());
        System.out.println("Học lực: "+getHocLuc());
    }
    
    public void setNhap(){
        System.out.print("Nhập họ tên sv: ");
        hoTen = sc.nextLine();
        System.out.print("Nhập ngành: ");
        nganh = sc.nextLine();
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }
            
    
    
}
