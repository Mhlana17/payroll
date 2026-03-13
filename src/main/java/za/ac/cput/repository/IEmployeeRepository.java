package za.ac.cput.repository;

import za.ac.cput.domain.Employee;

import java.util.Set;

public interface IEmployeeRepository {
    Employee create(Employee employee);

    Employee read(String employeeNumber);

    Employee update(Employee employee);

    boolean delete(String employeeNumber);

    Set<Employee> getAll();
}