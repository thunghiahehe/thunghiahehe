/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab7;

import java.util.List;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public interface Profile_Interface {

    List<Profile> getAll();

    String deletePr(int index);

    String addPr(Profile pr);

    String updatePr(int index, Profile pr);

    void sx(List<Profile> list);

    List<Profile> findMau(String nhomMau);

    String openFile(String path);

    String saveFile(String path);
    void exportToFile(List<Profile> data, String fileName);
}
