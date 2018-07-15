package com.leecode.interview;

import java.util.Arrays;
import java.util.Random;

public class LoadedDice {
	public static void main(String[] args) {
		// String a = "agdg";
		// char[] b = a.toCharArray();
		// Arrays.sort(b);
		// String c = String.valueOf(b);
		// System.out.println(c);

		Random random = new Random();

		for (int i = 0; i < 10; i++) {

			int n5 = random.nextInt(10) + 1;

			int m = Integer.MIN_VALUE; // 结果数字

			if (n5 > 5) { // 55个数字的区间，55%的几率

				m = 6;

			} else if (n5 <= 5) {// [55,95)，40个数字的区间，40%的几率

				m = n5;

			}
			System.out.println(m);
		}

	}
}
