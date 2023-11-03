/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ph37410_baitonghop2;

import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class DoVat {
    Scanner sc= new Scanner(System.in);
    private String maDoVat;
    private String tenDoVat;
    private String chatLieu;

    public DoVat() {
    }

    public DoVat(String maDoVat, String tenDoVat, String chatLieu) {
        this.maDoVat = maDoVat;
        this.tenDoVat = tenDoVat;
        this.chatLieu = chatLieu;
    }
    
    public void nhap(){
        System.out.print("Nhap ma do vat: ");
        maDoVat=sc.nextLine();
        System.out.print("Nhap ten do vat: ");
        tenDoVat=sc.nextLine();
        System.out.print("Nhap chat lieu: ");
        chatLieu=sc.nextLine();
        
                
    }
    public void inThongTin(){
        System.out.println(maDoVat +" - "+tenDoVat+" - "+chatLieu );
    }
            

    public String getMaDoVat() {
        return maDoVat;
    }

    public void setMaDoVat(String maDoVat) {
        this.maDoVat = maDoVat;
    }

    public String getTenDoVat() {
        return tenDoVat;
    }

    public void setTenDoVat(String tenDoVat) {
        this.tenDoVat = tenDoVat;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }
    
    
    
}
