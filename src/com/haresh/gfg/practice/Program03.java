package com.haresh.gfg.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;

/*
	Organization Structure involving employees and their manager
	1) public void addEmployee(int empId, String name, int mgrId);
	2) public Employee getManager(int empId);
	3) public List<Employee> getAllReportees(int empId);
	A is manager of B,C,D
	B is manager E,F,G
	C is manager of X,Y,Z 
	and if I call getAllReportees with id of A, it should return B,C,D,E,F,G,X,Y,Z
*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

class Employee {
	int empId;
	String name;
	int mgrId;

	public Employee(int empId, String name, int mgrId) {
		super();
		this.empId = empId;
		this.name = name;
		this.mgrId = mgrId;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", mgrId=" + mgrId + "]";
	}

}

public class Program03 {
	Map<Integer, Employee> employees = new HashMap<Integer, Employee>();

	public void addEmployee(int empId, String name, int mgrId) {
		Employee employee = new Employee(empId, name, mgrId);
		employees.put(empId, employee);
	}

	public Employee getManager(int empId) {
		Employee employee = employees.get(empId);
		if (employee != null)
			return employees.get(employee.mgrId);
		else
			return null;
	}

	public List<Employee> getAllReportees(int empId) {
		List<Employee> reportees = new ArrayList<>();
		Queue<Employee> employeesToBeVisisted = new ArrayDeque<>();
		employeesToBeVisisted.add(employees.get(empId));
		
		while (employeesToBeVisisted.size() != 0) {
			Employee employee = employeesToBeVisisted.poll();
			
			for (Entry<Integer, Employee> entry : employees.entrySet()) {
				Employee emp = entry.getValue();
		    
				if (emp.mgrId == employee.empId) {
		        	employeesToBeVisisted.add(emp);
		        	reportees.add(emp);
		        }
		    }
		}
		
		return reportees;
	}

	public static void main(String[] args) {
		Program03 program = new Program03();
		program.addEmployee(1, "A", 0);
		program.addEmployee(2, "B", 1);
		program.addEmployee(3, "C", 1);
		program.addEmployee(4, "D", 1);
		program.addEmployee(5, "E", 2);
		program.addEmployee(6, "F", 2);
		program.addEmployee(7, "G", 2);
		program.addEmployee(8, "H", 0);
		program.addEmployee(9, "X", 3);
		program.addEmployee(10, "Y", 3);
		program.addEmployee(11, "Z", 3);
		
		System.out.println("------ All Employees ----------");
		System.out.println(program.employees);
		System.out.println();
		
		System.out.println("------ Manager ----------");
		System.out.println(program.getManager(10));
		System.out.println();
		
		System.out.println("------ Reportees ----------");
		List<Employee> reportees = program.getAllReportees(1);
		for (Employee employee : reportees) {
			System.out.println(employee);
		}

	}
}
