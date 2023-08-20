package PolicyManagement;

import PolicyManagement.model.*;
import PolicyManagement.service.AccountManager;
import PolicyManagement.service.AddressManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    AddressManager addressManager = new AddressManager();
    User user = new User();
    BusinessAddress businessAddress = new BusinessAddress();
    HomeAddress homeAddress = new HomeAddress();
    AccountManager accountManager = new AccountManager();

        addressManager.addAddressToUser(user, homeAddress);
        addressManager.addAddressToUser(user, businessAddress);
        addressManager.subtractAddressFromUser(user, homeAddress);
        user.showUserInfo();
        user.showLoginStatus(user);


    System.out.print("Email: ");
    String email = scanner.nextLine();

    System.out.print("Password: ");
    String password = scanner.nextLine();

        try {
        Account loggedInAccount = accountManager.login(email, password);
        System.out.println("Logged in: " + loggedInAccount.toString());
    } catch (InvalidAuthenticationException e) {
        System.out.println(e.getMessage());
    }

}
}
