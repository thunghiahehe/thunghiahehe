/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2_bai4;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class UserService_IMPL implements UserService {//thực thi Interface

    private List<User> listUser = new ArrayList<>();
    //listUser: dùng để quản lí toàn bộ danh sáchUser 

    public UserService_IMPL() {//Constructor
        listUser.add(new User("nghia1", "123", "user"));
        listUser.add(new User("nghia2", "234", "user"));
        listUser.add(new User("nghia3", "456", "user"));
        listUser.add(new User("nghia4", "678", "admin"));
    }

    @Override
    public List<User> getAll() {
        return listUser;//trả lại tất cả danh sách
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String addUser(User u) {
        if (u != null) {
            listUser.add(u);
            return "Them thanh cong";
        } else//u==null
        {
            return "Them that bai";
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String remove(int index) {
        if (index >= 0) {//có chọn đối tượng để xóa
            listUser.remove(index);
            return "Xoa thanh cong";
        } else {
            return "Xoa that bai";

        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String update(int index, User u) {
        if (index >= 0 && u != null) {
            listUser.set(index, u);
            return "Cap nhat thanh cong";
        } else {
            return "Cap nhat that bai";
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
