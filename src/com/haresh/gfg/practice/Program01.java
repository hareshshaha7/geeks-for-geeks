package com.haresh.gfg.practice;

/*
	Mario and the princess
	Mario is a very determined warrior, and once again he is on a mission to save the princess of his kingdom.
	But this time, he has a very different path to follow. There are set of blocks with varying heights(possibly zero) upon which he has to jump to reach the princess.
	Mario somehow crossed the blocks, but now there is one more hurdle he has to pass.
	The enemy is very cunning, and he asked Mario a question and if he answers it correctly, Mario will get the princess with no harm.
	He asked, out of all the non-increasing and non-decreasing paths possible from the side he came from(left to right) which would be maximum in length?
	
	For e.g. [0,1,2,1,3]
	Here, there are exactly ten paths that are either non increasing or non decreasing.
		0 (length=1)
		1 (length=1)
		2 (length=1)
		1 (length=1)
		3 (length=1)
		0->1 (length=2)
		0->1->2 (length=3)
		1->2 (length=2)
		2->1 (length=2)
		1->3 (length=2)
	Note: A path can be started from any block.
	Here the answer would be 3, which is 7th path since it is maximum length i.e. 3, out of all possible non-decreasing and non-increasing paths.
	Since Mario is only a warrior, he is asking you to solve this problem for him.
	
	Input:	
		First-line contains a single integer T - denoting the number of test cases then for every test case in T,
		A single integer N denoting the number of blocks.
		The next line contains N space-separated integers.
	
	Output:
		Each test should output Maximum non-increasing or non-decreasing path length in a new line.
	
	Note:
		1. for hill point, the point would be counted in both slopes, e.g. [1,2,1] here the paths are 1->2, 2->1, 2<-1, 1<-2
		2. The paths asked are non-increasing and non-decreasing which means 1->2->2 is a non-decreasing path(from left) and similarly 1<-2<-2 is non-increasing(from right).
	
	Constraints:
		1<=T<=10
		1<=N<=1e5
		0<=Block[i]<=1e9
	
	Sample Input:
		2
		5
		0 1 2 1 3
		2
		1 2
	
	Sample output:
		3
		2

	Explanation:
		Given in the problem statement.
		In the second test case, the maximum non-decreasing length is 2, which is 1->2.
	
	Sample Input:
		2
		3
		6 8 1 
		4
		2 3 9 1 
	
	Sample output:
		2
		3

	Sample Input:
		3
		4
		7 4 0 1 
		5
		7 4 8 6 7 
		6
		8 1 5 6 6 4 
	
	Sample output:
		3
		2
		4
 */

import java.util.*;

class Program01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int last = 0;
			int maxIncreasing = 0;
			int maxDecreasing = 0;

			int increasing = 0;
			int decreasing = 0;

			for (int j = 0; j < n; j++) {
				int current = sc.nextInt();

				if (j != 0) {
					if (last < current) {
						increasing++;
						decreasing = 0;
					} 
					else if (last > current) {
						decreasing++;
						increasing = 0;
					} 
					else {
						increasing++;
						decreasing++;
					}
				}

				if (maxDecreasing < decreasing)
					maxDecreasing = decreasing;
				if (maxIncreasing < increasing)
					maxIncreasing = increasing;
				last = current;
			}

			if (maxIncreasing < maxDecreasing)
				System.out.println(maxDecreasing + 1);
			else
				System.out.println(maxIncreasing + 1);
		}

	}
}