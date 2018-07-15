package com.capitalOne;
/*
 * exercise
 * 
 */
public class FindLCSubsenquence {

	public static String lcsDy(String str1, String str2) {

		StringBuilder lcsStr = new StringBuilder();
		if (str1 == null || str2 == null)
			return lcsStr.toString();

		int[][] matrix = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 0; i < str1.length(); i++) {
			for (int j = 0; j < str2.length(); j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					matrix[i+1][j+1] = 1 + matrix[i][j];
				} else {
					matrix[i+1][j+1] = Math.max(matrix[i][j+1], matrix[i+1][j]);
				}
			}
		}
		
		for (int x = str1.length(), y = str2.length(); x > 0 && y > 0;) {
			if (matrix[x][y] == matrix[x - 1][y]) {
				x--;
			} else if (matrix[x][y] == matrix[x][y - 1]) {
				y--;
			} else if (str1.charAt(x - 1) == str2.charAt(y - 1)) {
				lcsStr.append(str1.charAt(x - 1));
				x--;
				y--;
			}
		}
		
		return lcsStr.toString();
	}
	
	public static void main(String[] args) {

		System.out.println(lcsDy("abcdefgeaaa", "bbcdefgaeggga"));
	}
}
