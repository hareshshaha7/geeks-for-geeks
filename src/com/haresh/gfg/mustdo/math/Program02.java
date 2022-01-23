package com.haresh.gfg.mustdo.math;

/*
    Trailing zeroes in factorial
    Easy Accuracy: 52.7% Submissions: 44304 Points: 2
    For an integer N find the number of trailing zeroes in N!.

    Example 1:
    Input:
    N = 5
    Output: 1
    Explanation:
        5! = 120 so the number of trailing zero is 1.

    Example 2:
    Input:
    N = 4
    Output: 0
    Explanation:
        4! = 24 so the number of trailing zero is 0.

    Your Task:
        You don't need to read input or print anything. Your task is to complete the function trailingZeroes()
        which take an integer N as an input parameter and returns the count of trailing zeroes in the N!.
        Expected Time Complexity: O(logN)
        Expected Auxiliary Space: O(1)

    Constraints:
        1 <= N <= 109
 */

/**
 * @author Haresh Shaha
 * @since 23-Jan-2022
 */
public class Program02 {
    public static void main(String[] args) {
        int n = 10;
        int trailingZeroes = trailingZeroes(n);
        System.out.println(trailingZeroes);
    }

    static int trailingZeroes(int n) {
        // Write your code here

        // Slower approach NOT EXPECTED
        // long factorial = 1;
        // for (int i=2; i<=n; i++) {
        //     factorial *= i;
        // }

        // int trailingZeroes = 0;
        // while (factorial % 10 == 0) {
        //     trailingZeroes++;
        //     factorial/=10;
        // }

        // Trick is we will have new zero only if number is divided by 5
        // e.g. for 5 we will have 1 zero
        // for 10 we will have 2 zeros (10/5 = 2)
        // for 25 we will have 6 zeros (25/5 = 5 + 5/5 = 1 == 6)
        int trailingZeroes = 0;
        while (n != 0) {
            trailingZeroes += n / 5;
            n = n / 5;
        }
        return trailingZeroes;
    }
}
