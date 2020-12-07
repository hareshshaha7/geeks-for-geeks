package com.haresh.gfg.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Program04 {

	public static void main(String[] args) {
		Function<Integer, Integer> sqrIt = x -> x * x;
		System.out.println(sqrIt.apply(8));

		List<Integer> numList1 = new ArrayList<>();
		numList1.add(78);
		numList1.add(10);
		Function<Integer, Integer> fun = i -> i / 2;
		numList1.stream().map(fun).forEach(System.out::println);

		System.out.println();

		Predicate<Integer> isEven = x -> x % 2 == 0;
		System.out.println(isEven.test(5));

		List<Integer> numList2 = new ArrayList<Integer>();
		numList2.add(5);
		numList2.add(10);
		Predicate<Integer> pred = i -> i > 5;
		numList2.stream().filter(pred).forEach(i -> System.out.println(i));
	}
}
