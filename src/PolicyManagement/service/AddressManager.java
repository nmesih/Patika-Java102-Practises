package PolicyManagement.service;

import PolicyManagement.model.Address;
import PolicyManagement.model.User;

import java.util.ArrayList;

public class AddressManager {

    public void addAddressToUser(User user, Address address ){
        if(user.getAddresses() == null){
            user.setAddresses(new ArrayList<Address>());
        }
        user.getAddresses().add(address);
    }
    public void subtractAddressFromUser(User user, Address address){
        user.getAddresses().remove(address);
    }
}
