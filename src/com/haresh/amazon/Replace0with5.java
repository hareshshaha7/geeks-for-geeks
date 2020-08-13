package com.haresh.amazon;

/*
 	Replace all ‘0’ with ‘5’ in an input Integer

	Given an integer as input and replace all the ‘0’ with ‘5’ in the integer.
	
	Examples:	
	
	Input: 102 
	Output: 152
	Explanation: All the digits which are '0' is replaced by '5' 
	
	Input: 1020 
	Output: 1525
	Explanation: All the digits which are '0' is replaced by '5' 
	
	Use of array to store all digits is not allowed.
 */

public class Replace0with5 {

    static int replace0with5(int number) 
    { 
    	// amount to be added 
        int result = 0; 
  
        // unit decimal place 
        int decimalPlace = 1; 
  
        if (number == 0) { 
            result += (5 * decimalPlace); 
        } 
  
        while (number > 0) { 
            if (number % 10 == 0) 
                // a number divisible by 10, then 
                // this is a zero occurrence in the input 
                result += (5 * decimalPlace); 
            else
            	result += ((number % 10) * decimalPlace);
  
            // move one decimal place 
            number /= 10; 
            decimalPlace *= 10; 
        } 
        return result; 
    } 
  
    public static void main(String[] args) 
    { 
        System.out.println(replace0with5(1020)); 
        /*
         	Complexity Analysis:
			Time Complexity: O(k), the loops runs only k times, where k is the number of digits of the number.
			Space Complexity: O(1), no extra space is required.
         */
        
        System.out.println(convert0To5(10120));
        /*
         	Complexity Analysis:
			Time Complexity: O(k), the recursive function is called only k times, where k is the number of digits of the number
			Space Complexity: O(1), no extra space is required.
         */
    } 
    
 
    /*
     	Algorithm:

		Check a base case when the number is 0 return 5, for all other cases form a recursive function.
		The function (solve(int n))can be defined as follows, if the number passed is 0 then return 0, else extract the last digit i.e. n = n/10 and remove the last digit. If the last digit is zero the assign 5 to it.
		Now return the value by calling the recursive function for n, i.e return solve(n)*10 + digit.
		print the answer. 
     */
    
    // A recursive function to replace all 0s with 5s in 
    // an input number. It doesn't work if input number 
    // itself is 0. 
    static int convert0To5Rec(int num) 
    { 
        // Base case 
        if (num == 0) 
            return 0; 
  
        // Extract the last digit and change it if needed 
        int digit = num % 10; 
        if (digit == 0) 
            digit = 5; 
  
        // Convert remaining digits and append the 
        // last digit 
        return convert0To5Rec(num / 10) * 10 + digit; 
    } 
  
    // It handles 0 and calls convert0To5Rec() for 
    // other numbers 
    static int convert0To5(int num) 
    { 
        if (num == 0) 
            return 5; 
        else
            return convert0To5Rec(num); 
    } 

} 
