package org.example;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableDepartment {
    private final String name;
    private final List<String> employees;

    public ImmutableDepartment (String name, List<String> employees) {
        this.name = name;
        this.employees = new ArrayList<>(employees);
    }

    public List<String> getEmployees() {
        return List.copyOf(employees);
    }

    public ImmutableDepartment addEmployee(String newEmployee) {
        List<String> updatedList = new ArrayList<>(this.employees);
        updatedList.add(newEmployee);
        return new ImmutableDepartment(this.name, updatedList);
    }

    @Override
    public String toString() {
        return "Department: " + name + ", Employees: " + employees;
    }

}