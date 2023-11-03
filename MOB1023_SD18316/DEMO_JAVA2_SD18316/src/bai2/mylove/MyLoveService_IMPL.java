/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai2.mylove;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class MyLoveService_IMPL implements MyLove_Service {

    private List<MyLove> listMyLove = new ArrayList<>();

    public MyLoveService_IMPL() {
        listMyLove.add(new MyLove("nghia", "Nu", 18));
        listMyLove.add(new MyLove("minh", "Nam", 19));
        listMyLove.add(new MyLove("may", "Nu", 20));
    }

    @Override
    public List<MyLove> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return listMyLove;
    }

}
