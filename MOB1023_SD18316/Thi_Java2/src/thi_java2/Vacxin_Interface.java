/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package thi_java2;

import java.util.List;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public interface Vacxin_Interface {

    List<Vacxin> getAll();

    String add(Vacxin v);

    String writeFile(String path);

    String readFile(String path);

    List<Vacxin> find(String ten);
}
