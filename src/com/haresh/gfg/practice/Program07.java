package com.haresh.gfg.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Program07 {
	class Employee {
		private int id;
		private String name;
		private double salary;
		
		public Employee(int id, String name, double salary) {
			this.id = id;
			this.name = name;
			this.salary = salary;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", salary="
					+ salary + "]";
		}
	}

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<Program07.Employee>();
		list.add(new Program07(). new Employee(1, "Haresh", 55000));
		list.add(new Program07(). new Employee(3, "Akash", 75000));
		list.add(new Program07(). new Employee(5, "Sanket", 50000));
		list.add(new Program07(). new Employee(4, "Prashant", 30000));
		list.add(new Program07(). new Employee(2, "Junier", 80000));
		list.add(new Program07(). new Employee(0, "xyz", 15000));
		
		
		Function<Employee, Employee> function = e -> {
			e.salary += 1000;
			return e;
		};
		Predicate<Employee> predicate = e -> e.salary > 50000;
		Consumer<Employee> consumer = e -> System.out.println(e);
		
		list.stream().map(function).filter(predicate).forEach(consumer);
		
	}

}
