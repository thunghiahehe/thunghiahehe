/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab2_bai4;

import java.util.List;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public interface UserService {

    //chức các phương thức trừu tượng
    List<User> getAll();//lấy ra toàn bộ dánh sách

    String addUser(User u);//thêm vào danh sách

    String remove(int index);//xóa User tại vị trí index

    String update(int index, User u);//cập nhật User tại index

}
