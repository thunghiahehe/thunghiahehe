/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sevice;

import java.util.List;
import model.Account;
import responstory.AccountRepository;

/**
 *
 * @author HÙNG
 */
public class AccountService {

    private AccountRepository repository = new AccountRepository();

    public List<Account> getAll() {
        return repository.getAll();
    }

    public Boolean insert(Account acc) {
        return repository.insert(acc);
    }

    public Boolean update(Account acc) {
        return repository.update(acc);
    }
}
