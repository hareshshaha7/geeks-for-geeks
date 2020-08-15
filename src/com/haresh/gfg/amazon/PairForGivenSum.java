package com.haresh.gfg.amazon;

import java.util.Arrays;

/*
	Print all pairs with given sum

	Given an array of integers, and a number ‘sum’, print all pairs in the array whose sum is equal to ‘sum’.
	
	Examples :
	Input  :  arr[] = {1, 5, 7, -1, 5}, 
	          sum = 6
	Output : (1, 5) (7, -1) (1, 5)
	
	Input  :  arr[] = {2, 5, 17, -1}, 
	          sum = 7
	Output :  (2, 5)
 */

public class PairForGivenSum {

	public static void pairedElements(int arr[], int sum) {
		// First sort the array in order
		Arrays.sort(arr);
		
		int low = 0;
		int high = arr.length - 1;

		while (low < high) {
			if (arr[low] + arr[high] == sum) {
				System.out.println("The pair is : (" + arr[low] + ", " + arr[high] + ")");
			}
			if (arr[low] + arr[high] > sum) {
				high--;
			} else {
				low++;
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, -2, 6, 8, 9, 11 };
		pairedElements(arr, 6);
	}

}
