package za.ac.cput.domain;

public class Employee {
    protected String employeeNumber;
    protected String firstName;
    protected String lastName;
    protected String employmentType;
    protected String nationality;



    public Employee(){

    }
    public Employee(Builder builder){
        this.employeeNumber = builder.employeeNumber;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.employmentType = builder.employmentType;
        this.nationality = builder.nationality;

    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getEmploymentType() {
        return employmentType;
    }
    public String getNationality() {
        return nationality;
    }



    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber='" + employeeNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employmentType='" + employmentType + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }

    public static class Builder{
        private String employeeNumber;
        private String firstName;
        private String lastName;
        private String employmentType;
        private String nationality;


        public Builder setEmployeeNumber(String employeeNumber) {
            this.employeeNumber = employeeNumber;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmploymentType(String employmentType) {
            this.employmentType = employmentType;
            return this;
        }

        public Builder setNationality(String nationality) {
            this.nationality = nationality;
            return this;
        }



        public Builder copy(Employee employee){
            this.employeeNumber = employee.employeeNumber;
            this.firstName = employee.firstName;
            this.lastName = employee.lastName;
            this.employmentType = employee.employmentType;
            this.nationality = employee.nationality;
            return this;


        } public Employee build(){
            return new Employee(this);
        }
    }// end of Builder



}//end of class
