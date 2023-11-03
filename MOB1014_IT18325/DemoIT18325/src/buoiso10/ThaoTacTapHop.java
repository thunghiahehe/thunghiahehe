/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoiso10;

import java.util.ArrayList;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class ThaoTacTapHop {
    public static void main(String[] args) {
        ArrayList<Integer> ds1= new ArrayList<>();
        ArrayList<Integer> ds2= new ArrayList<>();
        
        ds1.add(3);
        ds1.add(5);
        ds1.add(1);
        //
        ds2.add(2);
        ds2.add(1);
        ds2.add(4);
        
//        ds2.addAll(ds1);
//        ds2.removeAll(ds1);
        ds2.retainAll(ds1);
        System.out.println("Ton tai cua ds2 vs ds1: "+ds1.containsAll(ds2));
        
        System.out.println("\nDanh sach 1");
        for (Integer i : ds1) {
            System.out.print(i+"\t");
        }
        System.out.println();
        
        System.out.println("Danh sach 2");
        for (Integer i : ds2) {
            System.out.print(i+"\t");
        }
        
        
        
    }
}
