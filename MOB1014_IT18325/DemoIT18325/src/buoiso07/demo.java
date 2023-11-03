/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoiso07;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class demo {

    public static void main(String[] args) {
        MayTinh tinh = new MayTinh();
        tinh.tinhTong(4, 5);
        tinh.tinhTong(1.4, 5.0);

        MayTinh khongTS = new MayTinh();
        MayTinh haiTS = new MayTinh(1, 2);
        MayTinh baTS = new MayTinh(1, 2, 3);

    }
}
