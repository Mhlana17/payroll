package za.ac.cput.factory;


import za.ac.cput.domain.Address;
import za.ac.cput.util.Helper;

public class AddressFactory {
    public static Address createAddress(String streetAddress, String postalAddress) {
        if(Helper.isNullOrEmpty(streetAddress) || Helper.isNullOrEmpty(postalAddress))
            return null;

        return new Address.Builder().setStreetAddress(streetAddress).build();





    }

}
