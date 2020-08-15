package com.haresh.gfg.amazon;

/*
 * Find a pair with maximum product in array of Integers
 */

public class MaxProduct {
	 /* Driver program to test above function */
    public static void main(String[] args)  
    { 
        int arr[] = {1, 4, 3, 6, 7, 0}; 
        int n = arr.length; 
        maxProduct(arr, n); 
              
    }

	private static void maxProduct(int[] arr, int n) {
		// TODO Auto-generated method stub
		int posA = 0;
		int posB = 0;
		int negA = 0;
		int negB = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (posA < arr[i]) {
				posB = posA;
				posA = arr[i];
			}
			else if (posB < arr[i]) {
				posB = arr[i];
			}
			
			if (negA > arr[i]) {
				negB = negA;
				negA = arr[i];
			}
			else if (negB > arr[i]) {
				negB = arr[i];
			}
		}

		if ((posA * posB) > (negA * negB)) {
			System.out.println("Max product pair is {" + posA + ", " + posB + "}");
		}
		else {
			System.out.println("Max product pair is {" + negA + ", " + negB + "}");				
		}
		
	} 
}
