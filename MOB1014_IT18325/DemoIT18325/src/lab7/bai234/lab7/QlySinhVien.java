/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai234.lab7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author nthha
 */
//BÀI 4
public class QlySinhVien {

    Scanner sc = new Scanner(System.in);
    //1. Khởi tạo danh sách sinh viên
    ArrayList<SinhVienPoly> dsSinhVien = new ArrayList<>();

    //2. Nhập danh sách sinh viên
    public void nhapDS() {
        //Nhập thông tin sinh viên và add vào danh sách
        do {
            //Khởi tạo 2 đối tượng sv IT va BIZ
            SinhVienPoly svIT = new SinhVienIT();
            SinhVienPoly svBiz = new SinhVienBiz();
            
            //Hỏi xem muốn nhập điểm của sinh viên ngành nào
            System.out.print("Bạn muốn nhập TT sinh viên IT hay BIZ(1-IT; 2-BIZ): ");
            int chon = Integer.parseInt(sc.nextLine());

            //Thực hiện nhập điểm sv và add điểm sv vào ds theo ngành đã chọn
            switch (chon) {
                case 1:
                    svIT.setNhap();
                    dsSinhVien.add(svIT);
                    break;
                case 2:
                    svBiz.setNhap();
                    dsSinhVien.add(svBiz);
                    break;
                default:
                    System.out.println("Bạn cần chọn đúng: (1-IT; 2-BIZ)");
            }

            //Hỏi xem có muốn tiếp tục nhập hay không
            System.out.println("Bạn nhập TT hang hóa tiếp ko(Y/N)? ");
            if (sc.nextLine().equalsIgnoreCase("n")) {
                break;
            }
        } while (true);

    }

    //3. Xuất danh sách sinh viên
    public void xuatDS() {
        for (SinhVienPoly sv : dsSinhVien) {
            sv.xuat();
        }
    }

    //4. Xuất danh sách sinh viên có học lực GIỎI
    public void svGioi() {
        for (SinhVienPoly sv : dsSinhVien) {
            //Kiểm tra nếu học lực của sv = "gioi" thi xuất TT
            if (sv.getHocLuc().equalsIgnoreCase("gioi")) {
                sv.xuat();
            }
        }
    }

    //5. Sắp xếp danh sách sinh viên theo điểm (getDiem)
    public void sapXep() {
        Comparator<SinhVienPoly> comp = new Comparator<SinhVienPoly>() {
            @Override
            public int compare(SinhVienPoly o1, SinhVienPoly o2) {
                if (o1.getDiem() < o2.getDiem()) {
                    return -1;
                } else if (o1.getDiem() > o2.getDiem()) {
                    return 1;
                } else {
                    return 0;
                }
                // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        //sắp xếp danh sách theo comp
        Collections.sort(dsSinhVien, comp);

        //in ra ds sau sắp xếp
        xuatDS();
    }

    public void thoat() {
        System.exit(0);
    }

}
