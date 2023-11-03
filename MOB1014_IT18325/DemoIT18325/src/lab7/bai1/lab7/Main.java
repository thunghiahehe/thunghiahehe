/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai1.lab7;

/**
 *
 * @author nthha
 */
public class Main {
    public static void main(String[] args) {
        ChuNhat cn1 = new ChuNhat(3, 4);
        ChuNhat cn2 = new ChuNhat(5, 6);
        ChuNhat vuo = new Vuong(3);
        
        cn1.xuat();
        cn2.xuat();
        vuo.xuat();
        
    }
}
