/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bai3.sinhvien;

import java.util.List;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public interface SinhVien_Service {

    List<SinhVien> getAll();

    String addSV(SinhVien sv);

    String removeSV(int index);

    String updateSV(int index, SinhVien sv);

    void sapXepTen(List<SinhVien> list);

    void sapXepDiem(List<SinhVien> listDiem);

    List<SinhVien> findTen(String ten);
}
