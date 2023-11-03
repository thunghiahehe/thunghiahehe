/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thithu_13_6;

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
public class TruyenService implements Truyen_Interface {

    private List<Truyen> listT = new ArrayList<>();

    public TruyenService() {
        listT.add(new Truyen("A01", "Truyen1", "hien dai", 2022));
        listT.add(new Truyen("A02", "Truyen2", "kiem hiep", 2000));
        listT.add(new Truyen("A03", "Truyen3", "hien dai", 2012));
        listT.add(new Truyen("A04", "Truyen4", "co dai", 1992));
    }

    @Override
    public List<Truyen> getAll() {
        return listT;
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String add(Truyen t) {
        if (t != null) {
            listT.add(t);
            return "Them thanh cong";
        } else {
            return "Them that bai";
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void sx(List<Truyen> list) {
        Comparator<Truyen> comp = new Comparator<Truyen>() {
            @Override
            public int compare(Truyen t1, Truyen t2) {
                return t1.getMa().compareTo(t2.getMa());
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        Collections.sort(list, comp);
        Collections.reverse(list);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String writeFile(String path) {
        try {
            FileOutputStream fo = new FileOutputStream(path);
            ObjectOutputStream ofo = new ObjectOutputStream(fo);
            ofo.writeObject(listT);
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
            listT = (ArrayList) ifi.readObject();
            ifi.close();
            return "Doc file thanh cong";
        } catch (Exception e) {
            return "Loi ghi file";
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Truyen> find(String ten) {
        List<Truyen> listFind = new ArrayList<>();
        for (Truyen truyen : listT) {
            if (truyen.getTen().contains(ten)) {
                listFind.add(truyen);
            }
        }
        return listFind;
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
