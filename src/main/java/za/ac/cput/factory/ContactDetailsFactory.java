package za.ac.cput.factory;

import za.ac.cput.domain.ContactDetails;
import za.ac.cput.util.Helper;

public class ContactDetailsFactory {
    public static ContactDetails createContactDetails(String phoneNumber,String homeNumber, String email) {
        if(Helper.isNullOrEmpty(phoneNumber) || Helper.isNullOrEmpty(homeNumber) || Helper.isNullOrEmpty(email))
            return null;
        if(!Helper.isValidEmail(email))
            return null;

        return new ContactDetails.Builder().setPhoneNumber(phoneNumber)
                   .setHomeNumber(homeNumber)
                   .setEmail(email).build();





    }

}
