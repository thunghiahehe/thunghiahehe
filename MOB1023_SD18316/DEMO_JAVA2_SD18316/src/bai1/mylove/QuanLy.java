/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai1.mylove;

import bai1.mylove.OldMyLove;
import bai1.mylove.MyLove;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class QuanLy {

    Scanner sc = new Scanner(System.in);
    ArrayList<MyLove> list = new ArrayList<>();

    public void nhapDS() {

        do {
            MyLove ml = new MyLove();
            ml.nhap();
            list.add(ml);
            System.out.print("Ban co muon nhap tiep khong?(Y/N): ");
            if (sc.nextLine().equalsIgnoreCase("N")) {
                break;
            }
        } while (true);
    }

    public void xuatDS() {
        for (MyLove myLove : list) {
            myLove.xuat();
        }
    }

    public void timTheoTen() {
        System.out.print("Nhap ten ban can tim: ");
        String ten = sc.nextLine();
        for (MyLove myLove : list) {
            if (ten.equalsIgnoreCase(myLove.getHoTen())) {
                myLove.xuat();
                break;
            }
        }
    }

    public void xoaTheoTuoi() {
        System.out.print("Nhap tuoi ban can xoa: ");
        int age = Integer.parseInt(sc.nextLine());
        for (MyLove myLove : list) {
            if (myLove.getTuoi() == age) {
                list.remove(myLove);
                break;
            }
        }
    }

    public void sxTheoTen() {
        Comparator<MyLove> comp = new Comparator<MyLove>() {
            @Override
            public int compare(MyLove o1, MyLove o2) {
                return o1.getHoTen().compareTo(o2.getHoTen());
            }
        };
        Collections.sort(list, comp);
        xuatDS();
    }

    public void thoat() {
        System.exit(0);
    }

    public void keThua() {
        OldMyLove m1 = new OldMyLove(2, "Trung", 21);
        list.add(m1);
        m1.xuat();
    }
}
