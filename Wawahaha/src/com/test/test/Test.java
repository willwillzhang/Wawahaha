package com.test.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Test {
	
	  public static void main(String[] args) {
		  
		  List<List<String>> aa = new ArrayList<List<String>>();
		  
		  List<String> bb = new ArrayList<String>();
		  bb.add("zhang");
		  bb.add("dong");
		  
		  List cc = new ArrayList<String>();
		  cc.add("zhang");
		  cc.add("dong");
		  
		  aa.add(bb);
		  aa.add(cc);
		  
		  aa.addAll(cc);
		  
		  System.out.println(aa.get(0) instanceof List);
		  
		  int[] intArr = {0,1,1,1};
		  
		  int[] io = new int[]{1,4,5};
		  
		  int[] arrOrp = new int[10];
		  
		  String[] strArr = {"dong", "zhang", "ddd"};
		  
		  
		  for(int i = 0;i<intArr.length;i++){
			  System.out.println(intArr[i]);
		  }
		  
		  aa.get(0).add("huahua");

		  Random rng = new Random();
		  int sixes = 0;
		  for (int i = 0; i < 100; i++)
		  {
		      int diceRoll = rng.nextInt(6) + 1;
		      if (diceRoll == 6)
		      {
		          ++sixes;
		      }
		  }
		  System.out.println("No. of 6s from 100 rolls is " + sixes);
		  
//	    outerloop:
//	    for (int i=0; i < 5; i++) {
//	      for (int j=0; j < 5; j++) {
//	        if (i * j > 6) {
//	          System.out.println("Breaking");
//	          break outerloop;
//	        }
//	        System.out.println(i + " " + j);
//	      }
//	    }
//	    System.out.println("Done");
	  
	  
	 // ArrayList<List<Integer>> result  = new ArrayList(Arrays.asList(5,6,7,7));
	  
	//  List<Integer> test = Arrays.asList(1,3,5);
	  
	//  result.add(test);
	  
		  int[] n = {1,3,4,5,1,3,4};
	  //System.out.println(Test.singleNumber(n));
	  
	  }
	  
	  public static int singleNumber(int[] A) 
	  {
	  	int ans = A[0];
	  	for(int i=1;i<A.length;i++)
	  	{
	  		ans = ans^A[i];
	  	}

	  	return ans;
	  }

	}
