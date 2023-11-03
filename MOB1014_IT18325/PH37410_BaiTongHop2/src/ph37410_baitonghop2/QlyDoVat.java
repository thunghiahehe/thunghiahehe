/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ph37410_baitonghop2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class QlyDoVat {

    Scanner sc = new Scanner(System.in);
    ArrayList<DoVat> list = new ArrayList<>();

    public void nhapDS() {

        do {
            DoVat dv = new DoVat();
            dv.nhap();
            list.add(dv);
            System.out.print("Ban co muon nhap tiep khong?(Y/N): ");
            if (sc.nextLine().equalsIgnoreCase("n")) {
                break;
            }
        } while (true);
    }

    public void xuatDS() {
        for (DoVat dv : list) {
            dv.inThongTin();
        }
    }

    public void timTheoChatLieu() {
        System.out.print("Nhap chat lieu can tim: ");
        String cLieu = sc.nextLine();
        for (DoVat dv : list) {
            if (cLieu.equalsIgnoreCase(dv.getChatLieu())) {
                dv.inThongTin();
                break;
            }

        }
    }

    public void xoaTheoTen() {
        System.out.print("Nhap ten ban muon xoa: ");
        String tenDV = sc.nextLine();
        for (DoVat dv : list) {
            if (tenDV.equalsIgnoreCase(dv.getTenDoVat())) {
                list.remove(dv);
                break;
            }
        }
        System.out.println("Ten da duoc xoa!!!");
        xuatDS();
    }

    public void xoaTheoChatLieu() {
        System.out.print("Nhap chat lieu ban muon xoa: ");
        String cl = sc.nextLine();
        for (DoVat dv : list) {
            if (cl.equalsIgnoreCase(dv.getChatLieu())) {
                list.remove(dv);
                break;
            }
        }
        System.out.println("Chat lieu da duoc xoa!!!");
    }

    public void sxTheoMa() {
        Comparator<DoVat> comp = new Comparator<DoVat>() {
            @Override
            public int compare(DoVat dv1, DoVat dv2) {
                return dv1.getMaDoVat().compareTo(dv2.getMaDoVat());
            }
        };
        Collections.sort(list,comp);
        xuatDS();
    }

    public void thoat() {
        System.exit(0);
    }

    public void keThua() {
        DoHoaPhat dv1= new DoHoaPhat(0, "a", "b", "c");
        dv1.inThongTin();
    }

}
