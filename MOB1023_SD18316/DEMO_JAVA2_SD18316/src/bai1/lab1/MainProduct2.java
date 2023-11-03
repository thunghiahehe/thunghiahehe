/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai1.Lab1;

import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class MainProduct2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product a[] = new Product[3];
        for (int i = 0; i < 3; i++) {
            if (i != 0) {
                System.out.printf("Name product %d: ", i + 1);
                String name = sc.nextLine();
                System.out.printf("Price product %d: ", i + 1);
                double price = Double.parseDouble(sc.nextLine());
                a[i] = new Product(name, price);
                a[i].inThongTin();
            } else {
                System.out.printf("Name product %d: ", i + 1);
                String name = sc.nextLine();
                System.out.printf("Price product %d: ", i + 1);
                double price = Double.parseDouble(sc.nextLine());
                a[i] = new NoTaxProduct(name, price);
                a[i].inThongTin();
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(a[i].getName() + " | " + a[i].getPrice() + " | " + a[i].getImportTax());
        }
    }
}
