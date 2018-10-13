package andi.com;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String name;
    private List<Employee> employeeList;

    public Department(String name) {
        this.name = name;
        employeeList = new ArrayList<>();
    }

    public void addEmployee (Employee employee) {
        this.employeeList.add(employee);
    }

    public List<Employee> getEmployee() {
        return this.employeeList;
    }

}
