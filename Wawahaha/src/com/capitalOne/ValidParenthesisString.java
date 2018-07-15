package com.capitalOne;

import java.util.HashMap;
import java.util.Stack;

/*
 * i.e. "123(13(44))" is valid but ")234(12)(" 
 */

public class ValidParenthesisString {
	
	public static boolean checkParenthesisStr(String str){
		if(str != null && str.length() == 0)
			return false;
		
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		Stack<Character> stack = new Stack<Character>();
		
		int i=0;
		while(i<str.length()){
			char curr = str.charAt(i);
			if(map.keySet().contains(curr)){
				stack.push(curr);
			}else if(map.values().contains(curr)){
				if(!stack.empty() && map.get(stack.peek()) == curr){
					stack.pop();
				}else{
					return false;
				}
			}
			i++;
		}
		if(stack.isEmpty())
			return true;
		else
			return false;
	}
	
	public static void main(String[] args){
		System.out.println(checkParenthesisStr("12(3(4)(56)67"));
	}
}
