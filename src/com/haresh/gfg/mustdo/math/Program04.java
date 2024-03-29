package com.haresh.gfg.mustdo.math;

/*
    Nth Natural Number
    Hard Accuracy: 41.17% Submissions: 35935 Points: 8
    https://practice.geeksforgeeks.org/problems/nth-natural-number/1

    Given a positive integer N. You have to find Nth natural number after removing all the numbers containing digit 9.

    Example 1:
    Input:
        N = 8
    Output: 8
    Explanation:
        After removing natural numbers which contains
        digit 9, first 8 numbers are 1,2,3,4,5,6,7,8
        and 8th number is 8.

    Example 2:
    Input:
        N = 9
    Output: 10
    Explanation:
        After removing natural numbers which contains
        digit 9, first 9 numbers are 1,2,3,4,5,6,7,8,10
        and 9th number is 10.

    Your Task:
        You don't need to read input or print anything. Complete the function findNth() which accepts
        an integer N as input parameter and return the Nth number after removing all the numbers containing digit 9.

    Expected Time Complexity: O(logN)
    Expected Auxiliary Space: O(1)

    Constraints:
        1 ≤ N ≤ 1012
 */

public class Program04 {
    public static void main(String[] args) {
        long n = 9;
        long number = findNth(n);
        System.out.println(number);
    }

    public static long findNth(long n) {
        //code here
        long reminder;
        StringBuilder result = new StringBuilder();

        while (n > 0) {
            reminder = n % 9;
            result.insert(0, reminder);
            n /= 9;
        }

        return Long.parseLong(result.toString());
    }
}
