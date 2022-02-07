package com.haresh.gfg.google;

/*
    Frequency Game
    Easy Accuracy: 73.44% Submissions: 7776 Points: 2

    Given an array A of size N. The elements of the array consists of positive integers. You have to find the largest element with minimum frequency.

    Input Format: First line of input contains number of testcases T. For each testcase there will be two lines.
    First line contains N, next line contains N elements separated by spaces.

    Output Format: For each testcase, print the largest element with minimum frequency.

    User Task:
    Your task is to complete the provided function LargButMinFreq(A, n) which accepts array A and n.
    Hence you have to return the largest element with minimum frequency.

    Constraints:
        1 <= T <= 100
        1 <= N <= 105
        1 <= A[i] <= 106

    Example:
    Input:
        1
        5
        2 2 5 50 1
    Output: 50

    Explanation :
    Testcase 1: All elements are having frequency 1 except 2. 50 is the maximum element with minimum frequency.

    Note: use HashMap to compute the element and its frequency.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author Haresh Shaha
 * @since 08-Feb-2022
 */
public class Program02 {
    public static void main(String[] args) {
        int[] arr = {2, 2, 5, 50, 1};
        int result = LargeButMinFreq(arr, arr.length);
        System.out.println(result);
    }

    // Function to find largest number with minimum frequency
    public static int LargeButMinFreq(int[] arr, int n) {
        // Your code here
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }

        int minFreq = Integer.MAX_VALUE;
        int result = 0;
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            if (e.getValue() < minFreq) {
                minFreq = e.getValue();
            }
            if (minFreq == e.getValue() && result < e.getKey()) {
                result = e.getKey();
            }
        }

        return result;
    }
}
