package com.haresh.gfg.practice;

/*
    Oracle Interview Question JAN 2022

    Scenario: We have employee with various hierarchy.
    e.g.        CEO
               /   \
        Manager1    Manager2
                    /       \
            Employee1       Employee2

    1. Add employee
    2. Given the employee id find the reporting employees
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program10 {
    static class Employee {
        private int id;
        private String name;
        private String desi;

        private final Map<Integer, List<Employee>> relationship = new HashMap<>();

        public Employee(int id, String name, String desi) {
            this.id = id;
            this.name = name;
            this.desi = desi;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesi() {
            return desi;
        }

        public void setDesi(String desi) {
            this.desi = desi;
        }

        public void assignEmployee(Employee e2) {
            List<Employee> repor = relationship.getOrDefault(this.getId(), new ArrayList<>());
            repor.add(e2);
            relationship.put(this.getId(), repor);
        }

        public List<Employee> getAssignee() {
            return relationship.get(this.id);
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", desi='" + desi + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(1, "A", "CEO");
        Employee e2 = new Employee(2, "B", "MANAGER1");
        Employee e3 = new Employee(3, "C", "MANAGER2");
        Employee e4 = new Employee(4, "D", "EMP1");
        Employee e5 = new Employee(5, "E", "EMP2");

        e1.assignEmployee(e2);
        e1.assignEmployee(e3);
        e3.assignEmployee(e4);
        e3.assignEmployee(e5);

        List<Employee> list = e1.getAssignee();
        for (Employee e : list)
            System.out.println(e);
    }
}