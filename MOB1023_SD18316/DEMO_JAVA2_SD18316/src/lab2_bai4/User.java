/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2_bai4;

/**
 *
 * @author NGUYEN THI THU NGHIA
 */
public class User { //data

    private String name;
    private String pass;
    private String role;

    public User() {
    }

    public User(String name, String pass, String role) {
        this.name = name;
        this.pass = pass;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    Object[] toDataRow() {
        return new Object[]{this.getName(), this.getPass(), this.getRole()};

    }
}
