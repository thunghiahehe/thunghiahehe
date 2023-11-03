/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab5.dienthoai;

import java.util.List;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public interface DienThoai_Interface {

    List<DienThoai> getAll();

    String insert(DienThoai dt);

    void sxGia(List<DienThoai> list);

    String writeFile(String path);

    String readFile(String path);

}
