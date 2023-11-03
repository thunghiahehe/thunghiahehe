/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baikt;

import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class HoaQuaNhapKhau extends HoaQua{
   public double thue(){
       Scanner sc = new Scanner(System.in);
       System.out.println("Nhap hinh thuc nhap khau(Chinh ngach/Tieu ngach/Cac loai khac): ");
       String hThucNK = sc.nextLine();
       if (hThucNK.equalsIgnoreCase("Chinh ngach")) {
           return getDonGia()*0.1;
       } 
       else if (hThucNK.equalsIgnoreCase("Tieu ngach")){
           return getDonGia()*0.05;
       }
       else{
           return getDonGia()*0.05;
       } 
   }
}
