/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bai6.dangki;

import java.util.List;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public interface Dangki_Interface {

    List<DangKi> getAll();

    String add(DangKi dk);

    String update(int index, DangKi dk);

    String delete(int index);

    void sxMa(List<DangKi> listDK);
}
