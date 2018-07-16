package lesson30.HomeWork;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demo {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        List<Department> departments = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();
        Department analyticDepartment = new Department(employees, DepartmentType.ANALYTIC);

//        Employee employee1 = new Employee("Alex", "Ivanov", new Date(), Position.ANALYST, analyticDepartment, new Project());
//        Employee employee2 = new Employee("Dan", "Petrov", new Date(), Position.ANALYST, analyticDepartment, new Project());
//        Employee employee3 = new Employee("Valentin", "Kucher", new Date(), Position.ANALYST, analyticDepartment, new Project());

        Customer customer1 = new Customer("Albert", "Germany", 1500);
        Customer customer2 = new Customer("John", "UK", 500);
        Customer customer3 = new Customer("Robert", "USA", 1000);
        Customer customer4 = new Customer("Andrey", "Ukraine", 700);

        FirmDAO firmDAO = new FirmDAO();
        DepartmentDAO departmentDAO = new DepartmentDAO();

        departments.add(departmentDAO.department);
//        employees.add(employee1);
//        employees.add(employee2);
//        employees.add(employee3);

//        System.out.println(employees);

        EmployeeDAO employeeDAO = new EmployeeDAO();

        employeeDAO.employeesByProject("Alex");

    }
}
