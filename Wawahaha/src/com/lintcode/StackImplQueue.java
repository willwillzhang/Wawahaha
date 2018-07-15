package com.lintcode;

import java.util.LinkedList;
import java.util.Queue;


public class StackImplQueue {

	public static void main(String[] args){
		Queue qu = new LinkedList();
		qu.add("string");
		
		qu.offer(1);
		
		qu.peek();
		
		for(Object o : qu){
			System.out.println(o.toString());
		}
		
	}

}
