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

        System.out.println("Array before Rotation: ");
        printArray(arr);
        rotate1(arr, d, n);
        System.out.println("\nArray after Rotation: ");
        printArray(arr);

        System.out.println("\n\nArray before Rotation: ");
        int[] arr1 = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        printArray(arr1);
        rotate2(arr1, d, n);
        System.out.println("\nArray after Rotation: ");
        printArray(arr1);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    // Solution with extra space
    public static void rotate1(int[] nums, int d, int n) {
        if (nums.length < 2)
            return;

        d = d % n;
        if (d == 0)
            return;

        int index = d;
        int[] result = new int[n];
        int i = 0;
        while (index < n) {
            result[i++] = nums[index++];
        }

        index = 0;
        while (index < d) {
            result[i++] = nums[index++];
        }

        for (i = 0; i < n; i++) {
            nums[i] = result[i];
        }
    }


    /**
     * The basic idea is that,
     * for example, nums = [1,2,3,4,5,6,7] and d = 3, n = 7
     * first we reverse [1,2,3,4], it becomes[4,3,2,1];
     * then we reverse[5,6,7], it becomes[7,6,5],
     * finally we reverse the array as a whole, it becomes[4,3,2,1,7,6,5] ---> [5,6,7,1,2,3,4].
     * <p>
     * Reverse is done by using two pointers, one point at the head and the other point at the tail,
     * after switch these two, these two pointers move one position towards the middle.
     */
    public static void rotate2(int[] nums, int d, int n) { // Without using extra space
        if (nums.length < 2)
            return;

        d = d % n;
        if (d == 0)
            return;

        reverse(nums, 0, d - 1);
        reverse(nums, d, n - 1);
        reverse(nums, 0, n - 1);
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}
