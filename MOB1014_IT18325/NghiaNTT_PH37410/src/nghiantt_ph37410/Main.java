/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nghiantt_ph37410;

import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QLNV qly = new QLNV();
        do {
            System.out.println("+--------------------------------- MENU ---------------------------------+");
            System.out.println("\t1. Khoi tao");
            System.out.println("\t2. Nhap danh sach nhan vien");
            System.out.println("\t3. Xuat danh sach nhan vien");
            System.out.println("\t4. Xuat DS cac NV co luong>500");
            System.out.println("\t5. Xuat DS cac NV theo khoang luong nhap tu ban phim");
            System.out.println("\t6. Tim NV theo ma nhap tu ban phim");
            System.out.println("\t7. Xuat cac NV co tuoi tu 18 den 30");
            System.out.println("\t8. Dem so NV co tuoi >18");
            System.out.println("\t9. Sap DS cac NV theo tenNV giam dan");
            System.out.println("\t10. Sap DS cac NV theo luong giam dan");
            System.out.println("\t11. Sap DS cac NV theo tuoi tang dan");
            System.out.println("\t12. Tim theo MaNV");
            System.out.println("\t13. Tim theo TenNV");
            System.out.println("\t14. Xuat DS cac NV theo TrangThai");
            System.out.println("\t15. Xoa doi tuong theo MaNV");
            System.out.println("\t16. Xuat DSNV co tuoi chan");
            System.out.println("\t17. Xuat DSNV co tuoi le");
            System.out.println("\t18. Xuat DSNV co ten bat dau voi tu hoac chu cai");
            System.out.println("\t0. Thoat");
            System.out.println("+------------------------------------------------------------------------+");
            System.out.print("Chon chuc nang: ");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    qly.khoiTao();
                    break;
                case 2:
                    qly.nhapDS();
                    break;
                case 3:
                    qly.xuatDS();
                    break;
                case 4:
                    qly.xuatLuongTren500();
                    break;
                case 5:
                    qly.xuatLuongTheoKhoang();
                    break;
                case 6:
                    qly.timTheoMa();
                    break;
                case 7:
                    qly.xuatTuoiTu18den30();
                    break;
                case 8:
                    qly.demNVienTuoiTren18();
                    break;
                case 9:
                    qly.sxGiamDanTheoTen();
                    break;
                case 10:
                    qly.sxGiamDanTheoLuong();
                    break;
                case 11:
                    qly.sxTangDanTheoTuoi();
                    break;
                case 12:
                    qly.timTheoMaNV();
                    break;
                case 13:
                    qly.timTheoTenNV();
                    break;
                case 14:
                    qly.xuatTheoTrangThai();
                    break;
                case 15:
                    qly.xoaTheoMa();
                    break;
                case 16:
                    qly.xuatNVienTuoiChan();
                    break;
                case 17:
                    qly.xuatNVienTuoiLe();
                    break;
                case 18:
                    qly.xuatTenBatDau();
                    break;
                case 0:
                    qly.thoat();
                    break;
                default:
                    System.out.println("Vui long chon lai chuc nang!!!");
            }

        } while (true);
    }
}
