/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Buoi6;

import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class Lab3Bai4 {

    public static void main(String[] args) {
        //Khai báo biến
        Scanner sc = new Scanner(System.in);

        String[] hoTen;
        Double[] diemTB;
        int n;

        //nhap so phan tư mang
        System.out.print("Nhap so luong sinh vien: ");
        //Cách 2 để nhập giá trị số:n = Integer.parseInt(sc.nextLine());
        n = sc.nextInt();
        sc.nextLine();
        hoTen = new String[n];
        diemTB = new Double[n];

        //nhập tên và điểm sv
        for (int i = 0; i < n; i++) {
            System.out.printf("Nhap ten sv thu %d: ", (i + 1));
            hoTen[i] = sc.nextLine();
            System.out.print("Nhap diem cua sinh vien thu " + (i + 1) + ": ");
            diemTB[i] = Double.parseDouble(sc.nextLine());
        }

        //In ra thông tin <họ tên><điểm><học lực>
//        for (i = 0; i < n; i++) {
//            System.out.print(hoTen[i] + " - " + diemTB[i] + " - ");
//            if (diemTB[i] >= 0 && diemTB[i] <= 10) {
//                if (diemTB[i] < 5) {
//                    System.out.println("Yeu");
//                } else if (diemTB[i] < 6.5) {
//                    System.out.println("Trung binh");
//                } else if (diemTB[i] < 7.5) {
//                    System.out.println("Kha");
//                } else if (diemTB[i] < 9) {
//                    System.out.println("Gioi");
//                } else {
//                    System.out.println("XS");
//                }
//            } else {
//                System.out.println("Khong hop le");
//            }
//
//        }
        for (int i = 0; i < n; i++) {
            System.out.print(hoTen[i] + " - " + diemTB[i] + " - ");
            String danhGia = hocLuc(diemTB[i]);
            System.out.println("Ten: " + hoTen[i] + " - " + "Danh gia: " + danhGia);
        }
        //Sắp xếp tăng dần theo điểm
        for (int i = 0; i < diemTB.length; i++) {
            for (int j = i + 1; j < diemTB.length; j++) {
                if (diemTB[i] > diemTB[j]) {
                    double hViDiem = diemTB[i];
                    diemTB[i] = diemTB[j];
                    diemTB[j] = hViDiem;

                    String hViTen = hoTen[i];
                    hoTen[i] = hoTen[j];
                    hoTen[j] = hViTen;
                }
            }
        }

        for (int i = 0; i < hoTen.length; i++) {
            System.out.println("Sv thu " + (i + 1) + " - " + "Ho ten: " + hoTen[i] + " - " + "Diem: " + diemTB[i]);
        }
        //Sắp xếp giảm dần theo điểm
        for (int i = 0; i < diemTB.length; i++) {
            for (int j = i + 1; j < diemTB.length; j++) {
                if (diemTB[i] < diemTB[j]) {
                    double hViDiem = diemTB[i];
                    diemTB[i] = diemTB[j];
                    diemTB[j] = hViDiem;

                    String hViTen = hoTen[i];
                    hoTen[i] = hoTen[j];
                    hoTen[j] = hViTen;
                }
            }
        }

        for (int i = 0; i < hoTen.length; i++) {
            System.out.println("Sv thu " + (i + 1) + " - " + "Ho ten: " + hoTen[i] + " - " + "Diem: " + diemTB[i]);
        }

    }

    static String hocLuc(Double diem) {

        String hocLuc = "";
        if (diem >= 0 && diem <= 10) {
            if (diem < 5) {
                hocLuc = "Yeu";
            } else if (diem < 6.5) {
                hocLuc = "Trung binh";
            } else if (diem < 7.5) {
                hocLuc = "Kha";
            } else if (diem < 9) {
                hocLuc = "Gioi";
            } else {
                hocLuc = "XS";
            }
        } else {
            hocLuc = "Khong hop le";
        }
        return hocLuc;
    }

}

/*YÊU CẦU VỀ NHÀ NÂNG CẤP CHƯƠNG TRÌNH NHƯ SAU:
1. Tạo phương thức in ra học lực
2. Viết thêm chương trình: sau khi sắp xếp tăng
dần thì in lại thông tin sinh viên như sau:
<họ tên>-<điểm>-<học lực>
3. Thực hiện sắp xếp giảm dần theo điểm và in ra
thông tin sinh viên sau sắp xếp như yêu cầu 3
 */
