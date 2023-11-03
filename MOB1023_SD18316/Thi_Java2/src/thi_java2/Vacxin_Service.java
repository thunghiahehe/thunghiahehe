/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thi_java2;

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
public class Vacxin_Service implements Vacxin_Interface {

    private List<Vacxin> listV = new ArrayList<>();

    public Vacxin_Service() {
        listV.add(new Vacxin("A01", "vacxin1", "viet nam", "uong", 2020));
        listV.add(new Vacxin("A02", "vacxin2", "an do", "tiem", 2019));
        listV.add(new Vacxin("A03", "vacxin3", "nhat", "uong", 2004));
        listV.add(new Vacxin("A04", "vacxin4", "anh", "tiem", 2022));
    }

    @Override
    public List<Vacxin> getAll() {
        return listV;
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String add(Vacxin v) {
        if (v != null) {
            listV.add(v);
            return "Them thanh cong";
        } else {
            return "Them that bai";
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String writeFile(String path) {
        try {
            FileOutputStream fo = new FileOutputStream(path);
            ObjectOutputStream ofo = new ObjectOutputStream(fo);
            ofo.writeObject(listV);
            ofo.close();
            return "Ghi file thanh cong";
        } catch (Exception e) {
            return "Loi ghi file";
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String readFile(String path) {
        try {
            FileInputStream fi = new FileInputStream(path);
            ObjectInputStream ifi = new ObjectInputStream(fi);
            listV = (ArrayList) ifi.readObject();
            ifi.close();
            return "Doc file thanh cong";
        } catch (Exception e) {
            return "Loi doc file";
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Vacxin> find(String ten) {
        List<Vacxin> listFind = new ArrayList<>();
        for (Vacxin vacxin : listV) {
            if (vacxin.getTen().contains(ten)) {
                listFind.add(vacxin);
            }
        }
        return listFind;
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
