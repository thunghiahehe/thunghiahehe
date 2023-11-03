/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai6.dangki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class Dangki_Service implements Dangki_Interface {

    private List<DangKi> listDK = new ArrayList<>();

    public Dangki_Service() {
        listDK.add(new DangKi("PH123", "Học lại", "Nam"));
        listDK.add(new DangKi("PH546", "Học đi", "Nam"));
        listDK.add(new DangKi("PH980", "Học đi", "Nữ"));
        listDK.add(new DangKi("PH132", "Học lại", "Nam"));
    }

    @Override
    public List<DangKi> getAll() {
        return listDK;
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String add(DangKi dk) {
        if (dk != null) {
            listDK.add(dk);
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String update(int index, DangKi dk) {
        if (dk != null&&index>=0) {
            listDK.set(index, dk);
            return "Update thành công";
        } else {
            return "Update thất bại";
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String delete(int index) {
        if (index>=0) {
            listDK.remove(index);
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void sxMa(List<DangKi> list) {
       Comparator<DangKi> comp = new Comparator<DangKi>() {
           @Override
           public int compare(DangKi o1, DangKi o2) {
               return o1.getMaSV().compareTo(o2.getMaSV());
//               throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
           }
       };
        Collections.sort(list, comp);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
