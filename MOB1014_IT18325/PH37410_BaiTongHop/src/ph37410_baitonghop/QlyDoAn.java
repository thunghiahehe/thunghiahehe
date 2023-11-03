/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ph37410_baitonghop;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class QlyDoAn {

    Scanner sc = new Scanner(System.in);
    ArrayList<DoAn> list = new ArrayList<>();

    public void nhapDS() {
        while (true) {
            System.out.print("Nhap ma do an: ");
            String ma = sc.nextLine();
            System.out.print("Nhap ten do an: ");
            String ten = sc.nextLine();
            System.out.print("Nhap so luong: ");
            double sl = sc.nextDouble();
            System.out.print("Nhap don gia: ");
            double gia = sc.nextDouble();
            DoAn da = new DoAn(ma, ten, sl, gia);
            list.add(da);
            sc.nextLine();
            System.out.print("Ban co muon nhap tiep khong?(Y/N): ");
            String nhap = sc.nextLine();
            if (nhap.equalsIgnoreCase("n")) {
                break;
            }
        }

    }

    public void xuatDS() {
        for (DoAn doAn : list) {
            doAn.inThongTin();
        }
    }

    public void timTheoTen() {
        System.out.print("Nhap ten do an ban can tim: ");
        String ten = sc.nextLine();
        for (DoAn doAn : list) {
            if (ten.equalsIgnoreCase(doAn.getTenDoAn())) {
                doAn.inThongTin();
                break;
            }

        }
    }

    public void timTheoMa() {
        System.out.print("Nhap ma do an ban muon tim: ");
        String ma = sc.nextLine();
        for (DoAn da : list) {
            if (ma.equalsIgnoreCase(da.getMaDoAn())) {
                da.inThongTin();
                break;
            }
        }
    }

    public void xoaTheoTen() {
        System.out.print("Nhap ten ban muon xoa: ");
        String ten = sc.nextLine();
        for (DoAn doAn : list) {
            if (ten.equalsIgnoreCase(doAn.getTenDoAn())) {
                list.remove(doAn);
                break;
            }
        }
        System.out.println("Ten do an da duoc xoa!!");
    }

    public void xoaTheoMa() {
        System.out.print("Nhap ma ban can xoa: ");
        String ma = sc.nextLine();
        for (DoAn da : list) {
            if (ma.equalsIgnoreCase(da.getMaDoAn())) {
                list.remove(da);
                break;
            }
        }
        System.out.println("Ma do an da duoc xoa!!");
    }

    public void timTheoKhoangSL() {
        System.out.print("Nhap vao khoang bat dau: ");
        int min = sc.nextInt();
        System.out.print("Nhap vao khoang ket thuc: ");
        int max = sc.nextInt();
        for (DoAn doAn : list) {
            if (doAn.getSoLuong() >= min && doAn.getSoLuong() <= max) {
                System.out.printf("Do an trong khoang so luong tu %d - %d la: ", min, max);
                doAn.inThongTin();
            }
        }
    }

    public void timTheoKhoangGia() {
        System.out.print("Nhap khoang bat dau: ");
        int min = sc.nextInt();
        System.out.println("Nhap khoang ket thuc: ");
        int max = sc.nextInt();
        for (DoAn doAn : list) {
            if (doAn.getDonGia() >= min && doAn.getDonGia() <= max) {
                System.out.printf("Do an trong khoang gia tu %d - %d la: ", min, max);
                doAn.inThongTin();
            }
        }
    }

    public void thoat() {
        System.exit(0);
    }
    
    public void keThua(){
        DoAnNhanh dan= new DoAnNhanh(5.9);
        dan.xuat();
    }
}
