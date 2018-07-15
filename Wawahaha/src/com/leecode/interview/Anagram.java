package com.leecode.interview;

import java.util.ArrayList;
import java.util.Arrays;

public class Anagram {
	
	public static String[] findAnagramString(String[] strs){
		ArrayList<String> res = new ArrayList();
		for(String str : strs){
			char[] temp = str.toCharArray();
			Arrays.sort(temp);
			
		}
	}
	
	public static void main(String[] args){
		String[] strs = {"abcd", "dbca", "ad", "oo", "ba"};
		
		Arrays.sort(strs);
		
		for(String str : strs){
			System.out.println(str);
		}
		
	}
}
