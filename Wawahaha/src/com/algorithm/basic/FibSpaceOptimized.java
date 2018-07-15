package com.algorithm.basic;

public class FibSpaceOptimized {

	public static int fibonacci(int n){
		int a = 0, b = 1, c, i;
		  if( n == 0)
		    return a;
		  for (i = 2; i <= n; i++)
		  {
		     c = a + b;
		     a = b;
		     b = c;
		  }
		  return b;
	}
	
	public static void main(String[] args){
		int n = 9;
		 System.out.println(fibonacci(n));
	}
}
