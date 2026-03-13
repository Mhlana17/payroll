package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Job;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JobFactoryTest {
    private static  Job jobTittle = JobFactory.createJob("Manager");
    private static  Job jobTittle2 = JobFactory.createJob("Developer");

    @Test
    @Order(1)
    void testCreatePosition() {
        assertNotNull(jobTittle);
        System.out.println(jobTittle.toString());
    }

    @Test
    @Order(2)
    void testCreatePositionWithMissingValue() {
        Job invalidPosition = JobFactory.createJob("");
        assertNull(invalidPosition);
    }
}