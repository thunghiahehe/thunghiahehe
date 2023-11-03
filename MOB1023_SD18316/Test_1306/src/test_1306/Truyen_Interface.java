/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package test_1306;

import java.util.List;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public interface Truyen_Interface {

    List<Truyen> getAll();

    String add(Truyen t);

    void sx(List<Truyen> list);

    String writeFile(String path);

    String readFile(String path);

    List<Truyen> find(String ten);
}
