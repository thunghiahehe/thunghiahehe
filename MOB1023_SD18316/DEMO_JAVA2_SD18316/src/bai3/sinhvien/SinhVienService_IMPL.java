/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai3.sinhvien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class SinhVienService_IMPL implements SinhVien_Service {

    private List<SinhVien> listSV = new ArrayList<>();//Danh sách quản lí toàn bộ Sinh viên

    public SinhVienService_IMPL() {
        listSV.add(new SinhVien("Nghia1", 9, "PTPM"));
        listSV.add(new SinhVien("Nghia2", 8, "CNTT"));
        listSV.add(new SinhVien("Nghia3", 7, "WEB"));
        listSV.add(new SinhVien("Nghia4", 8.5, "UDPM"));
    }

    @Override
    public List<SinhVien> getAll() {
        return listSV;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String addSV(SinhVien sv) {
        if (sv != null) {
            listSV.add(sv);
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String removeSV(int index) {
        if (index >= 0) {
            listSV.remove(index);
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String updateSV(int index, SinhVien sv) {
        if (index >= 0 && sv != null) {
            listSV.set(index, sv);
            return "Update thành công";
        } else {
            return "Update thất bại";
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void sapXepTen(List<SinhVien> list) {
        Comparator<SinhVien> comp = new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien sv1, SinhVien sv2) {
                return sv1.getTen().compareTo(sv2.getTen());
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        Collections.sort(list, comp);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void sapXepDiem(List<SinhVien> listDiem) {
        Comparator<SinhVien> comp2 = new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien sv1, SinhVien sv2) {
                if (sv1.getDiem() > sv2.getDiem()) {
                    return 1;
                } else if (sv1.getDiem() == sv2.getDiem()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        };
        Collections.sort(listSV, comp2);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SinhVien> findTen(String ten) {
        List<SinhVien> listTim = new ArrayList<>();
        for (SinhVien sv : listSV) {
            if (sv.getTen().contains(ten)) {
                listTim.add(sv);//thêm vào list mới
            }
        }
        return listTim;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
