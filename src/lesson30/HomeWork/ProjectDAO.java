package lesson30.HomeWork;

import java.util.ArrayList;
import java.util.List;

public class ProjectDAO {
    private static List<Project> projects;

    public static List<Project> getProjects() {
        return projects;
    }

    public static void setProjects(List<Project> projects) {
        ProjectDAO.projects = projects;
    }

    public static ArrayList<Project> projectsByEmployee(Employee employee){
        ArrayList<Project> projectsByEmployee = new ArrayList<>();

        for (Project project: projects) {
            if (project.equals(employee.getProjects())) projectsByEmployee.add(project);
        }


        return projectsByEmployee;
    }

    public static ArrayList<Project> projectsByCustomer(Customer customer){
        ArrayList<Project> projectsByCustomer = new ArrayList<>();

        for (Project pr: projects) {
            if (pr.getCustomer().equals(customer))projectsByCustomer.add(pr);
        }


        return projectsByCustomer;

    }
}
