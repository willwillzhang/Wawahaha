package com.audiable;

import java.util.Arrays;

public class FindMissingNumberFromSequenceArray {

	public static int findMissingNumber(int[] inputArr){
		
		if(inputArr == null)
			return -1;

		Arrays.sort(inputArr);
	  
		int expectedSumVal = inputArr[inputArr.length-1] * (inputArr[0]+inputArr[inputArr.length-1])/2;
		int sum = 0;
		int i = 0;
		
		while(i<inputArr.length){
			sum+= inputArr[i];
			i++;
		}
		
		return expectedSumVal - sum;
	}
	
	public static void main(String[] args){
		int[] arr = {1,2,4};
		System.out.println(findMissingNumber(arr));
	}
			
}
