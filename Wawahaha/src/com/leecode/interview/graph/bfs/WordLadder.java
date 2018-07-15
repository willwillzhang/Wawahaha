package com.leecode.interview.graph.bfs;

import java.util.HashMap;

public class WordLadder {
	public static void main(String[] args){
		HashMap<Person, String> aa = new HashMap<Person, String>();
		Person person1 = new Person();
		person1.setName("dongdong");
		
		aa.put(person1, "huahua");
		
		
		System.out.println(aa.containsKey(person1));
		
		for(int i = 1; i<100; i++){
			System.out.println(i);
			for(int j = i; j<100;j++){
				if(j == 50)
					return;
			}
		}
		
	}
}


class Person{
	String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}