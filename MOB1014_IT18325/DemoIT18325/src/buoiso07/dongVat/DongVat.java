/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoiso07.dongVat;

import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class DongVat {

    Scanner sc = new Scanner(System.in);
    double canNang;
    String loai;

    public DongVat() {
    }

    public DongVat(String loai) {
        this.loai = loai;
    }

    void nhap() {
        System.out.print("Nhap loai dong vat: ");
        loai = sc.nextLine();
        System.out.print("Nhap can nang: ");
        canNang = Double.parseDouble(sc.nextLine());
    }

    void xuat() {
        System.out.println("con " + loai + " nang " + canNang + "kg " + " keu " + tiengKeu());
    }

    String tiengKeu() {
        if (loai.equalsIgnoreCase("cho")) {
            return "gau gau";
        } else if (loai.equalsIgnoreCase("meo")) {
            return "meo meo";
        } else {
            return "chua biet";
        }
    }
}
/*
1. PHƯƠNG THỨC
    <giá trị trả về> <tên phương thức> (<tham số đầu vào>){
        <công việc>
        return<giá trị>;
    }
=> <tham số đầu vào> có thể có or không
=> return: dòng nay chỉ xuất hiện khi giá trị trả về khác void
=> kiểu của giá trị phải cùng kiểu với kiểu trả về

*/
