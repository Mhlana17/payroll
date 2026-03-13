package za.ac.cput.repository;

import za.ac.cput.domain.Employee;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRepository implements IRepository<Employee, String> {
    private static EmployeeRepository repository = null;
    private final Set<Employee> employees;

    private EmployeeRepository() {
        this.employees = new HashSet<>();
    }

    public static EmployeeRepository getRepository() {
        if (repository == null) {
            repository = new EmployeeRepository();
        }
        return repository;
    }

    @Override
    public Employee create(Employee employee) {
        this.employees.add(employee);
        return employee;
    }

    @Override
    public Employee read(String employeeNumber) {
        return findByEmployeeNumber(employeeNumber);
    }

    @Override
    public Employee update(Employee employee) {
        Employee oldEmployee = findByEmployeeNumber(employee.getEmployeeNumber());
        if (oldEmployee != null) {
            this.employees.remove(oldEmployee);
            this.employees.add(employee);
            return employee;
        }
        return null;
    }

    @Override
    public boolean delete(String employeeNumber) {
        Employee employee = findByEmployeeNumber(employeeNumber);
        if (employee != null) {
            this.employees.remove(employee);
            return true;
        }
        return false;
    }

    @Override
    public Set<Employee> getAll() {
        return this.employees;
    }

    private Employee findByEmployeeNumber(String employeeNumber) {
        return this.employees.stream()
                .filter(employee -> employee.getEmployeeNumber().equals(employeeNumber))
                .findAny()
                .orElse(null);
    }
}
