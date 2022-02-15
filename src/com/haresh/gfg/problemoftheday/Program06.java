package com.haresh.gfg.problemoftheday;

/*
    Anagram of String
    Basic Accuracy: 49.25% Submissions: 29025 Points: 1

    Given two strings S1 and S2 in lowercase, the task is to make them anagram. The only allowed operation is to remove a character from any string. Find the minimum number of characters to be deleted to make both the strings anagram. Two strings are called anagram of each other if one of them can be converted into another by rearranging its letters.

    Example 1:
    Input:
        S1 = bcadeh
        S2 = hea
    Output: 3
    Explanation: We need to remove b, c and d from S1.

    Example 2:
    Input:
        S1 = cddgk
        S2 = gcd
    Output: 2
    Explanation: We need to remove d and k from S1.

    Your Task:
    Complete the function remAnagram() which takes two strings S1, S2 as input parameter, and returns minimum characters needs to be deleted.

    Expected Time Complexity: O(max(|S1|, |S2|)), where |S| = length of string S.
    Expected Auxiliary Space: O(26)

    Constraints: 1 <= |S1|, |S2| <= 105
 */

/**
 * @author Haresh Shaha
 * @since 15-Feb-2022
 */
public class Program06 {
    public static void main(String[] args) {
        String s1 = "bcadeh", s2 = "hea";
        int additionalChars = remAnagrams(s1, s2);
        System.out.println(additionalChars);
    }

    public static int remAnagrams(String s1, String s2) {
        // add code here.
        int[] s1Map = new int[26];

        for (char ch : s1.toCharArray()) {
            s1Map[ch - 'a']++;
        }

        for (char ch : s2.toCharArray()) {
            s1Map[ch - 'a']--;
        }

        int additionalChars = 0;
        for (int i = 0; i < 26; i++) {
            additionalChars += Math.abs(s1Map[i]);
        }

        return additionalChars;
    }
}
