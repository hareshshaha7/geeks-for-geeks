package com.haresh.gfg.problemoftheday;

/*
    [Easy] Reverse a string using Stack
    https://practice.geeksforgeeks.org/problems/reverse-a-string-using-stack/1

    You are given a string S, the task is to reverse the string using stack.

    Example 1:
    Input: S="GeeksforGeeks"
    Output: skeeGrofskeeG

    Your Task:
    You don't need to read input or print anything. Your task is to complete the function reverse()
    which takes the string S as an input parameter and returns the reversed string.

    Expected Time Complexity: O(N)
    Expected Auxiliary Space: O(N)

    Constraints: 1 ≤ length of the string ≤ 100
 */

import java.util.Stack;

/**
 * @author Haresh Shaha
 * @since 08-Mar-2022
 */
public class Program09 {
    public static void main(String[] args) {
        String s = "GeeksforGeeks";
        String reversed = reverse(s);
        System.out.println(reversed);
    }

    public static String reverse(String s) {
        //code here
        if (s.length() < 2)
            return s;

        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            stack.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
