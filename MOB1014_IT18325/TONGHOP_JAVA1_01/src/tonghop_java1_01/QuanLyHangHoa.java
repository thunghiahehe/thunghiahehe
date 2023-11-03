/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tonghop_java1_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class QuanLyHangHoa {

    //Khởi tạo danh sách hàng hóa
    //Viết các phương thức thực hiện chức năng
    Scanner sc = new Scanner(System.in);
    ArrayList<HangHoa> dsHangHoa = new ArrayList<>();

    public void nhapTT() {
        System.out.println("\t1. Nhap danh sach hang");
        do {
            HangHoa hangHoa = new HangHoa();
            hangHoa.nhap();
            dsHangHoa.add(hangHoa);
            System.out.print("Ban co muon nhap tiep khong? (Y/N): ");
            if (sc.nextLine().equalsIgnoreCase("n")) {
                break;
            }
        } while (true);
    }

    public void xuatDS() {
        System.out.println("\t2. Xuat danh sach");
        for (HangHoa hangHoa : dsHangHoa) {
            hangHoa.xuat();
        }
    }

    public void capNhatTheoMa() {
        System.out.println("\t3. Cap nhat lai thong tin hang theo ma nhap tu ban phim");
        String ma;
        System.out.print("Nhap ma don hang can tim: ");
        ma = sc.nextLine();
        for (HangHoa hang : dsHangHoa) {
            if (hang.getMaHang().equalsIgnoreCase(ma)) {
                hang.nhap();
            }
        }
    }

    public void timTheoTen() {
        System.out.println("\t4. Tim Hang theo ten hang nhap vao");
        String ten;
        System.out.print("Nhap ten don hang can tim: ");
        ten = sc.nextLine();
        for (HangHoa hh : dsHangHoa) {
            if (ten.equalsIgnoreCase(hh.getTenHang())) {
                hh.xuat();
            }
        }
    }

    public void sapXepGiamDan() {
        //Xem lại bài sắp xếp buổi 11, sắp xếp giảm dần theo chuỗi
        //Ở bài này là sắp xếp giảm dần theo tên

        //1. Ghi đè phương thức compare 
        Comparator<HangHoa> comp = new Comparator<HangHoa>() {
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                return o1.getTenHang().compareTo(o2.getTenHang());
                // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };

        //2. Sắp xếp giảm dần theo comp
        Collections.sort(dsHangHoa, comp);
        //3. Đảo lại danh sách sau sắp xếp giảm dần => sắp xếp tăng dần
        Collections.reverse(dsHangHoa);

    }

    public void xoaTheoMa() {
        //1. Khai báo 1 biến dùng để nhập mã
        String ma;
        //2. Nhập vào mã cần tìm
        System.out.print("Nhap ma can xoa: ");
        ma = sc.nextLine();
        //3. Duyệt danh sách->tìm hàng có mã t/u với mã vừa nhập
        //-> tìm đc thì xóa hàng hóa đó (remove) (buổi số 10)
        for (int i = 0; i < dsHangHoa.size(); i++) {
            if (dsHangHoa.get(i).getTenHang().equalsIgnoreCase(ma)) {
                dsHangHoa.remove(i);
            }
        }
    }

    //TÌM GIÁ MAX CÁCH 1
    public void timHangGiaMax() {
        //1. Khao báo 1 biến max = giá của hàng hóa thứ 0
        double max = dsHangHoa.get(0).getDonGia();
        System.out.println("max");
        //2. Duyệt danh sách. 
        int index = 0;
        //3. Tìm hàng hóa có đơn giá max và chỉ số của hàng hóa đó
        for (int i = 1; i < dsHangHoa.size(); i++) {
            if (max < dsHangHoa.get(i).getDonGia()) {
                index = i;
                max = dsHangHoa.get(i).getDonGia();
            }
        }
        //4. In ra thông tin hàng hóa có đơn giá max
        dsHangHoa.get(index).xuat();
    }

    /* TÌM GIÁ MAX CÁCH 2
    public void timHangGiaMax() {
        //1. Ghi đè phương thức compare 
        Comparator<HangHoa> comp = new Comparator<HangHoa>() {
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getDonGia()<o2.getDonGia())return -1;
                else if(o1.getDonGia()>o2.getDonGia())return 1;
                else return 0;
                // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        
        //2. Sắp xếp theo comp
        Collections.sort(dsHangHoa, comp);
        
        //3. Hàng hóa có giá cao nhất trong danh sách là hàng hóa ở vị trí (index) cuối)
        dsHangHoa.get(0).xuat();
        
    }*/
    public void timTheoKhoang() {
        //1. Khai báo 2 biến dùng để nhập số lượng max,min
        double max;
        double min;
        //2. Nhập vào số lượng max, min
        System.out.print("Gia max: ");
        max = Double.parseDouble(sc.nextLine());
        System.out.print("Gia min: ");
        min = Double.parseDouble(sc.nextLine());
        //3. Thực hiện hoán vị nếu max<min
        if (max < min) {
            double hvi = max;
            max = min;
            min = hvi;
        }
        //4. Duyệt danh sách->tìm hàng có số lượng trong khoảng vừa nhập
        for (HangHoa hang : dsHangHoa) {
            //-> tìm đc thì in ra
            if (hang.getSoLuong() <= max && hang.getSoLuong() >= min) {
                hang.xuat();
            }
        }

    }

    public void thoat() {
        System.exit(0);
    }

    public void keThua() {
        HangHoa hangXK = new HangXuatKhau("VN", "LI122", "zit zang", 0, 0);
        dsHangHoa.add(hangXK);
        hangXK.xuat();
    }
}
