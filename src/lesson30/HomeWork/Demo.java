package lesson30.HomeWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Demo {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        List<Employee> employees1 = new ArrayList<>();
        List<Department> departments = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();
        Department analyticDepartment = new Department(employees, DepartmentType.ANALYTIC);
        Department engineeringDepartment = new Department(employees, DepartmentType.ENGINEERING);


        Customer customer1 = new Customer("Albert", "Germany", 1500);
        Customer customer2 = new Customer("John", "UK", 500);
        Customer customer3 = new Customer("Robert", "USA", 1000);
        Customer customer4 = new Customer("Andrey", "Ukraine", 700);

        Project project = new Project("Park", customer1);
        Project project1 = new Project("Game", customer2);
        Project project2 = new Project("Fun", customer3);
        Project project3 = new Project("Test", customer4);

        ArrayList<Project> projects = new ArrayList<>();
        ArrayList<Project> projects1 = new ArrayList<>();
        ArrayList<Project> projects2 = new ArrayList<>();

        projects.add(project);
        projects.add(project3);
        projects1.add(project1);
        projects1.add(project2);


        Employee employee1 = new Employee("Alex", "Ivanov", new Date(), Position.ANALYST, analyticDepartment,
                projects);
        Employee employee2 = new Employee("Dan", "Petrov", new Date(), Position.ANALYST, analyticDepartment,
                projects1);
        Employee employee3 = new Employee("Valentin", "Kucher", new Date(), Position.ANALYST, analyticDepartment,
                projects2);
        Employee employee4 = new Employee("John", "Smith", new Date(), Position.DEVELOPER, engineeringDepartment,
                projects);


        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee4);

        employees1.add(employee3);

//        System.out.println(employees);

        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.setEmployees(employees);
        employeeDAO.setEmployees(employees1);

        System.out.println(employeeDAO.employeesWithoutProject());

    }
}
