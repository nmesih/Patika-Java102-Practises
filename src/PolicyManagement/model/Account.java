package PolicyManagement.model;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Account implements Comparable<Account> {

    private AuthenticationStatusEnum authenticationStatus;
    private User user;
    private ArrayList<Insurance> insuranceList;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Insurance> getInsuranceList() {
        return insuranceList;
    }

    public void setInsuranceList(ArrayList<Insurance> insuranceList) {
        this.insuranceList = insuranceList;
    }

    public AuthenticationStatusEnum getAuthenticationStatus() {
        return authenticationStatus;
    }

    public void setAuthenticationStatus(AuthenticationStatusEnum authenticationStatus) {
        this.authenticationStatus = authenticationStatus;
    }

    public void login(String email, String password, User user) throws InvalidAuthenticationException {
        if (user == null || !user.getEmail().equals(email)) {
            throw new InvalidAuthenticationException("Invalid email or password");
        }
        if (user == null || !user.getPassword().equals(password)) {
            throw new InvalidAuthenticationException("Invalid email or password");
        }

        user.setAuthenticationStatus(AuthenticationStatusEnum.SUCCESS);
    }

    public void addAddress(Address address) {
        // Implement addAddress method
    }

    public void removeAddress(Address address) {
        // Implement removeAddress method
    }

    public abstract void addInsurance(User user, Insurance insurance);

    public final void showUserInfo() {
        System.out.println(toString());
    }

    public void showLoginStatus(User user){
        System.out.println(user.getFirstName() + " login status : " + authenticationStatus);
    }

    @Override
    public int compareTo(Account o) {
        return this.getUser().getEmail().compareTo(o.getUser().getEmail());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Account other = (Account) obj;
        return Objects.equals(getUser().getEmail(), other.getUser().getEmail());
    }

    public String toString() {
        return "Account{" +
                "user=" + user +
                ", InsuranceList=" + insuranceList +
                ", authenticationStatus=" + authenticationStatus +
                '}';
    }


}
