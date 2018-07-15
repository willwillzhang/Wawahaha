package com.leecode.interview;

public class FindLongestPalindromeInString {

	public static String getPalindrome(String str){
		
		String longestPdStr = "";
		
		for(int i = 1; i<str.length() ; i++){
			
			int left = i-1;
			int right = i+1;
			
			while(left>=0 && right<=str.length()-1){
				if(str.charAt(left) != str.charAt(right)){
					String tempSubStr = str.substring(left+1, right);
					if(tempSubStr.length()>longestPdStr.length()){
						longestPdStr = tempSubStr;
					}
					break;
				}else if(left == 0||right == str.length()-1){
					String tempSubStr = str.substring(left, right+1);
					if(tempSubStr.length()>longestPdStr.length()){
						longestPdStr = tempSubStr;
					}
					break;
				}else{
					left--;
					right++;
				}
			}
		}
		return longestPdStr;
	}
}
