/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5.dienthoai;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class DienThoai_Service implements DienThoai_Interface {

    private List<DienThoai> list = new ArrayList<>();

    public DienThoai_Service() {
        list.add(new DienThoai("sp1", "Samsung", 25));
        list.add(new DienThoai("sp2", "Apple", 36));
        list.add(new DienThoai("sp3", "Xiaomi", 12));
        list.add(new DienThoai("sp4", "Nokia", 7));
    }

    @Override
    public List<DienThoai> getAll() {
        return list;
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String insert(DienThoai dt) {
        if (dt != null) {
            list.add(dt);
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void sxGia(List<DienThoai> list) {
        Comparator<DienThoai> comp = new Comparator<DienThoai>() {
            @Override
            public int compare(DienThoai d1, DienThoai d2) {
                if (d1.getGia() > d2.getGia()) {
                    return 1;
                } else if (d1.getGia() == d2.getGia()) {
                    return 0;
                } else {
                    return -1;
                }
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        Collections.sort(list, comp);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String writeFile(String path) {
        try {
            FileOutputStream fo = new FileOutputStream(path);
            ObjectOutputStream ofo = new ObjectOutputStream(fo);
            ofo.writeObject(list);
            ofo.close();
            return "Ghi thành công";
        } catch (Exception e) {
            return "Lỗi ghi file";
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String readFile(String path) {
        try {
            FileInputStream fi = new FileInputStream(path);
            ObjectInputStream ifi = new ObjectInputStream(fi);
            list = (ArrayList) ifi.readObject();
            ifi.close();
            return "Đọc thành công";
        } catch (Exception e) {
            return "Lỗi đọc file";
        }

//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
