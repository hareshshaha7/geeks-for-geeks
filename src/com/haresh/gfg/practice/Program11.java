package com.haresh.gfg.practice;

/*
    Oracle Interview Question JAN 2022

    Find Second Highest
    GIVEN THE ARRAY OF INTEGERS RETURN THE SECOND HIGHEST NUMBER

    e.g.
    Input: [1,3,5,2,7]
    Output: 5

    Input: [50, 30, 40, 80, 10]
    Output: 50
 */

public class Program11 {
    public static void main(String[] args) {
        int[] numbers = new int[] {50, 30, 40, 80, 10};
        int number = getSecondHighest(numbers);
        System.out.println(number);
    }

    private static int getSecondHighest(int[] numbers) {
        int highest = 0;
        int result = 0;

        for (int number : numbers) {
            if (number > highest) {
                result = highest;
                highest = number;
            } else if (number > result) {
                result = number;
            }
        }

        return result;
    }
}