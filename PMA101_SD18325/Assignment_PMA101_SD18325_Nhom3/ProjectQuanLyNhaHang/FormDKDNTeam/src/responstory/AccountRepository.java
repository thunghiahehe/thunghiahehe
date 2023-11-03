/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responstory;

import java.util.ArrayList;
import java.util.List;
import model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import sevice.DBConnection;

/**
 *
 * @author HÙNG
 */
public class AccountRepository {

    public List<Account> getAll() {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT * FROM ACCOUNT";
        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account acc = new Account(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4));
                list.add(acc);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public Boolean insert(Account acc) {
        Integer check = 0;
        String sql = "INSERT ACCOUNT (USERNAME, GMAIL, PASS) VALUES (?,?,?)";
        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, acc.getUserName());
            ps.setObject(2, acc.getGmail());
            ps.setObject(3, acc.getPass());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public Boolean update(Account acc) {
        Integer check = 0;
        String sql = "UPDATE ACCOUNT SET GMAIL = ?, PASS = ? WHERE USERNAME = ?";
        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, acc.getGmail());
            ps.setObject(2, acc.getPass());
            ps.setObject(3, acc.getUserName());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    public static void main(String[] args) {
        AccountRepository r = new AccountRepository();
        List<Account> list = r.getAll();
        for (Account o : list) {
            System.out.println(o);
        }
    }
}
