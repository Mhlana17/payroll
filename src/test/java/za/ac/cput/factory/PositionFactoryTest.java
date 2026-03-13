package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Position;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PositionFactoryTest {
    private static  Position position = PositionFactory.createPosition("DEV001", "ACTIVE");

    @Test
    @Order(1)
    void testCreatePosition() {
        assertNotNull(position);
       System.out.println(position.toString());
    }

    @Test
    @Order(2)
    void testCreatePositionWithMissingValue() {
        Position invalidPosition = PositionFactory.createPosition("", "ACTIVE");
        assertNull(invalidPosition);
    }
}