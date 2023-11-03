/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoiso02;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class baiTap {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int choose;
        do{
            System.out.println("+-------------------- MENU --------------------+");
            System.out.println("\t1. Hoan vi");
            System.out.println("\t2. Kiem tra Chan - Le");
            System.out.println("\t3. Quay so ngau nhien");
            System.out.println("\t4. Cac so tu 1 - 10");
            System.out.println("\t5. Cac so tu 1 - 10 va khong co so 5");
            System.out.println("\t6. Thoat");
            System.out.println("+----------------------------------------------+");
            System.out.println("Chon chuc nang: ");
            choose=sc.nextInt();
            switch (choose) {
                case 1:
                    chucNang1();
                    break;
              
                case 2:
                    chucNang2();
                    break;
                    
                case 3:
                    chucNang3();
                    break;
                    
                case 4:
                    chucNang4();
                    break;
                    
                case 5:
                    chucNang5();
                    break;
                    
                case 0:
                    System.exit(choose);
                default:
                    System.out.println("Vui long chon lai chuc nang");
            }
        }while(choose !=0);
    }

    static void chucNang1() {
        int a,b;
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhap a: ");
        a = sc.nextInt();
        System.out.print("Nhap b: ");
        b = sc.nextInt();
        if(a<b){
            int hv=a;
            a=b;
            b=hv;
            System.out.println("a = "+a);
            System.out.println("b = "+b);
        }
        else if(a==b){
            System.out.println("a = b");
        }
        else{
            System.out.println("Khong can hoan vi");
        }
    }
    

    static void chucNang2() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Moi ban nhap 1 so bat ki: ");
        int n=sc.nextInt();
        if(n%2 == 0){
            System.out.println("n la so chan");
        }
        else{
            System.out.println("n la so le");
        }
                
    }

    static void chucNang3() {
        Random gr = new Random();
        int x=gr.nextInt((15-10)+1)+10;
        if(x<12){
            System.out.println("khong co giai");
        }
        else if(x>14){
            System.out.println("giai Nhat");
        }
        else{
            System.out.println("giai Dac biet");
        }
        
    }

    static void chucNang4() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("\t"+i);
        }
    }

    static void chucNang5() {
        for (int i = 1; i <= 10; i++) {
            if(i==5){
                continue;
            }
            System.out.println("\t"+i);
        }
    }
    
    
}
