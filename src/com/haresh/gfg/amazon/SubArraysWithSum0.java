package com.haresh.gfg.amazon;

import java.util.ArrayList;
import java.util.HashMap;

/*
	Print all subarrays with 0 sum

	Given an array, print all subarrays in the array which has sum 0.
	
	Examples:
	
	Input:  arr = [6, 3, -1, -3, 4, -2, 2,
	             4, 6, -12, -7]
	Output:  
	Subarray found from Index 2 to 4
	Subarray found from Index 2 to 6          
	Subarray found from Index 5 to 6
	Subarray found from Index 6 to 9
	Subarray found from Index 0 to 10
	
	A better approach is to use Hashing.

	Do following for each element in the array
	
	- Maintain sum of elements encountered so far in a variable (say sum).
	- If current sum is 0, we found a subarray starting from index 0 and ending at index current index
	- Check if current sum exists in the hash table or not.
	- If current sum already exists in the hash table then it indicates that this sum was the sum of some sub-array elements arr[0]…arr[i] and now the same sum is obtained for the current sub-array arr[0]…arr[j] which means that the sum of the sub-array arr[i+1]…arr[j] must be 0.
	- Insert current sum into the hash table
 */

class Pair {
	int first;
	int second;

	public Pair(int first, int second) {
		super();
		this.first = first;
		this.second = second;
	}
}

public class SubArraysWithSum0 {

	public static void main(String[] args) {
		int[] arr = { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
		int n = arr.length;

		ArrayList<Pair> out = findSubArrays(arr, n);

		// if we did not find any subarray with 0 sum,
		// then subarray does not exists
		if (out.size() == 0)
			System.out.println("No subarray exists");
		else
			System.out.println(out);
	}

	// Function to print all subarrays in the array which
	// has sum 0
	private static ArrayList<Pair> findSubArrays(int[] arr, int n) {
		// create an empty map
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

		// create an empty vector of pairs to store
		// subarray starting and ending index
		ArrayList<Pair> pairList = new ArrayList<Pair>();

		// Maintains sum of elements so far
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			// add current element to sum
			sum += arr[i];

			// if sum is 0, we found a subarray starting
			// from index 0 and ending at index i
			if (sum == 0)
				pairList.add(new Pair(0, i));

			ArrayList<Integer> al = new ArrayList<Integer>();

			// If sum already exists in the map there exists
			// at-least one subarray ending at index i with
			// 0 sum
			if (map.containsKey(sum)) {
			
				// map[sum] stores starting index of all subarrays
				al = map.get(sum);
				for (int j = 0; j < al.size(); j++) {
					pairList.add(new Pair(al.get(j) + 1, i));
				}
			}
			al.add(i);
			map.put(sum, al);
		}

		return pairList;
	}

}
