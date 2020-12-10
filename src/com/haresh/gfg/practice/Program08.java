package com.haresh.gfg.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class Program08 {
	class Employee {
		private String name;
		private double salary;

		public Employee(String name, double salary) {
			this.name = name;
			this.salary = salary;
		}

		@Override
		public String toString() {
			return "Employee [name=" + name + ", salary=" + salary + "]";
		}
	}

	public static void main(String[] args) {

		BiFunction<String, Double, Employee> function = (name, salary) -> {
			Employee e = new Program08().new Employee(name, salary);
			return e;
		};
		BiPredicate<String, Double> predicate = (name,
				salary) -> name.endsWith("sh") && salary > 50000;
		BiConsumer<String, Double> consumer = (name, salary) -> System.out
				.println("Employee [name=" + name + ", salary=" + salary + "]");

		List<Employee> list = new ArrayList<Program08.Employee>();
		list.add(function.apply("Haresh", (double) 55000));
		list.add(function.apply("Akash", (double) 75000));
		list.add(function.apply("Sanket", (double) 50000));
		list.add(function.apply("Prashant", (double) 30000));
		list.add(function.apply("Junier", (double) 80000));
		list.add(function.apply("xyz", (double) 15000));

		for (Employee employee : list) {
			if (predicate.test(employee.name, employee.salary)) {
				consumer.accept(employee.name, employee.salary);
			}
		}

	}

}
