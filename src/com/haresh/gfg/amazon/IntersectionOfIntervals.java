package com.haresh.gfg.amazon;

/*
	Find intersection of intervals given by two lists
	
	Given two 2-D arrays which represent intervals. 
	Each 2-D array represents a list of intervals. 
	Each list of intervals is disjoint and sorted in increasing order. 
	Find the intersection or set of ranges that are common to both the lists.
	
	Disjoint means no element is common in a list. Example: {1, 4} and {5, 6} are disjoint while {1, 4} and {2, 5} are not as 2, 3 and 4 are common to both intervals. 
	
	Examples: 
	
	Input: arr1[][] = {{0, 4}, {5, 10}, {13, 20}, {24, 25}} 
	arr2[][] = {{1, 5}, {8, 12}, {15, 24}, {25, 26}} 
	Output: {{1, 4}, {5, 5}, {8, 10}, {15, 20}, {24, 24}, {25, 25}}
	Explanation: 
	{1, 4} lies completely within range {0, 4} and {1, 5}. Hence, {1, 4} is the desired intersection. Similarly, {24, 24} lies completely within two intervals {24, 25} and {15, 24}.
	
	Input: arr1[][] = {{0, 2}, {5, 10}, {12, 22}, {24, 25}} 
	arr2[][] = {{1, 4}, {9, 12}, {15, 24}, {25, 26}} 
	Output: {{1, 2}, {9, 10}, {12, 12}, {15, 22}, {24, 24}, {25, 25}} 
	Explanation: 
	{1, 2} lies completely within range {0, 2} and {1, 4}. Hence, {1, 2} is the desired intersection. Similarly, {12, 12} lies completely within two intervals {12, 22} and {9, 12}. 
 */

public class IntersectionOfIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[][] = { { 0, 2 }, { 5, 10 }, { 12, 22 }, { 24, 25 } };
		int arr2[][] = { { 1, 4 }, { 9, 12 }, { 15, 24 }, { 25, 26 } };
		intersectionOfIntervals(arr1, arr2);

	}

	private static void intersectionOfIntervals(int[][] arr1, int[][] arr2) {
		// i and j pointers for arr1 and arr2 respectively
		int i = 0, j = 0;
		int x = arr1.length, y = arr2.length;

		// Loop through all intervals unless
		// one of the interval gets exhausted
		while (i < x && j < y) {
			// Left bound for intersecting segment
			int min = Math.max(arr1[i][0], arr2[j][0]);

			// Right bound for intersecting segment
			int max = Math.min(arr1[i][1], arr2[j][1]);

			// If segment is valid print it
			if (min <= max)
				System.out.println("{" + min + ", " + max + "}");

			// If i-th interval's right bound is
			// smaller increment i else increment j
			if (arr1[i][1] < arr2[j][1])
				i++;
			else
				j++;
		}
	}
}
