package com.haresh.gfg.amazon;

/*
	Count number of occurrences (or frequency) in a sorted array
	
	Given a sorted array arr[] and a number x, write a function that counts the occurrences of x in arr[]. Expected time complexity is O(Logn)
	
	Examples:
	
	  Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 2
	  Output: 4 // x (or 2) occurs 4 times in arr[]
	
	  Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 3
	  Output: 1 
	
	  Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 1
	  Output: 2 
	
	  Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 4
	  Output: -1 // 4 doesn't occur in arr[] 
 */

public class CountNumberOfOccurrences {
	public static void main(String args[]) {
		int arr[] = { 1, 2, 2, 2, 2, 3, 4, 7, 8, 8 };
		int n = arr.length;
		int x = 30;
		System.out.println(countOccurrences(arr, n, x));
	}

	private static int countOccurrences(int[] arr, int n, int x) {
		int pos = findNumber(arr, 0, n - 1, x);
		if (pos == -1)
			return 0;

		int count = 1;
		boolean lflag = true, rflag = true;
		int lindex = pos, rindex = pos;
		while (lflag || rflag) {
			if (lindex > 0 && arr[lindex - 1] == x) {
				count++;
				lindex--;
			} else
				lflag = false;

			if (rindex < n - 1 && arr[rindex + 1] == x) {
				count++;
				rindex++;
			} else
				rflag = false;
		}
		return count;
	}

	private static int findNumber(int[] arr, int l, int r, int key) {
		if (r < l)
			return -1;

		int m = (l + r) / 2;
		if (arr[m] == key)
			return m;

		if (key < arr[m])
			return findNumber(arr, l, m - 1, key);
		else
			return findNumber(arr, m + 1, r, key);
	}
}
