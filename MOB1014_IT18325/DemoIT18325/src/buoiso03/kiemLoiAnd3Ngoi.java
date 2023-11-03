/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoiso03;

import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class kiemLoiAnd3Ngoi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0;
        int b = 0;
        System.out.print("Nhập giá trị cho a: ");
        try {
            a = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Bạn phải nhập vào 1 số nguyên");
        }
        //System.out.println("a = " + a);
        System.out.print("Nhap gia tri cho b: ");
        try {
            b = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Bạn phải nhập vào 1 số nguyên");
        }
        int max = (a > b) ? a : b;
        System.out.println("max = " + max);

    }
    /*
        1. Kiểm lỗi try ... catch
    try{
        dong lenh can kiem soat loi
    } catch (Exception e){
        dong hien thi neu xay ra loi trong try
    }
        2. Toán tử 3 ngôi
    <bt điều kiện>?cv1:cv2
    Nếu biểu thức đk đúng thì kq là cv1
    Nếu biểu thức đk sai thì kq là cv2    
     */
}
