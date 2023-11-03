package test;


import test.KhachHang;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public interface KhachHang_Interface {

    List<KhachHang> getAll();

    String add(KhachHang kh);

    String update(int index, KhachHang kh);

    String saveFile(String path);

    String openFile(String path);

    List<KhachHang> tim(String ten);
}
