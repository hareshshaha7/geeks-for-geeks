package com.haresh.gfg.google;

/*
    Find triplets with zero sum
    Basic Accuracy: 48.42% Submissions: 100k+ Points: 1

    Given an array arr[] of n integers. Check whether it contains a triplet that sums up to zero.

    Example 1:
    Input: n = 5, arr[] = {0, -1, 2, -3, 1}
    Output: 1
    Explanation: 0, -1 and 1 forms a triplet
    with sum equal to 0.

    Example 2:
    Input: n = 3, arr[] = {1, 2, 3}
    Output: 0
    Explanation: No triplet with zero sum exists.

    Your Task:
    You don't need to read input or print anything. Your task is to complete the boolean function findTriplets()
    which takes the array arr[] and the size of the array (n) as inputs and print 1
    if the function returns true else print 0 if the function returns false.

    Expected Time Complexity: O(n2)
    Expected Auxiliary Space: O(1)

    Constrains:
        1 <= n <= 104
        -106 <= Ai <= 106
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @author Haresh Shaha
 * @since 13-Feb-2022
 */
public class Program04 {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {0, -1, 2, -3, 1};
        boolean haveTriplet = findTriplets(arr, n);
        System.out.println(haveTriplet);
    }

    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
    public static boolean findTriplets(int[] arr, int n) {
        //add code here.
        for (int i = 0; i < n; i++) {
            if (twoSum(arr, i + 1, n, -arr[i])) // -arr[i] -> 0-arr[i]
                return true;
        }

        return false;
    }

    public static boolean twoSum(int[] arr, int start, int n, int sum) {
        Set<Integer> complements = new HashSet<>();
        for (int i = start; i < n; i++) {
            if (complements.contains(sum - arr[i]))
                return true;
            complements.add(arr[i]);
        }

        return false;
    }
}
