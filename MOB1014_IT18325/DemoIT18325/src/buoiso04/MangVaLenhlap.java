/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoiso04;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class MangVaLenhlap {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//KHAI BÁO MẢNG
        //khai báo chưa biết số phần tử mảng
        int[] a;
        int b[];
        //khai báo và cho biết số phần tử mảng
        int[] c = new int[6];//=>mảng "c" có 6 phần tử
        //Khai báo và cho biết giá trị các phần tử trong mảng
        int[] d = {4, 7, 2, 8};
//IN RA MẢNG
        //<biến mảng>.length => cho biết số p.tử trong mảng
        for (int i = 0; i < d.length; i++) {
            System.out.printf("Phần tử thứ %d: %d\n", i, d[i]);
        }
        //In ra mảng sử dụng foreach
        for (int i : d) {
            System.out.println("In ra phần tử: " + i);
        }
//NHẬP GIÁ TRỊ CHO CÁC PHẦN TỬ TRONG MẢNG
        //nhập số phần tử có trong mảng
        int n;//kh.báo số p.tu mang
        System.out.print("Mảng a có số phần tử là: ");
        n = sc.nextInt();
        a = new int[n];

        //nhập các giá trị cho phần tử mảng
        for (int i = 0; i < n; i++) {
            System.out.printf("Nhập phần tử thứ %d: ", i);
            a[i] = sc.nextInt();
        }

        //In ra mảng vừa nhập
        for (int i : a) {
            System.out.print("\t" + i);
        }
        System.out.println();

        //Arrays.toString(<biến mảng)
        //=> In ra 1 mảng dưới dạng chuỗi
        System.out.println("In ra chuỗi-mảng vừa nhập: " + Arrays.toString(a));

        //Đưa ra vị trí xuất hiện đầu tiên của 1 giá trị trong mảng
        System.out.printf("Vị trí của số 8 là: %d", Arrays.binarySearch(a, 8));
        System.out.println();

        //Sắp xếp mảng tăng dần
        Arrays.sort(a);
        System.out.println("Mảng vừa sắp xếp tăng dần: " + Arrays.toString(a));

        //Thay đổi toàn bộ giá phần tử trong mảng = 1 giá trị khác
        Arrays.fill(a, 10);
        System.out.println("Mảng vừa thay giá trị: " + Arrays.toString(a));
    }

}
