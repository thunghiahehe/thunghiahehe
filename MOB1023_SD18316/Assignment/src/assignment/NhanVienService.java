/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class NhanVienService implements NhanVienInterface {

    private List<NhanVien> listNV = new ArrayList<>();

    public NhanVienService() {
        listNV.add(new NhanVien("PH123", "Nghia1", 19, "nghiantt@fpt.edu.vn", 1500));
        listNV.add(new NhanVien("PH234", "Nghia2", 19, "nghiantt@fpt.edu.vn", 1500));
        listNV.add(new NhanVien("PH125", "Nghia3", 19, "nghiantt@fpt.edu.vn", 1500));
        listNV.add(new NhanVien("PH370", "Nghia4", 19, "nghiantt@fpt.edu.vn", 1500));
    }

    @Override
    public List<NhanVien> getAll() {
        return listNV;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String addNhanVien(NhanVien nv) {
        if (nv != null) {
            listNV.add(nv);
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String removeNhanVien(int index) {
        if (index >= 0) {
            listNV.remove(index);
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String updateNhanVien(int index, NhanVien nv) {
        if (index >= 0 && nv != null) {
            listNV.set(index, nv);
            return "Update thành công";
        } else {
            return "Update thất bại";
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String openFile(String path) {
        try {
            FileInputStream fi = new FileInputStream(path);
            ObjectInputStream ifi = new ObjectInputStream(fi);
            listNV = (ArrayList) ifi.readObject();
            ifi.close();
            return "Mở file thành công";
        } catch (Exception e) {
            return "Mở file thất bại";
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String saveFile(String path) {
        try {
            FileOutputStream fo = new FileOutputStream(path);
            ObjectOutputStream ofo = new ObjectOutputStream(fo);
            ofo.writeObject(listNV);
            ofo.close();
            return "Save file thành công";
        } catch (Exception e) {
            return "Lỗi lưu file";
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<NhanVien> findNV(String ma) {
        List<NhanVien> listFind = new ArrayList<>();
        for (NhanVien nhanVien : listNV) {
            if (nhanVien.getMa().contains(ma)) {
                listFind.add(nhanVien);
            }
        }
        return listFind;
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
