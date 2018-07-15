package com.amazon;

public class ReverseVowels {

	public String reverse(String input){
		if(input == null)
			return " ";
		char[] charArr = input.toCharArray();
		
		int startPointer = charArr[0];
		int endPointer = charArr[charArr.length - 1];
		
		while(startPointer < endPointer) {
			//if(charArr[startPointer] == charArr[endPointer])

		}
		//TODO:
		return null;
	}
}
