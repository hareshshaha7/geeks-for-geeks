package com.haresh.gfg.google;

/*
    Generate Parentheses
    Medium Accuracy: 59.65% Submissions: 18721 Points: 4

    Given an integer N representing the number of pairs of parentheses, the task is to generate all combinations of well-formed(balanced) parentheses.

    Example 1:
    Input: N = 3
    Output:
        ((()))
        (()())
        (())()
        ()(())
        ()()()

    Example 2:
    Input: N = 1
    Output: ()

    Your Task:
    You don't need to read input or print anything. Complete the function AllParenthesis() which takes N as input parameter and returns the list of balanced parenthesis.

    Expected Time Complexity: O(2N * N).
    Expected Auxiliary Space: O(2*N*X), X = Number of valid Parenthesis.

    Constraints:
        1 ≤ N ≤ 12
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author Haresh Shaha
 * @since 08-Feb-2022
 */
public class Program03 {
    public static void main(String[] args) {
        List<String> result = AllParenthesis(3);
        System.out.println(result);
    }

    public static List<String> AllParenthesis(int n) {
        // Write your code here
        List<String> result = new ArrayList<>();
        helper(n, n, result, "");
        return result;
    }

    public static void helper(int open, int close, List<String> result, String s) {
        if (open == 0 && close == 0) {
            result.add(s);
        }

        if (open > 0) {
            helper(open - 1, close, result, s + "(");
        }
        if (open < close) {
            helper(open, close - 1, result, s + ")");
        }

    }
}
