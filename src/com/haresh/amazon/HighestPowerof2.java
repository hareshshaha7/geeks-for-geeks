package com.haresh.amazon;

/*
 	Application Problem:
	Some people are standing in a queue. A selection process follows a rule where people standing on even positions are selected. Of the selected people a queue is formed and again out of these only people on even position are selected. This continues until we are left with one person. Find out the position of that person in the original queue.
	Print the position(original queue) of that person who is left.
	Examples :
	
	Input: n = 10
	Output:8
	Explanation : 
	1 2 3 4 5 6 7 8 9 10  ===>Given queue
	    2 4 6 8 10
	       4 8
	        8
	
	Input: n = 17
	Input: 16
	Explanation : 
	1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17  ===>Given queue
	        2 4 6 8 10 12 14 16
	            4 8 12 16
	              8 16
	               16
 */

public class HighestPowerof2 {
	static int highestPowerof2(int n) 
	{ 
	    // Invalid input 
	    if (n < 1) 
	        return 0; 
	  
	    int res = 1; 
	  
	    // Try all powers  
	    // starting from 2^1 
	    for (int i = 0; i < 8 * Integer.BYTES; i++) 
	    { 
	        int curr = 1 << i; 
	  
	        // If current power is  
	        // more than n, break 
	        if (curr > n) 
	        break; 
	  
	        res = curr; 
	    } 
	  
	    return res; 
	} 
	  
	// Driver code 
	public static void main(String[] args)  
	{ 
	    int n = 10; 
	    System.out.println(highestPowerof2(n)); 
	} 
}
