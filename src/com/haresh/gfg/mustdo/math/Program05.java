package com.haresh.gfg.mustdo.math;

/*
    Smallest Positive Integer that can not be represented as Sum
    Hard Accuracy: 49.71% Submissions: 26042 Points: 8

    Given an array of size N, find the smallest positive integer value that cannot be represented as sum of some elements from the array.

    Example 1:
    Input:
    N = 6
    array[] = {1, 10, 3, 11, 6, 15}
    Output: 2
    Explanation:
        2 is the smallest integer value that cannot
        be represented as sum of elements from the array.

    Example 2:
    Input:
    N = 3
    array[] = {1, 1, 1}
    Output: 4
    Explanation:
        1 is present in the array.
        2 can be created by combining two 1s.
        3 can be created by combining three 1s.
        4 is the smallest integer value that cannot be
        represented as sum of elements from the array.

    Your Task:
    You don't need to read input or print anything. Complete the function smallestpositive() which takes the array and N as input parameters and returns the smallest positive integer value that cannot be represented as sum of some elements from the array.

    Expected Time Complexity: O(N * Log(N))
    Expected Auxiliary Space: O(1)

    Constraints:
        1 ≤ N ≤ 106
        1 ≤ array[i] ≤ 109
        Array may contain duplicates.
 */

import java.util.Arrays;

/**
 * @author Haresh Shaha
 * @since 09-Feb-2022
 */
public class Program05 {
    public static void main(String[] args) {
        long[] array = {1, 10, 3, 11, 6, 15};
        long nextNumber = smallestpositive(array, array.length);
        System.out.println(nextNumber);
    }

    public static long smallestpositive(long[] array, int n) {
        // Your code goes here
        Arrays.sort(array);
        if (array[0] > 1) {
            return 1;
        }

        // Calculate running sum of an array to compare
        for (int i = 1; i < array.length; i++) {
            if (array[i] - array[i - 1] > 1) {
                return array[i - 1] + 1;
            } else {
                array[i] += array[i - 1];
            }
        }
        return array[array.length - 1] + 1;
    }
}
