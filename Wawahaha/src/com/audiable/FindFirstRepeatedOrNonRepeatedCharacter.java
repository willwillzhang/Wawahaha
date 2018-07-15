package com.audiable;

import java.util.Arrays;

public class FindFirstRepeatedOrNonRepeatedCharacter {

	public static char findFirstRepeatedCharacter(String str) {

		char firstRepeated = ' ';
		char[] charArr = str.toCharArray();
		Arrays.sort(charArr);

		for (int i = 1; i < charArr.length; i++) {
			if (charArr[i] == charArr[i - 1]) {
				firstRepeated = charArr[i];
				return firstRepeated;
			}
		}
		return firstRepeated;
	}

	public static char findFirstNonRepeatedCharacter(String str) {

		char firstNonRepeated = ' ';
		char[] charArr = str.toCharArray();
		Arrays.sort(charArr);

		for (int i = 0; i < charArr.length; i++) {
			if (charArr[i] != charArr[i + 1]) {
				if (i >= 1) {
					if (charArr[i - 1] != charArr[i])
						return charArr[i];
				}
				if (i == 0)
					return charArr[i];
			}
		}
		return firstNonRepeated;
	}

	public static void main(String[] args) {

		String str = "agbscdg";
		System.out.println(findFirstNonRepeatedCharacter(str));
		System.out.println(findFirstRepeatedCharacter(str));
	}
}
