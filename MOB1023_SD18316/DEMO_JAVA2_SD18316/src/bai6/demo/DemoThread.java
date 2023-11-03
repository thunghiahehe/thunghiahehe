/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai6.demo;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class DemoThread implements Runnable {//Đa luồng
    //Runnable: để chạy đa luồng

    public static void main(String[] args) {
        DemoThread th = new DemoThread();//tạo đối tượng class
        Thread t1 = new Thread(th);//tạo luồng t1 của đối tượng DemoThread
        t1.setName("t1: ");//đặt tên cho luồng
        t1.start();//luồng chạy
        Thread t2 = new Thread(th);
        t2.setName("t2: ");
        t2.start();
        Thread t3 = new Thread(th);
        t3.setName("t3: ");
        t3.start();
    }

    @Override
    public void run() {//chạy như thế nào
        //luồng hiện tại
        Thread th = Thread.currentThread();
        for (int i = 1; i <= 5; i++) {
            System.out.println("Luong: " + th.getName() + i);//1s chạy 1 lần
            try {
                Thread.sleep(1000);//tạm dừng
            } catch (Exception e) {
                break;
            }
        }
    }

}
