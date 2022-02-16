package com.haresh.gfg.problemoftheday;

/*
    Find rectangle with corners as 1
    Medium Accuracy: 77.61% Submissions: 3993 Points: 4

    Given a NxM binary matrix consisting of 0s and 1s. Find if there exists a rectangle/ square within the matrix
    whose all four corners are 1.

    Example 1:
    Input:
        N = 4, M = 5
        matrix[][] =
        {
            {1 0 0 1 0},
            {0 0 1 0 1},
            {0 0 0 1 0},
            {1 0 1 0 1}
        }

    Output: Yes
    Explanation:
    Valid corners are at index (1,2), (1,4), (3,2), (3,4)

    Example 2:
    Input:
        N = 3, M = 3
        matrix[][] =
        {{0 0 0},
        {0 0 0},
        {0 0 0}}
    Output: No

    Your Task:
    You don't need to take input or print anything. Complete the function ValidCorners() that takes the given matrix as input parameter
    and returns a boolean value.

    Constraints:
        1 <= R, C <= 200
        0 <= A[i] <= 1
 */

/**
 * @author Haresh Shaha
 * @since 16-Feb-2022
 */
public class Program07 {
    public static void main(String[] args) {
        int[][] matrix =
                {
                        {1, 0, 0, 1, 0},
                        {0, 0, 1, 0, 1},
                        {0, 0, 0, 1, 0},
                        {1, 0, 1, 0, 1}
                };

        boolean hasRectangleWithCorner = validCorner(matrix);
        System.out.println(hasRectangleWithCorner);
    }

    public static boolean validCorner(int[][] matrix) {
        // Your code goes here
        int m = matrix.length;
        int n = matrix[0].length;

        for (int col1 = 0; col1 < n; col1++) {
            for (int col2 = col1 + 1; col2 < n; col2++) {

                int count = 0;
                for (int[] ints : matrix) {
                    if (ints[col1] == 1 && ints[col2] == 1) {
                        count++;
                    }
                }

                if (count > 1)
                    return true;
            }
        }

        return false;
    }
}
