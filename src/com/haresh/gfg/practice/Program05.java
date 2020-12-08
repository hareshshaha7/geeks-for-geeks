package com.haresh.gfg.practice;

interface Xerox {
	public void print();
}

interface XeroxMultiply {
	public void square(int num);
}

interface Multiply {
	public int square(int num);
}

interface Addition {
	public int sum(int num1, int num2);
}

public class Program05 {

	public static void main(String[] args) {
		// Java 7
		/*		
		 	class X1 implements Xerox {
				public void print() {
					System.out.println("Hello");
				}
			}
		*/

		// Java 8
		Xerox x1 = () -> System.out.println("Hello");
		x1.print();

		// Java 7
		/*
			class XMultiplication implements XeroxMultiply {
				public void square(int num) {
					System.out.println(num * num);
				}
			}
		*/

		// Java 8
		XeroxMultiply xMultiplication = (num) -> System.out.println(num * num);
		xMultiplication.square(5);

		// Java 7
		/*
			class Multiplication implements Multiply {
				public int square(int num) { 
					return num * num; 
				}
			}
		*/

		// Java 8
		Multiply multiplication1 = num -> num * num;
		System.out.println(multiplication1.square(8));
		// OR
		Multiply multiplication2 = (num) -> {
			return num * num;
		};
		System.out.println(multiplication2.square(12));
		
		// Java 7
		/*
			class Add implements Addition {
				public int sum(int num1, int num2) {
					return num1 + num2;
				}
			}
		*/

		// Java 8
		Addition add = (num1, num2) -> num1 + num2;
		System.out.println(add.sum(12, 32));
	}

}
