/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class QuanLyNhanVien {

    Scanner sc = new Scanner(System.in);
    ArrayList<NhanVien> list = new ArrayList<>();

    public void nhapDS() {
        int i = 0, loai;
        String maNV, hoTen;
        double luong, doanhSo, hoaHong, trachNhiem;
        do {

            System.out.println("Loai nhan vien ban muon nhap (1.Hanh chinh/2.Tiep Thi/3.Truong Phong): ");
            loai = sc.nextInt();
            System.out.printf("Nhan vien thu %d: \n", (i + 1));
            sc.nextLine();
            System.out.print("Ma NV: ");
            maNV = sc.nextLine();
            System.out.print("Ho ten NV: ");
            hoTen = sc.nextLine();
            System.out.print("Luong: ");
            luong = Double.parseDouble(sc.nextLine());
            if (loai == 1) {
                NhanVien nv = new NhanVien(maNV, hoTen, luong) {
                    @Override
                    double getThuNhap() {
                        return luong;
                    }
                };
                list.add(nv);
            }
            if (loai == 2) {
                System.out.print("Doanh so: ");
                doanhSo = Double.parseDouble(sc.nextLine());
                System.out.print("Hoa hong: ");
                hoaHong = Double.parseDouble(sc.nextLine());
                NhanVien nv = new TiepThi(maNV, hoTen, luong, doanhSo, hoaHong);
                list.add(nv);
            }
            if (loai == 3) {
                System.out.print("Trach Nhiem: ");
                trachNhiem = Double.parseDouble(sc.nextLine());
                NhanVien nv = new TruongPhong(maNV, hoTen, luong, trachNhiem);
                list.add(nv);
            }
            ++i;
            System.out.print("Ban co muon nhap tiep khong?(Y/N): ");
            
            if (sc.nextLine().equalsIgnoreCase("n")) {
                break;
            }
        } while (true);

    }

    public void xuatDS() {
        for (NhanVien nv : list) {
            System.out.printf("Ma nv: %s | Hoten: %s | Luong: %.2f\n", nv.getMaNV(), nv.getHoTen(), nv.getThuNhap());
        }
    }

    public void timTheoMa() {
        System.out.print("Nhap ma nhan vien ban can tim: ");
        String ma = sc.nextLine();
        boolean check = false;
        for (NhanVien nv : list) {
            if (ma.equalsIgnoreCase(nv.getMaNV())) {
                System.out.printf("Ma nv: %s | Hoten: %s | Luong: %.2f\n", nv.getMaNV(), nv.getHoTen(), nv.getThuNhap());
                check = true;
                break;
            }
        }
        if (check == false) {
            System.out.println("Nhan vien khong ton tai!!");
        }
    }

    public void xoaTheoMa() {
        System.out.print("Nhap ma nhan vien can xoa: ");
        String ma = sc.nextLine();
        boolean check = false;
        for (NhanVien nv : list) {
            if (ma.equalsIgnoreCase(nv.getMaNV())) {
                list.remove(nv);
                check = true;
                break;
            }
        }
        if (check == false) {
            System.out.println("Nhan vien khong ton tai!!!");
        } else {
            System.out.println("Nhan vien da duoc xoa!!!");
        }

    }

    public void capNhatTheoMa() {

    }

    public void timNVienTheoKhoang() {
//        System.out.print("Nhap luong min: ");
//        double min = Double.parseDouble(sc.nextLine());
//        System.out.print("Nhap luong max: ");
//        double max = Double.parseDouble(sc.nextLine());
//        if (max < min) {
//            double hvi = max;
//            max = min;
//            min = hvi;
//        }
//        for (NhanVien nhanVien : list) {
//            if (nhanVien.getThuNhap() >= min && nhanVien.getThuNhap() <= max) {
//                xuatDS();
//            }
//        }
    }

    public void sxTheoHoTen() {
        Comparator<NhanVien> comp = new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien nv1, NhanVien nv2) {
                return nv1.getHoTen().compareTo(nv2.getHoTen());
            }
        };
        Collections.sort(list, comp);
        xuatDS();
    }

    public void sxTheoThuNhap() {
        Comparator<NhanVien> comp = new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien nv1, NhanVien nv2) {
                if (nv1.getThuNhap() > nv2.getThuNhap()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };
        Collections.sort(list, comp);
        xuatDS();
    }

    public void xuatNVienTNhapMax() {
        Collections.sort(list, (a, b) -> (int) (b.getThuNhap() - a.getThuNhap()));
        for (int i = 0; i < 5; i++) {
            System.out.printf("Ma nv: %s | Hoten: %s | Luong: %.2f\n", list.get(i).getMaNV(), list.get(i).getHoTen(), list.get(i).getThuNhap());
        }
    }

    public void thoat() {
        System.exit(0);
    }
}
