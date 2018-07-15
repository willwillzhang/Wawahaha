package com.capitalOne;

public class FindMostFrequentlyUsedLetter {

	public static char getMax(String word) {
		if (word == null || word.isEmpty()) {
			throw new IllegalArgumentException("input word must have non-empty value.");
		}
		char maxchar = ' ';
		int maxcnt = 0;
		// if you are confident that your input will be only ascii, then this
		// array can be size 128.
		int[] charcnt = new int[Character.MAX_VALUE + 1];
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (ch != ' ') {
				// increment this character's cnt and compare it to our max.
				if (++charcnt[ch] >= maxcnt) {
					maxcnt = charcnt[ch];
					maxchar = ch;
				}
			}
		}
		return maxchar;
	}

	public static void main(String[] args) {
		System.out.println(getMax("Hello World!"));
		System.out.println((int)'A');
	}
}