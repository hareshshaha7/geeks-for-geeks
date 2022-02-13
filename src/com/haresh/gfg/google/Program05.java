package com.haresh.gfg.google;

/*
    Remove duplicate elements from sorted Array
    Easy Accuracy: 46.78% Submissions: 86061 Points: 2

    Given a sorted array A[] of size N, delete all the duplicates elements from A[].
    Note: Don't use set or HashMap to solve the problem.

    Example 1:
    Input:
    N = 5
    Array = {2, 2, 2, 2, 2}
    Output: 2
    Explanation: After removing all the duplicates
        only one instance of 2 will remain.

    Example 2:
    Input:
    N = 3
    Array = {1, 2, 2}
    Output: 1 2

    Your Task:
    You don't need to read input or print anything. Complete the function remove_duplicate() which takes the array A[]
    and its size N as input parameters and modifies it in place to delete all the duplicates.
    The function must return an integer X denoting the new modified size of the array.

    Note: The generated output will print all the elements of the modified array from index 0 to X-1.

    Expected Time Complexity: O(N)
    Expected Auxiliary Space: O(1)

    Constraints:
        1 ≤ N ≤ 104
        1 ≤ A[i] ≤ 106
 */

/**
 * @author Haresh Shaha
 * @since 13-Feb-2022
 */
public class Program05 {
    public static void main(String[] args) {
        int n = 5;
        int[] array = {2, 2, 2, 2, 2};
        int newLength = removeDuplicate(array, n);
        for (int i = 0; i < newLength; i++) {
            System.out.print(array[i]);
        }
    }

    public static int removeDuplicate(int[] array, int n) {
        // code here
        if (array == null || n == 0)
            return 0;
        if (n == 1)
            return 1;

        int insertionIndex = 1;
        for (int i = 1; i < n; i++) {
            if (array[i] != array[i - 1]) {
                array[insertionIndex] = array[i];
                insertionIndex++;
            }
        }

        return insertionIndex;
    }
}
