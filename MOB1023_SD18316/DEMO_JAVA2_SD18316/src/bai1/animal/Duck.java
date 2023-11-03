/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai1.animal;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class Duck extends Animal implements Running, Flying, Swimming {

    public Duck() {
    }

    public Duck(String ten, int chieuCao, int canNang) {
        super(ten, chieuCao, canNang);
    }

    @Override
    public void run() {
        System.out.println("chay nhu vit");
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void fly() {
        System.out.println("Bay nhu vit");
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void swim() {
        System.out.println("boi nhu vit");
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void inThongTin() {
        System.out.println(super.toString());//xin đưa thông tin của cha
        this.run();
        this.fly();
        this.swim();
    }

}
