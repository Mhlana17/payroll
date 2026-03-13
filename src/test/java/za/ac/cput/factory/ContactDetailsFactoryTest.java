package za.ac.cput.factory;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.ContactDetails;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactDetailsFactoryTest {
    private static ContactDetails contactDetails = ContactDetailsFactory.createContactDetails(
            "0123456789", "0211234567", "test@cput.ac.za");

    @Test
    @Order(1)
    void testCreateContactDetails() {
        assertNotNull(contactDetails);
        System.out.println(contactDetails.toString());
    }

    @Test
    @Order(2)
    void testCreateContactDetailsWithInvalidEmail() {
        ContactDetails invalidContactDetails = ContactDetailsFactory.createContactDetails(
                "0123456789", "0211234567", "invalidEmail");
        assertNull(invalidContactDetails);
    }
}