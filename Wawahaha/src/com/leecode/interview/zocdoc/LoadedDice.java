package com.leecode.interview.zocdoc;

import java.util.Random;

//Get 5 times of num 6 side when toss 10 times dice. 

public class LoadedDice {
	
	public static void main(String[] args) {
	
		Random random = new Random();

		for (int i = 0; i < 10; i++) {

			int n5 = random.nextInt(10) + 1; //range is 1-10

			int m = Integer.MIN_VALUE; // dice side

			if (n5 > 5) { // 50% rate for 6

				m = 6;

			} else if (n5 <= 5) {// 10% rate for each num less than 5

				m = n5;

			}
			System.out.println(m);
		}

	}
}
