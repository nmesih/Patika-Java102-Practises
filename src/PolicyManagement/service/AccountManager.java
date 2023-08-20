package PolicyManagement.service;

import PolicyManagement.model.Account;
import PolicyManagement.model.InvalidAuthenticationException;
import PolicyManagement.model.User;

import java.util.TreeSet;

public class AccountManager {
    private TreeSet<Account> accounts;

    public AccountManager() {
        accounts = new TreeSet<>();
    }

    public Account login(String email, String password) throws InvalidAuthenticationException {
        for (Account account : accounts) {
            User user = account.getUser();
            if (user != null && user.getEmail().equals(email) && user.getPassword().equals(password)) {
                try {
                    account.login(email, password, user);
                    return account;
                } catch (InvalidAuthenticationException e) {
                }
            }
        }
        throw new InvalidAuthenticationException("Invalid email or password");
    }


    public void addAccount(Account account) {
        accounts.add(account);
    }
}
