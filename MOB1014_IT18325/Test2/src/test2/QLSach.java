/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class QLSach {

    Scanner sc = new Scanner(System.in);
    ArrayList<Sach> list = new ArrayList<>();

    public void nhapDS() {
        do {
            Sach s = new Sach();
            s.nhap();
            list.add(s);
            System.out.println("ban co muon nhap tiep khong?(Y/N): ");
            if (sc.nextLine().equalsIgnoreCase("n")) {
                break;
            }
        } while (true);
    }

    public void xuatDS() {
        for (Sach sach : list) {
            sach.xuatTTSach();
        }
    }

    public void xoa1DoiTuong() {
        System.out.print("Nhap ten sach ban muon xoa: ");
        String ten = sc.nextLine();
        for (Sach sach : list) {
            if (ten.equalsIgnoreCase(sach.getTenSach())) {
                list.remove(sach);
                break;
            }
        }
        xuatDS();
    }

    public void timTheoKhoangNam() {
        System.out.print("Nhap khoang nam bat dau: ");
        int min = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap khoang nam ket thuc: ");
        int max = Integer.parseInt(sc.nextLine());
        if (max < min) {
            int hvi = max;
            max = min;
            min = hvi;
        }
        for (Sach sach : list) {
            if (sach.getNamSX() >= min && sach.getNamSX() <= max) {
                sach.xuatTTSach();
            }
        }
    }

    public void keThua() {
        Sach s1 = new SachToan(10000.0, "Giai Tich", "GDVN", 2009);
        list.add(s1);
        s1.xuatTTSach();
    }

    public void thoat() {
        System.exit(0);
    }
}
