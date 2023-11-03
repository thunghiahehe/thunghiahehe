/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoiso10;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class ThaoTacNangCao {

    public static void main(String[] args) {
        ArrayList<Integer> ds = new ArrayList<>();
        ds.add(9);
        ds.add(4);
        ds.add(8);
        ds.add(1);
        
        System.out.println("Vi tri phan tu co gia tri 8: "+Collections.binarySearch(ds, 8));
        Collections.shuffle(ds);//Hoán vị ngẫu nhiên
        Collections.sort(ds);//Sắp xếp tăng dần
        Collections.reverse(ds);//Đảo ngược danh sách
//      Collections.rotate(ds, 3);//Xoay vòng
        Collections.swap(ds, 1, 3);//Tráo đổi (hoán vị) 2 giá trị nào đó
        Collections.fill(ds, 10);//Thay đổi toàn bộ các giá trị phần tử =10
        for (Integer i : ds) {
            System.out.print(i + "\t");
        }
        
    }
}
