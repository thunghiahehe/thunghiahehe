/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baikt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class QlyHoaQua {

    Scanner sc = new Scanner(System.in);
    ArrayList<HoaQua> list = new ArrayList<>();

    public void nhapDS() {
        do {            
           HoaQua hq=new HoaQua();
           hq.nhap();
           list.add(hq);
            System.out.print("Ban co muon nhap tiep khong?(Y/N): ");
            if (sc.nextLine().equalsIgnoreCase("n")) {
                break;
            }
        } while (true);
    }

    public void xuatDS() {
        for (HoaQua hoaQua : list) {
            hoaQua.xuat();
        }
    }

    public void sxNGTangDan() {
        Comparator<HoaQua> comp = new Comparator<HoaQua>() {
            @Override
            public int compare(HoaQua o1, HoaQua o2) {
                return o1.getNguonGoc().compareTo(o2.getNguonGoc());
            }
        };
        Collections.sort(list,comp);
    }

    public void xoatheoMa() {

        System.out.println("Nhap ma can xoa: ");
        String ma = sc.nextLine();
        for (HoaQua hq : list) {
            if (ma.equalsIgnoreCase(hq.getMa())) {
                list.remove(hq);
                break;
            }
        }
    }

    public void thoat() {
        System.exit(0);
    }

}
