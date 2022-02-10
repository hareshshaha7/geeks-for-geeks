package com.haresh.gfg.problemoftheday;

/*
    XOR Game
    Medium Accuracy: 57.19% Submissions: 5970 Points: 4

    Given a positive number k, we need to find a minimum value of positive integer n, such that XOR of n and n+1 is equal to k. If no such n exist then print -1.

    Example 1:
    Input: k = 3
    Output: 1
    Explaination: 1 xor 2 = 3.

    Example 2:
    Input: k = 6
    Output: -1
    Explaination: There is no such n, so that,
        n xor n+1 = k.

    Your Task:
    You do not need to read input or print anything. Your task is to complete the function xorCal() which takes k as input parameter and returns the value of n. If there is no such , then it returns -1.

    Expected Time Complexity: O(1)
    Expected Auxiliary Space: O(1)

    Constraints: 1 ≤ k ≤ 100
 */

/**
 * @author Haresh Shaha
 * @since 10-Feb-2022
 */
public class Program03 {
    public static void main(String[] args) {
        int k = 3;
        System.out.println(xorCal1(k));
        System.out.println(xorCal2(k));
    }

    public static int xorCal1(int k) {
        // code here
        if (k == 1)
            return 2;

        for (int i = 1; i < k; i++) {
            int x = (i) ^ (i + 1);
            if (x == k)
                return i;
        }
        return -1;
    }

    public static int xorCal2(int k) {
        // code here
        if (k == 1) return 2;
        return (k & (k + 1)) == 0 ? (k / 2) : -1;
    }
}
