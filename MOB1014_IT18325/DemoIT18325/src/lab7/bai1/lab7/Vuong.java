/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai1.lab7;

/**
 *
 * @author nthha
 */
public class Vuong extends ChuNhat{
    //1. Hàm tạo 1 tham số
    public Vuong(double rong) {
        //gọi đến hàm tạo 2 tham số của lớp cha
        super(rong,rong);
    }
   
    //2. Ghi đè phương thức xuất
    @Override
    public void xuat() {
        System.out.println("canh = "+getRong());
        System.out.println("CV= "+getChuVi());// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        System.out.println("DT= "+getDienTich());// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
