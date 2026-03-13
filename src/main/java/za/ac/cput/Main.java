package za.ac.cput;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.repository.EmployeeRepository;
public class Main {
    public static void main(String[] args) {
    EmployeeRepository repository = EmployeeRepository.getRepository();

    Employee employee = EmployeeFactory.createEmployee("576495", "Sandla", "Semfene", "South African");
    Employee employee2 = EmployeeFactory.createEmployee("547955", "Mdazibee", "HDMKF", "South African");

        System.out.println(" CREATE ");
        repository.create(employee);
        repository.create(employee2);
        System.out.println(repository.getAll());

        System.out.println(" READ ");
        System.out.println(repository.read("576495"));

        System.out.println(" UPDATE ");
    Employee updatedEmployee = new Employee.Builder()
            .copy(employee)
            .setLastName("Mthembu")
            .build();
        System.out.println(repository.update(updatedEmployee));

        System.out.println(" DELETE ");
        System.out.println(repository.delete("547955"));

        System.out.println(" FINAL STATE ");
        System.out.println(repository.getAll());
}
}
