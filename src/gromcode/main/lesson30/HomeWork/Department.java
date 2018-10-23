package gromcode.main.lesson30.HomeWork;

import java.util.Collection;

public class Department {
    private Collection employees;
    private DepartmentType type;

    public Department(Collection employees, DepartmentType type) {
        this.employees = employees;
        this.type = type;
    }

    public Collection getEmployees() {
        return employees;
    }

    public DepartmentType getType() {
        return type;
    }
}
