/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test1;

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
public class SachService implements SachInterface {

    private List<Sach> listS = new ArrayList<>();

    public SachService() {
        listS.add(new Sach("ten1", "trinh tham", 150));
        listS.add(new Sach("ten2", "tieu thuyet", 300));
        listS.add(new Sach("ten3", "tieu thuyet", 250));
        listS.add(new Sach("ten4", "trinh tham", 450));
        listS.add(new Sach("ten5", "trinh tham", 100));
    }

    @Override
    public List<Sach> getAll() {
        return listS;
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String add(Sach s) {
        if (s != null) {
            listS.add(s);
            return "them thanh cong";
        } else {
            return "them that bai";
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String writeFile(String path) {
        try {
            FileOutputStream fo = new FileOutputStream(path);
            ObjectOutputStream ofo = new ObjectOutputStream(fo);
            ofo.writeObject(listS);
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
            listS = (ArrayList) ifi.readObject();
            ifi.close();
            return "Doc file thanh cong";
        } catch (Exception e) {
            return "Loi doc file";
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String remove(int index) {
        if (index >= 0) {
            listS.remove(index);
            return "xoa thanh cong";
        } else {
            return "xoa that bai";
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
