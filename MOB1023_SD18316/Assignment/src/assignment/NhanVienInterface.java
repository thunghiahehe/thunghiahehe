/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package assignment;

import java.util.List;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public interface NhanVienInterface {

    List<NhanVien> getAll();

    String addNhanVien(NhanVien nv);

    String updateNhanVien(int index, NhanVien nv);

    String removeNhanVien(int index);

    String openFile(String path);

    String saveFile(String path);

    List<NhanVien> findNV(String ma);
}
