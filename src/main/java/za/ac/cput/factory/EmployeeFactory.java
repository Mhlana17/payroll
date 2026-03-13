package za.ac.cput.factory;


import za.ac.cput.domain.Employee;
import za.ac.cput.util.Helper;

public class EmployeeFactory {
    public static Employee createEmployee(String employeeNumber, String firstName,
                                          String lastName, String nationality) {
        if(Helper.isNullOrEmpty(employeeNumber) || Helper.isNullOrEmpty(firstName)
                || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(nationality))
            return null;


        return new Employee.Builder().setEmployeeNumber(employeeNumber).setFirstName(firstName).
                setLastName(lastName).setNationality(nationality).build();





    }

}
