/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoiso05;

import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class sapXepGiamDan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Khai báo biến
        int[] a;//mảng a
        int n;//số p.tử trong mảng

        //Nhập vào số phần tử mảng
        System.out.print("Mảng có số phần tử là: ");
        n = sc.nextInt();
        a = new int[n];

        //Nhập giá trị cho các phân tử trong mảng
        for (int i = 0; i < n; i++) {
            System.out.printf("Nhập giá trị cho phần tử thứ %d: ", i);
            a[i] = sc.nextInt();
        }

        //Sắp xếp mảng giảm dần
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int hVi;
                if (a[i] < a[j]) {
                    hVi = a[i];
                    a[i] = a[j];
                    a[j] = hVi;
                }
            }
        }

        //In ra mảng vừa sắp xếp
        for (int i : a) {
            System.out.println("\t" + i);
        }
        System.out.println();
    }

}
