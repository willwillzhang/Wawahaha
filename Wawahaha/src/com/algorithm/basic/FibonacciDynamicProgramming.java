package com.algorithm.basic;

/**
 * 
 * Time Complexity: O(n)
 * Extra Space: O(n)
 * 
 *
 */
public class FibonacciDynamicProgramming {

	public static int fibanacci(int n){
		int[] memorize = new int[n+1];
		
		if(n>1){
			memorize[0] = 0;
			memorize[1] = 1;
		}else{
			return 0;
		}
		
		for(int i=2;i<=n;i++){
			memorize[i] = memorize[i-1] + memorize[i-2];
		}
		
		return memorize[n];
	}
	
	public static void main(String[] args){
		
		int n = 9;
		System.out.println(fibanacci(n));
	}
	
}
