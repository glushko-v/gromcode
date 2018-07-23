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

    public static ArrayList<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) {

        ArrayList<Employee> employeesByDepartmentWithoutProject = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee.getDepartment().getType().equals(departmentType) && employee.getProjects().isEmpty()) {
                employeesByDepartmentWithoutProject.add(employee);
            }
        }


        return null;
    }

    public static ArrayList<Employee> employeesByTeamLead(Employee lead) {


        ArrayList<Employee> employeesByTeamLead = new ArrayList<>();
        Department departmentOfTeamLead = null;

        for (Employee employee : employees) {
            if (employee.getPosition().equals(lead)) {
                departmentOfTeamLead = employee.getDepartment();
            }
        }

        for (Employee employee : employees) {
            if (employee.getDepartment().equals(departmentOfTeamLead)) {
                employeesByTeamLead.add(employee);
                break;
            }
        }


        return employeesByTeamLead;

    }

    public static ArrayList<Employee> employeesByProjectEmployee(Employee employee) {
        ArrayList<Employee> employeesByProjectEmployee = new ArrayList<>();

        for (Employee em : employees) {
            if (em.getProjects().equals(employee.getProjects())) {
                employeesByProjectEmployee.add(em);
                break;
            }
        }

        return employeesByProjectEmployee;
    }

    public static ArrayList<Employee> employeesByCustomerProject(Customer customer) {
        ArrayList<Employee> employeesByCustomerProject = new ArrayList<>();

        for (Employee employee : employees) {
            for (Project project : employee.getProjects()) {
                if (project.getCustomer().equals(customer)) {
                    employeesByCustomerProject.add(employee);
                    break;
                }
            }
        }


        return employeesByCustomerProject;
    }

    public static ArrayList<Employee> teamLeadByEmployee(Employee employee) {
        ArrayList<Employee> teamLeadByEmployee = new ArrayList<>();


        for (Employee em : employees) {
            for (Project project : em.getProjects()) {
                if (em.getProjects().equals(employee.getProjects()) && em.getPosition().equals(Position.TEAM_LEAD)) {
                    teamLeadByEmployee.add(em);
                    break;
                }
            }
        }


        return teamLeadByEmployee;
    }






}
