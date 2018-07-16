package lesson30.HomeWork;

import java.util.*;

public class EmployeeDAO {

    private static List<Employee> employees;

    public static List<Employee> getEmployees() {
        return employees;
    }

    public static void setEmployees(List<Employee> employees) {
        EmployeeDAO.employees = employees;
    }


    public static List<Employee> employeesByProject(String projectName) {

        ArrayList<Employee> employeesByProject = new ArrayList<>();


        for (Employee employee : employees) {
            for (Object project : employee.getProjects()) {

            }
        }

        return null;
    }
}
