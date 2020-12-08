package com.haresh.gfg.practice;

//With Java 7
/*
class MyThread implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("My Thread: " + i);
		}
	}
}
*/

public class Program06 {

	public static void main(String[] args) {
		// With Java 7
		// Thread thread = new Thread(new MyThread());

		// With Java 8
		Thread thread = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("My Thread: " + i);
			}
		});
		thread.start();

		for (int i = 0; i < 10; i++) {
			System.out.println("Main Thread: " + i);
		}
	}
}
