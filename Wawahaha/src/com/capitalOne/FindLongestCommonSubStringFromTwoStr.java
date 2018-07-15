package com.capitalOne;

public class FindLongestCommonSubStringFromTwoStr {

	public static String lcsDy(String a, String b) {
		int[][] lengths = new int[a.length() + 1][b.length() + 1];

		int len = 0, pos = 0;

		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				if (a.charAt(i) == b.charAt(j)) {
					lengths[i + 1][j + 1] = lengths[i][j] + 1;
					if (lengths[i + 1][j + 1] > len) {
						len = lengths[i + 1][j + 1];
						pos = i + 1;
					}
				} else {
					lengths[i + 1][j + 1] = 0;
				}
			}
		}

		return a.substring(pos - len, pos).toString();
	}

	public static void main(String[] args) {

		System.out.println(lcsDy("abcdefgabced", "aabcdgeabcde"));
	}
}
