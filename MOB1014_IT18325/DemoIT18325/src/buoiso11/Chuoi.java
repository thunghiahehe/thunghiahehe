/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoiso11;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class Chuoi {

    public static void main(String[] args) {
        String chuoi1 = "Hello  ";
        String chuoi2 = "abc";

        System.out.println("Chuyen in thuong: " + chuoi1.toLowerCase());
        System.out.println("Chuyen in hoa: " + chuoi1.toUpperCase());
        chuoi1 = chuoi1.trim();
        System.out.println(chuoi1 + chuoi2);
        System.out.println("Do dai chuoi: " + chuoi1.length());
        System.out.println("Lay chuoi con: " + chuoi1.substring(1, 3));
        System.out.println("Lay ki tu tai vi tri: " + chuoi1.charAt(3));

        //Tìm và thay thế
        chuoi1 = chuoi1.replaceAll("l", "m");
        System.out.println(chuoi1);
        String chuoi3 = "Hoa hong nhung";
        chuoi3 = chuoi3.replaceAll(" ", "");
        System.out.println(chuoi3);

        //chuyển chuỗi thành mảng 
        String[] mang = chuoi1.split("m");
        for (String string : mang) {
            System.out.println(string);
        }

        System.out.println("So sanh chuoi hoa thuong" + "a".equals("A"));

        System.out.println("So sanh chuoi khong pb: " + "a".equalsIgnoreCase("A"));
        System.out.println("Kiem tra ton tai: " + "abc".contains("B"));
        System.out.println("Bat dau boi: " + "abc".startsWith("a"));
        System.out.println("Ket thuc boi: " + "abc".endsWith("c"));
        System.out.println(chuoi1);
        System.out.println("Vi tri dau: " + chuoi1.indexOf("m"));
        System.out.println("Vi tri cuoi: " + chuoi1.lastIndexOf("m"));
    }
}
