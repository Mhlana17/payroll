package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Employee;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeFactoryTest {
    private static Employee employee1 = EmployeeFactory.createEmployee("576495", "Sandla","Semfene","South African");
    private static Employee employee2 = EmployeeFactory.createEmployee("547955", "Mdazibee","HDMKF","South African");

    @Test
    @Order(1)
    public void testCreateEmployee(){
        assertNotNull(employee1);
        System.out.println(employee1.toString());


    }
    @Test
    @Order(2)
    public void testCreateEmployee2(){
        assertNotNull(employee2);
        System.out.println(employee2.toString());

    }
    //@Test
//    @Order(3)
//    public void testCreateEmployeeThatFails(){
//        assertNotNull(e3);
//        System.out.println(e3.toString());
//    }
    @Test
    @Disabled
    @Order(4)
    public void testNotCompletedYet(){
        //Todo
    }

}