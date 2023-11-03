package test;


import test.KhachHang_Interface;
import test.KhachHang;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class KhachHang_Service implements KhachHang_Interface {

    private List<KhachHang> listKH = new ArrayList<>();

    public KhachHang_Service() {
        listKH.add(new KhachHang("A01", "nghia1", "viet nam", "nam"));
        listKH.add(new KhachHang("A02", "nghia2", "anh", "nam"));
        listKH.add(new KhachHang("A03", "nghia3", "nhat", "nu"));
        listKH.add(new KhachHang("A04", "nghia4", "trung quoc", "nam"));
        listKH.add(new KhachHang("A05", "nghia5", "mi", "nu"));
    }

    @Override
    public List<KhachHang> getAll() {
        return listKH;
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String add(KhachHang kh) {
        if (kh != null) {
            listKH.add(kh);
            return "Them thanh cong";
        } else {
            return "Them that bai";
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String update(int index, KhachHang kh) {
        if (kh != null && index >= 0) {
            listKH.set(index, kh);
            return "Update thanh cong";
        } else {
            return "Update that bai";
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String saveFile(String path) {
        try {
            FileOutputStream fo = new FileOutputStream(path);
            ObjectOutputStream ofo = new ObjectOutputStream(fo);
            ofo.writeObject(listKH);
            ofo.close();
            return "Luu file thanh cong";
        } catch (Exception e) {
            return "Loi luu file";
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String openFile(String path) {
        try {
            FileInputStream fi = new FileInputStream(path);
            ObjectInputStream ifi = new ObjectInputStream(fi);
            listKH = (ArrayList) ifi.readObject();
            ifi.close();
            return "Mo file thanh cong";
        } catch (Exception e) {
            return "Loi mo file";
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<KhachHang> tim(String ten) {
        List<KhachHang> listTim = new ArrayList<>();
        for (KhachHang khachHang : listKH) {
            if (khachHang.getTen().contains(ten)) {
                listTim.add(khachHang);
            }
        }
        return listTim;
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
