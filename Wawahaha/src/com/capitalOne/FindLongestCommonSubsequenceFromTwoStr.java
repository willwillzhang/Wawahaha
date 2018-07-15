package com.capitalOne;

/**
 * http://algorithms.tutorialhorizon.com/dynamic-programming-longest-common-
 * subsequence/
 * 
 * https://rosettacode.org/wiki/Longest_common_subsequence#Dynamic_Programming_2
 * 
 * Dynamic programming
 * 
 * Given two strings, write a program that efficiently finds the longest common
 * subsequence.
 * 
 * @author brian_zhang
 *
 */
public class FindLongestCommonSubsequenceFromTwoStr {

	public static String lcsDy(String a, String b) {

		int[][] lengths = new int[a.length() + 1][b.length() + 1];

		// row 0 and column 0 are initialized to 0 already

		for (int i = 0; i < a.length(); i++)
			for (int j = 0; j < b.length(); j++)
				if (a.charAt(i) == b.charAt(j))
					lengths[i + 1][j + 1] = lengths[i][j] + 1;
				else
					lengths[i + 1][j + 1] = Math.max(lengths[i + 1][j], lengths[i][j + 1]);

		// read the substring out from the matrix
		StringBuffer sb = new StringBuffer();
		for (int x = a.length(), y = b.length(); x != 0 && y != 0;) {
			if (lengths[x][y] == lengths[x - 1][y])
				x--;
			else if (lengths[x][y] == lengths[x][y - 1])
				y--;
			else if (a.charAt(x - 1) == b.charAt(y - 1)) {
				sb.append(a.charAt(x - 1));
				x--;
				y--;
			}
		}

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(lcsDy("abcdebbabc", "aabcdebdseg"));
	}
}
