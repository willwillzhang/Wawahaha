package com;

import java.util.Arrays;
import java.util.HashMap;

public class ConvertStringToInt {
	public static void main(String[] args){
		String a = "abc";
		String b = null;
		System.out.println(null instanceof Object);
		System.out.println(null == null);
		//System.out.println(b.toString());
		
		A aaa= null;
		
		System.out.println(aaa instanceof A);
		
		/*
		Integer c =10;
		Integer d = 10;
		
		HashMap<String, Integer> map = new HashMap<>();
		map.put("dong", 1);
		System.out.println(c.compareTo(d) ==0);
		*/
	}
	
	static boolean compareI(int a, int b){
		
		return a == b;
	}

}


class A{
	
	
	
}


class B extends A{
	
}

class C extends B{
	
}