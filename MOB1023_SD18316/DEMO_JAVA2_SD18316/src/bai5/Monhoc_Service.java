/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai5;

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
public class Monhoc_Service implements Monhoc_Interface {

    private List<MonHoc> listMH = new ArrayList<>();

    public Monhoc_Service() {//fake data
        listMH.add(new MonHoc("M01", "Java1", 2));
        listMH.add(new MonHoc("M02", "Java2", 3));
        listMH.add(new MonHoc("M03", "Java3", 1));
        listMH.add(new MonHoc("M04", "Java4", 4));
    }

    @Override
    public List<MonHoc> getAll() {
        return listMH;
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String writeFile(String path) {
        //Đọc và ghi file: try catch
        try {//ghi được
            FileOutputStream fo = new FileOutputStream(path); //luồng đẩy ra file
            ObjectOutputStream ofo = new ObjectOutputStream(fo);
            ofo.writeObject(listMH);//ghi list ra file trên đĩa
            ofo.close();//đóng file
            return "Ghi thành công";
        } catch (Exception e) {//lỗi ghi
            return "Lỗi ghi file";
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String readFile(String path) {
        try {
            FileInputStream fi = new FileInputStream(path);
            ObjectInputStream ifi = new ObjectInputStream(fi);
            listMH = (ArrayList) ifi.readObject();
            ifi.close();
            return "Đọc thành công";
        } catch (Exception e) {
            return "Lỗi đọc file";
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
