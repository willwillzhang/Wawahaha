package com.leecode.interview.zocdoc;

import java.util.*;

public class Palindrome {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("Input a string");
		String inputString = in.nextLine();
		
		System.out.println(isPalindrome(inputString));
	}

	public static boolean isPalindrome(String str) {

		if (str == null)
			return true;

		int length = str.length();

		for (int i = 0; i < length / 2; i++) {
			if (str.charAt(i) != str.charAt(length - i - 1)) {
				return false;
			}
		}
		return true;
	}

	/*public void isPalindrom1(String inputString) {
		if (inputString == null)
			return;

		int i, begin, end, middle;
		int length = inputString.length();
		begin = 0;
		end = length - 1;
		middle = (begin + end) / 2;

		for (i = begin; i <= middle; i++) {
			if (inputString.charAt(i) == inputString.charAt(end)) {
				end--;
			} else {
				break;
			}
		}
		if (i == middle + 1) {
			System.out.println("Palindrome");
		} else {
			System.out.println("Not a palindrome");
		}
	}*/
}