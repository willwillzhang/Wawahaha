package com.audiable;

import java.util.Arrays;

/**
 * Simple examples of search a duplicate algorithms, the array just exists only one repeated number.
 *
 */
public class SearchRepeatedNum {

	/**
	 * Searches for only one duplicate in array.
	 * @param array
	 * @return 0 if it is not found.
	 */
	public static int searchWithXOR(int[] array) {
		int dup = 0;
		int offset = 1;
		for(int i = 0; i < array.length; i++) {
			dup = dup ^ (array[i] + offset) ^ i;
		}
		return dup - offset;
	}

	/**
	 * Test
	 * @param args
	 */
	public static void main(String[] args) {
		// find iterative
		System.out.println("duplicate = " + searchWithXOR(new int[]{0,1,2,3,4,5,6,7,8,5,9}));
		findDuplicateNum(new int[]{0,1,2,3,4,5,6,7,8,5,9});
	}
	
	public static void findDuplicateNum(int[] arr){
		Arrays.sort(arr);
		for(int i = 1; i < arr.length; i++){
			if(arr[i] == arr[i-1])
				System.out.println("duplicate = " + arr[i]);
		}
	}
}