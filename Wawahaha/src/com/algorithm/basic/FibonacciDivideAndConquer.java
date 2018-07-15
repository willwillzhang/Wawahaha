package com.algorithm.basic;
/**
 * 
 * The Fibanacci numbers are the numbers in the following integer sequence.

	0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 141, ……..
 * 
 * http://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 *
 */
public class FibonacciDivideAndConquer {

	public static int fibonacci(int n){
		if(n<=1){
			//0,1,1,2...., so will return 0 and 1
			return n;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	public static void main(String[] args){
		int n = 9;
		for(int i =0;i<=n;i++){
			System.out.println(fibonacci(i));
		}
	}
}

//Extra Space: O(n) if we consider the function call stack size, otherwise O(1).