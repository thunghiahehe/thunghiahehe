/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoiso11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SinhVien> dsSinhVien = new ArrayList<>();
        do {
            SinhVien sv = new SinhVien();
            sv.nhap();
            dsSinhVien.add(sv);
            System.out.print("Ban nhap tiep khong?(Y/N): ");
            if (sc.nextLine().equalsIgnoreCase("n")) {
                break;
            }
        } while (true);
        
        System.out.println("\nIn ra thong tin Sinh vien");
        for (SinhVien sv : dsSinhVien) {
            sv.xuat();
        }

        //Sắp xếp tăng đàn theo họ tên
        Comparator<SinhVien> comp = new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                return o1.hoTen.compareTo(o2.hoTen);
            }
        };

        dsSinhVien.sort(comp);
        System.out.println("\nSap xep tang dan theo ho ten");
        for (SinhVien sv : dsSinhVien) {
            sv.xuat();
        }
        //Sắp xếp tăng dần theo điểm
        Comparator<SinhVien> compDiem = new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                if (o1.diem < o2.diem) {
                    return -1;
                } else if (o1.diem > o2.diem) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        dsSinhVien.sort(compDiem);
        System.out.println("\nSap xep tang dan theo diem");
        for (SinhVien sv : dsSinhVien) {
            sv.xuat();
        }
    }
}
