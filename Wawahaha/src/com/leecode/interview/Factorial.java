package com.leecode.interview;

public class Factorial {

	public static int factorial(int number){
		if(number == 0)
			return 1;
		
		return number*factorial(number -1 );
	}
	
	public static void main(String[] args){
		System.out.println(factorial(5));
	}
}
