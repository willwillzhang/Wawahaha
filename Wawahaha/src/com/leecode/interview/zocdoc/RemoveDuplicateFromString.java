package com.leecode.interview.zocdoc;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateFromString {

	public static void main(String[] args) {

		String string = "aabbccdefatafaz";

		char[] chars = string.toCharArray();
		Set<Character> charSet = new HashSet<Character>();

		for (char c : chars) {
			charSet.add(c);
		}

		StringBuilder sb = new StringBuilder();
		charSet.forEach(c -> sb.append(c));
		System.out.println(sb.toString());
		System.out.println(removeDuplicates(string));
	}

	public static String removeDuplicates(String str) {
		int charsCount[] = new int[256];

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			charsCount[ch]++;
		}

		StringBuilder sb = new StringBuilder(charsCount.length);
		for (int i = 0; i < charsCount.length; i++) {
			if (charsCount[i] > 0) {
				sb.append((char) i);
			}
		}

		return sb.toString();
	}

	public static String remove1(String target) {
		char[] chars = target.toCharArray();

		Set<Character> charSet = new HashSet<Character>();

		for (char c : chars) {
			charSet.add(c);
		}

		StringBuilder sb = new StringBuilder();
		for (Character cha : charSet) {
			sb.append(cha);
		}

		return sb.toString();

	}
}
