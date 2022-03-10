package com.haresh.gfg.problemoftheday;

/*
    7 Segment Display
    Medium Accuracy: 59.82% Submissions: 2789 Points: 4
    https://practice.geeksforgeeks.org/problems/7-segment-display0752/1#

    Using seven segment display, you can write down any digit from 0 to 9 using at most seven segments.
    Given a positive number N and then a string S representing a number of N digits.
    You have to rearrange the segments in this N digit number to get the smallest possible N digit number.
    This number can have leading zeros. You can not waste any segment or add any segment from your own.
    You have to use all of the segments of the given N digits.

    Note: You can refer this diagram for more details

    Example 1:
    Input:
        N = 6
        S = "234567"
    Output: 000011
    Explanation:
        234567 has a total of 28 segments and
        we can rearrange them to form 000011
        which has 28 segments too. 000011 is the
        smallest possible number which can be
        formed on rearrangement.

    Example 2:
    Input:
        N = 3
        S = "011"
    Output: 011
    Explanation:
        011 has a total of 10 segments and this
        is the smallest number with 10 segments.

    Your Task:
    You don't need to read input or print anything. Your task is to complete the function sevenSegments() which takes an Integer N and a String S of length N as input and returns the smallest possible N digit number which can be made using all of the segments given.

    Expected Time Complexity: O(N)
    Expected Auxiliary Space: O(1)

    Constraints: 1 <= N <= 104
 */

import java.util.HashMap;

public class Program10 {
    public static void main(String[] args) {
        int n = 1;
        String s = "8";
        String number = sevenSegments(s, n);
        System.out.println(number);
    }

    static String sevenSegments(String s, int n) {
        // code here
        int[] segments = {6, 2, 5, 5, 4, 5, 6, 3, 7, 5};
        int[] answer = new int[n];
        int total_segments = 0;
        for (int i = 0; i < n; i++) {
            total_segments += segments[s.charAt(i) - '0'];
        }

        for (int i = 0; i < n; i++) {
            answer[i] = 2;//inserting 1 to every position
            total_segments -= 2;
        }

        int j = 0;
        while (total_segments >= 4 && j < n) {
            answer[j] = 6;
            total_segments += 2;
            total_segments -= 6;
            j++;
        }

        answer[n - 1] += total_segments;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (answer[i] == 6) result.append('0');
            else if (answer[i] == 2) result.append('1');
            else if (answer[i] == 3) result.append('7');
            else if (answer[i] == 4) result.append('4');
            else if (answer[i] == 5) result.append('2');
            else if (answer[i] == 7) result.append('8');
            else result.append('2');
        }

        return String.valueOf(result);
    }
}
