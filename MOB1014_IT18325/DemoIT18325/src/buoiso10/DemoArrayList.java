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
public class DemoArrayList {

    public static void main(String[] args) {
        //Khởi tạo danh sách không định kiểu
        ArrayList ds1 = new ArrayList();
        ds1.add("abc");
        ds1.add(1);
        ds1.add(3.4);
        //Khởi tạo danh sách không định kiểu
        ArrayList<Integer> ds2 = new ArrayList<>();
        ds2.add(1);
        ds2.add(3);
        ds2.add(4);
        ds2.add(5);
        //
        ds2.add(1, 2);
        ds2.set(0, 10);
        for (Integer i : ds2) {
            System.out.print(i + "\t");
        }
        System.out.println("\n");
        
        //
        ds2.remove(2);
        for (Integer i : ds2) {
            System.out.print(i + "\t");
        }
        System.out.println("\n");
        
        //
        ds2.remove(Integer.valueOf(5));
        for (Integer i : ds2) {
            System.out.print(i + "\t");
        }
        System.out.println("\n");
        //
        System.out.println("In phan tu tai vi tri so 1: " + ds2.get(1));
        System.out.println("So phan tu co trong danh sach: "+ds2.size());
        System.out.println("SO 25 co trong danh sach khong? "+ds2.contains(25));
        System.out.println("ds2 co rong khong?  "+ds2.isEmpty());
        System.out.println("Vi tri cua 2: "+ds2.indexOf(2));
    }
}
