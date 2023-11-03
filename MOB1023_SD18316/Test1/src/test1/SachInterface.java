/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package test1;

import java.util.List;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public interface SachInterface {
    List<Sach> getAll();
    String add(Sach s);
    String writeFile(String path);
    String readFile(String path);
    String remove(int index);
}
