/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoiso02;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class demo {
    public static void main(String[] args) {
        int a=5;
        Integer n=6;
        
        Integer b=a; //bao(boxing) ngầm định
        Integer c = Integer.valueOf(a); //bao tường minh
        
        int m=n; //mở bao(unboxing) ngầm định
        int k = n.intValue(); //mở bao tường minh
        
        String chuoi1 = "12.5";
        String chuoi2 = "4";
            System.out.println("chuoi1 + chuoi2 = "+chuoi1+chuoi2);
        double i = Double.parseDouble(chuoi1);
        double j = Double.parseDouble(chuoi2);
        int l = Integer.parseInt(chuoi2);
        System.out.println("chuoi1 + chuoi2 = "+(i+j));
    }
}
