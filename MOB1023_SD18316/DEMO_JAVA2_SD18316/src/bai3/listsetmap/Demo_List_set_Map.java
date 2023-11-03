/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai3.listsetmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class Demo_List_set_Map {

    public static void main(String[] args) {
        int a[] = new int[100];
        //mảng trong c;
        //Array: index 0-9;
        //có 10 phần tử kiểu int
        //a[1]=10.5;//sai vì dl kiểu thực
        a[10] = 10;
        System.out.println("Array: " + Arrays.toString(a));
        //array: là mảng tĩnh, số lượng phần tử là cố định
        //nếu khai báo ít sẽ thiếu, nếu khai báo nhiều thì sẽ lãng phí
        //1. demo List: danh sách động ; cần thì cấp phát bộ nhớ
        //a. list không định kiểu = lẩu thập cẩm 
        List list1 = new ArrayList<>();
        list1.add("nghianehh");
        list1.add(19);
        list1.add(false);//giới tính: boolean
        System.out.println("list1 " + list1.toString());
        //b. List có định kiểu
        List<String> list2 = new ArrayList<>();
        //2. demo set: tập hợp, k truy xuất theo chỉ số
        Set<String> set1 = new HashSet<>();
        set1.add("fpt");
        set1.add("fpt");
        set1.add("fpt");
        System.out.println("set1: " + set1.toString());
        list2.add("fpt");
        list2.add("fpt");
        list2.add("fpt");
        System.out.println("list2: " + list2.toString());
        set1.addAll(list2);
        System.out.println("set1 moi: " + set1.toString());
        list2.addAll(set1);
        System.out.println("list2 moi: " + list2.toString());
        //3. demo Map: Entry<key,value>;
        //Khóa, giá trị: key luôn khác nhau, value có thể giống nhau

    }
}
