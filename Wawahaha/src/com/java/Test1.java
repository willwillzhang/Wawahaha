package com.java;

import java.util.HashMap;
import java.util.Stack;

public class Test1 
{

	public static void main(String[] args)
	{
		
		System.out.println(987%1000);
		
		Person p = new Person();
		p.name = "brian";
		p.sex = "male";
		
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.add(1);
		stack.add(2);
		
		System.out.println(stack.empty());
		
		
		HashMap<String, String> test = new HashMap();
		System.out.println(test.put("1", "hh"));
		System.out.println(test.put("1", "xx"));
		
		
	}
}

class Person
{
	String name;
	String sex;
}
