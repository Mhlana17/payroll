package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Address;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AddressFactoryTest {
    private static final Address address = AddressFactory.createAddress("12 Main Road", "P.O Box 123");

    @Test
    @Order(1)
    void testCreateAddress() {
        assertNotNull(address);
       System.out.println(address.toString());
    }

    @Test
    @Order(2)
    void testCreateAddressWithMissingValue() {
        Address invalidAddress = AddressFactory.createAddress("", "P.O Box 123");
        assertNull(invalidAddress);
    }
}