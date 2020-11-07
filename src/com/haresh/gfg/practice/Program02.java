package com.haresh.gfg.practice;

class Parent {
	public void run() {
		System.out.println("Parents are runnning..");
		walk();
	}
	
	public void walk() {
		System.out.println("Parents are walking.");
	}
}

class Child extends Parent{
	public void run() {
		System.out.println("child is runnning..");
		super.run();
	}
	
	public void walk() {
		System.out.println("Child is walking.");
	}
}

public class Program02 {

	public static void main(String[] args) {
		Parent parent = new Parent();
		parent.run();
		
		System.out.println();
		
		Child child = new Child();
		child.run();
		
		System.out.println();
		
		Parent parent2 = new Child();
		parent2.run();
	}

}
