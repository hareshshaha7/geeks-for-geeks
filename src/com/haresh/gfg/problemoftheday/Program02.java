package com.haresh.gfg.problemoftheday;

/*
    Find Prime numbers in a range
    Medium Accuracy: 78.27% Submissions: 4369 Points: 4

    Given two integers M and N, generate all primes between M and N.

    Example 1:
    Input: M=1,N=10
    Output: 2 3 5 7
    Explanation:
        The prime numbers between 1 and 10
        are 2,3,5 and 7.

    Example 2:
    Input: M=2, N=5
    Output: 2,3,5
    Explanation:
        The prime numbers between 2 and 5 are
        2,3 and 5.

    Your Task:
    You don't need to read input or print anything. Your task is to complete the function primeRange() which takes 2 integer inputs M and N and returns a list of all primes between M and N.

    Expected Time Complexity:O(N*sqrt(N))
    Expected Auxillary Space:O(1)

    Constraints: 1<=M<=N<=106
 */

import java.util.ArrayList;

/**
 * @author Haresh Shaha
 * @since 08-Feb-2022
 */
public class Program02 {
    public static void main(String[] args) {
        int m = 2, n = 5;
        ArrayList<Integer> result = primeRange(m, n);
        System.out.println(result);
    }

    public static ArrayList<Integer> primeRange(int m, int n) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = m; i <= n; i++) {
            if (isPrime(i))
                result.add(i);
        }
        return result;
    }

    public static boolean isPrime(int num) {
        if (num == 1)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
