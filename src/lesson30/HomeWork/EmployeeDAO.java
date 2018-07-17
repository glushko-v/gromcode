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


    public static ArrayList<Employee> employeesByProject(String projectName) {

        ArrayList<Employee> employeesByProject = new ArrayList<>();

        for (Employee employee : employees) {

            for (Project project : employee.getProjects()) {

                if (project != null && projectName.equals(project.getName())) {
                    employeesByProject.add(employee);
                    break;
                }

            }

        }

        return employeesByProject;
    }

    public static ArrayList<Employee> employeesWithoutProject() {

        ArrayList<Employee> employeesWithoutProject = new ArrayList<>();

        for (Employee employee : employees) {

            if (employee.getProjects().isEmpty())
                employeesWithoutProject.add(employee);
        }

        return employeesWithoutProject;
    }


}
