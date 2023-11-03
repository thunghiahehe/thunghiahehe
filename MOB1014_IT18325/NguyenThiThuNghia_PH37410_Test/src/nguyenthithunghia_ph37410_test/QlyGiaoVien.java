/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nguyenthithunghia_ph37410_test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class QlyGiaoVien {

    Scanner sc = new Scanner(System.in);
    ArrayList<GiaoVien> list = new ArrayList<>();

    public void nhapDS() {
        do {
            GiaoVien gv = new GiaoVien();
            gv.nhap();
            list.add(gv);
            System.out.print("Ban co muon nhap tiep khong?(Y/N): ");
            if (sc.nextLine().equalsIgnoreCase("n")) {
                break;
            }
        } while (true);
    }

    public void xuatDS() {
        for (GiaoVien gv : list) {
            gv.xuat();
        }
    }

    public void xuatTheoKhoangTuoi() {
        System.out.print("Nhap khoang tuoi bat dau: ");
        double min = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap khoang tuoi ket thuc: ");
        double max = Double.parseDouble(sc.nextLine());
        if (max < min) {
            double hvi = max;
            max = min;
            min = hvi;
        }
        for (GiaoVien gv : list) {
            if (gv.getTuoi() >= min && gv.getTuoi() <= max) {
                gv.xuat();
            }
        }
    }

    public void timTheoHoTen() {
        System.out.print("Nhap ho ten ban can tim: ");
        String ten = sc.nextLine();
        for (GiaoVien gv : list) {
            if (ten.equalsIgnoreCase(gv.getHoTen())) {
                gv.xuat();
            }
        }
    }

    public void sxTheoHotenGiamDan() {
        Comparator<GiaoVien> comp = new Comparator<GiaoVien>() {
            @Override
            public int compare(GiaoVien gv1, GiaoVien gv2) {
                return gv1.getHoTen().compareTo(gv2.getHoTen());
            }
        };
        Collections.sort(list, comp);
        Collections.reverse(list);
        xuatDS();
    }

    public void xoaTheoHoTen() {
        System.out.print("Nhap ho ten ban muon xoa: ");
        String ten = sc.nextLine();
        for (GiaoVien gv : list) {
            if (ten.equalsIgnoreCase(gv.getHoTen())) {
                list.remove(gv);
                break;
            }
        }
        System.out.println("Giao vien da duoc xoa!!!");
        xuatDS();
    }

    public void thoat() {
        System.exit(0);
    }

    public void keThua() {
        GiaoVien gv1 = new GiaoVienCoHuu(4, "Nguyen Van A", 25, 2500);
        list.add(gv1);
        gv1.xuat();
    }

}
