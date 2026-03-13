package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Identity;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IdentityFactoryTest {
    private static  Identity identity = IdentityFactory.createIdentity("ID", "9801015009087");

    @Test
    @Order(1)
    void testCreateIdentity() {
        assertNotNull(identity);
        System.out.println(identity.toString());
    }

    @Test
    @Order(2)
    void testCreateIdentityWithMissingValue() {
        Identity invalidIdentity = IdentityFactory.createIdentity("", "9801015009087");
        assertNull(invalidIdentity);
    }
}