/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
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
public class Profile_Service implements Profile_Interface {

    private List<Profile> listPr = new ArrayList<>();

    public Profile_Service() {
        listPr.add(new Profile("Nghia7", "A", "Hà Nội", 1500));
        listPr.add(new Profile("Nghia6", "B", "Bắc Ninh", 2500));
        listPr.add(new Profile("Nghia3", "AB", "HCM", 2000));
        listPr.add(new Profile("Nghia4", "O", "Đà Nẵng", 1000));
    }

    @Override
    public List<Profile> getAll() {
        return listPr;
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String deletePr(int index) {
        if (index >= 0) {
            listPr.remove(index);
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String addPr(Profile pr) {
        if (pr != null) {
            listPr.add(pr);
            return "Add thành công";
        } else {
            return "Add thất bại";
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String updatePr(int index, Profile pr) {
        if (pr != null && index >= 0) {
            listPr.set(index, pr);
            return "Update thành công";
        } else {
            return "Update thất bại";
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void sx(List<Profile> list) {
        Comparator<Profile> comp = new Comparator<Profile>() {
            @Override
            public int compare(Profile o1, Profile o2) {
                return o1.getTen().compareTo(o2.getTen());
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        Collections.sort(list, comp);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String openFile(String path) {
        try {
            FileInputStream fi = new FileInputStream(path);
            ObjectInputStream ifi = new ObjectInputStream(fi);
            listPr = (List<Profile>) ifi.readObject();
            ifi.close();
            return "Mở file thành công";
        } catch (Exception e) {
            return "Mở thất bại";
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String saveFile(String path) {
        try {
            FileOutputStream fo = new FileOutputStream(path);
            ObjectOutputStream ofo = new ObjectOutputStream(fo);
            ofo.writeObject(listPr);
            ofo.close();
            return "Lưu thành công";
        } catch (Exception e) {
            return "Lưu thất bại";
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Profile> findMau(String nhomMau) {
        List<Profile> listTim = new ArrayList<>();
        for (Profile pr : listPr) {
            if (pr.getNhomMau().contains(nhomMau)) {
                listTim.add(pr);
            }
        }
        return listTim;
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void exportToFile(List<Profile> data, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Profile profile : data) {
                String line = profile.getTen() + "," + profile.getNhomMau() + "," + profile.getQueQuan() + "," + profile.getThuNhap();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
