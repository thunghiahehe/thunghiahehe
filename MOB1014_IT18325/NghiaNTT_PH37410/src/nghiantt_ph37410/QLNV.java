/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nghiantt_ph37410;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class QLNV {

    Scanner sc = new Scanner(System.in);
    ArrayList<NhanVien> list = new ArrayList<>();

    public void khoiTao() {
        NhanVien nv = new NhanVien();
        NhanVien nv1 = new NhanVien("LI123", "Nguyen Van A", 2000, 1996);
        NhanVien nv2 = new NhanVien("NG035", "Tran Mua Thu", 2700, 1997);
        NhanVien nv3 = new NhanVien("AN989", "May Van May", 1500, 2000);
        NhanVien nv4 = new NhanVien("PT732", "Ngu Thi Ngo", 3500, 1989);
        NhanVien nv5 = new NhanVien("LA278", "To Van Teo", 1200, 2001);
        list.add(nv1);
        list.add(nv2);
        list.add(nv3);
        list.add(nv4);
        list.add(nv5);
        xuatDS();
    }

    public void nhapDS() {

        do {
            NhanVien nv = new NhanVien();
            nv.nhap();
            list.add(nv);
            System.out.print("Ban co muon nhap tiep khong?(Y/N): ");
            if (sc.nextLine().equalsIgnoreCase("n")) {
                break;
            }
        } while (true);
    }

    public void xuatDS() {
        for (NhanVien nv : list) {
            nv.inThongTin();
        }
    }

    public void xuatLuongTren500() {

    }

    public void xuatLuongTheoKhoang() {

    }

    public void timTheoMa() {
        System.out.print("Nhap ma ban can tim: ");
        String ma = sc.nextLine();
        for (NhanVien nv : list) {
            if (ma.equalsIgnoreCase(nv.getMaNV())) {
                nv.inThongTin();
                break;
            }
        }
    }

    public void xuatTuoiTu18den30() {

    }

    public void demNVienTuoiTren18() {

    }

    public void sxGiamDanTheoTen() {
        Comparator<NhanVien> comp = new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien nv1, NhanVien nv2) {
                return nv1.getTenNV().compareTo(nv2.getTenNV());
            }
        };
        Collections.sort(list, comp);
        Collections.reverse(list);
    }

    public void sxGiamDanTheoLuong() {

    }

    public void sxTangDanTheoTuoi() {

    }

    public void timTheoMaNV() {
        System.out.println("Nhap ma NV can tim: ");
        String ma = sc.nextLine();
        for (NhanVien nv : list) {
            if (ma.equalsIgnoreCase(nv.getMaNV())) {
                nv.inThongTin();
                break;
            }
        }
    }

    public void timTheoTenNV() {
        System.out.print("Nhap ten NV ban can tim: ");
        String ten = sc.nextLine();
        for (NhanVien nv : list) {
            if (ten.equalsIgnoreCase(nv.getTenNV())) {
                nv.inThongTin();
                break;
            }
        }
    }

    public void xuatTheoTrangThai() {
        
    }

    public void xoaTheoMa() {
        System.out.print("Nhap ma ban muon xoa: ");
        String ma = sc.nextLine();
        for (NhanVien nv : list) {
            if (ma.equalsIgnoreCase(nv.getMaNV())) {
                list.remove(nv);
                break;
            }
        }
        xuatDS();
    }

    public void xuatNVienTuoiChan() {

    }

    public void xuatNVienTuoiLe() {

    }

    public void xuatTenBatDau() {

    }

    public void thoat() {
        System.exit(0);
    }
}
