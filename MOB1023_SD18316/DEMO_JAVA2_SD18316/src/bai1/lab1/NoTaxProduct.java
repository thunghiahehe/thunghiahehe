/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai1.Lab1;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class NoTaxProduct extends Product {

    public NoTaxProduct(String name, double price) {
        super(name, price);
    }

    @Override
    public double getImportTax() {
        return 0; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}
