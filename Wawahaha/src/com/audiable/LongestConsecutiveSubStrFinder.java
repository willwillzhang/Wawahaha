package com.audiable;

public class LongestConsecutiveSubStrFinder {
	public static String getLongestSubString(String str){
		int maxLength = Integer.MIN_VALUE;
		int currSubStrStartIndex = 0;
		int fnialSubStrStartIndex = 0;
		
		for(int i = 1;i<str.length();i++){
			if(str.charAt(i) != str.charAt(i-1) || i == str.length()-1){
				if(maxLength<i-currSubStrStartIndex){
					maxLength = i- currSubStrStartIndex;
					fnialSubStrStartIndex = currSubStrStartIndex;
				}
				currSubStrStartIndex = i;
			}
		}
		return str.substring(fnialSubStrStartIndex, fnialSubStrStartIndex+ maxLength);
	}
	
	public static void main(String[] args){
		System.out.println(getLongestSubString("aaaaagddaabbbbbbgg"));
	}
}
