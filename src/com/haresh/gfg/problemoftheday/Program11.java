package com.haresh.gfg.problemoftheday;

/*
    Height Using Parent Array
    Medium Accuracy: 77.67% Submissions: 3349 Points: 4
    https://practice.geeksforgeeks.org/problems/height-using-parent-array4103/1#

    Given a parent array arr[] of a binary tree of N nodes. Element at index i in the array arr[] represents the parent of ith node,
    i.e, arr[i] = parent(i). Find the height of this binary tree.

    Note: There will be a node in the array arr[], where arr[i] = -1, which means this node is the root of binary tree.

    Example 1:
    Input: N = 7
    arr = {-1, 0, 0, 1, 1, 3, 5}
    Output: 5
    Explanation: Tree formed is:
                        0
                       / \
                      1   2
                     / \
                    3   4
                   /
                  5
                 /
                6      Height of the tree= 5
    Your Task:
    You do not need to read input or print anything. Your task is to complete the function findHeight()
    which takes N and arr[] as input parameters and returns the height of the given binary tree.

    Expected Time Complexity: O(N*N)
    Expected Auxiliary Space: O(1)

    Constraints:
        1 ≤ N ≤ 104
        0 ≤ arr[i] ≤ 104
 */

/**
 * @author Haresh Shaha
 * @since 11-Mar-2022
 */
public class Program11 {
    public static void main(String[] args) {
        int n = 7;
        int[] arr = {-1, 0, 0, 1, 1, 3, 5};
        int height = findHeight(n, arr);
        System.out.println(height);
    }

    static int findHeight(int n, int[] arr) {
        // code here
        int height = 1;
        int parent = arr[n - 1];

        while (parent != -1) {
            height++;
            parent = arr[parent];
        }

        return height;
    }
}
