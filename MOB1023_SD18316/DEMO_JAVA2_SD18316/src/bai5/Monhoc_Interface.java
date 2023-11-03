/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bai5;

import java.util.List;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public interface Monhoc_Interface {

    List<MonHoc> getAll();

    String writeFile(String path);//path: lưu file ở đâu

    String readFile(String path);//path: lưu dữ liệu nào ở file 
}
