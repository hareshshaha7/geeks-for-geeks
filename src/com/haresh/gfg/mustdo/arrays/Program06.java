package com.haresh.gfg.mustdo.arrays;

/*
    Rotate Array
    Easy Accuracy: 50.28% Submissions: 96392 Points: 2

    Given an unsorted array arr[] of size N. Rotate the array to the left (counter-clockwise direction) by D steps,
    where D is a positive integer.

    Example 1:
    Input:
    N = 5, D = 2
    arr[] = {1,2,3,4,5}
    Output: 3 4 5 1 2
    Explanation: 1 2 3 4 5  when rotated
        by 2 elements, it becomes 3 4 5 1 2.

    Example 2:
    Input:
    N = 10, D = 3
    arr[] = {2,4,6,8,10,12,14,16,18,20}
    Output: 8 10 12 14 16 18 20 2 4 6
    Explanation: 2 4 6 8 10 12 14 16 18 20
        when rotated by 3 elements, it becomes
        8 10 12 14 16 18 20 2 4 6.

    Your Task:
    Complete the function rotateArr() which takes the array, D and N as input parameters and rotates the array by D elements. The array must be modified in-place without using extra space.

    Expected Time Complexity: O(N)
    Expected Auxiliary Space: O(1)

    Constraints:
        1 <= N <= 106
        1 <= D <= 106
        0 <= arr[i] <= 105
 */

/**
 * @author Haresh Shaha
 * @since 14-Feb-2022
 */
public class Program06 {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int n = 10, d = 3;

        System.out.println("Original: ");
        printArray(arr);

        System.out.println();
        rotateArr(arr, d, n);
        System.out.println("Rotated: ");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void rotateArr(int[] arr, int d, int n) {
        // add your code here
        d= d%n;
        if (d == 0)
            return;

        int left = 0;
        int right = d;
        while (left < n && right >= left) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            printArray(arr);
            System.out.println();

            left++;
            if (right < n-1)
                right++;
            else if (d>=n/2)
                right=d;
            else if (d>0 && right ==n-1&& left == n) {
                System.out.println("-----");
                left = n-d;
                d--;
            }


        }
    }
}
// 2 4 6 8 10 12 14 16 18 20
// 4 6 8 10 12 14 16 18 20 2
// 6 8 10 12 14 16 18 20 2 4
// 8 10 12 14 16 18 20 2 4 6

// 2 4 6 8 10 12 14 16 18 20
// 8 4 6 14 10 12 2 16 18 20
// 8 10 6 14 16 12 2 4 18 20
// 8 10 12 14 16 18 2 4 6 20

// 8 10 12 14 16 18 20 2 4 6


//  16 18 20 2 4 6 14 8 10 12