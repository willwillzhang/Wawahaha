package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class InteractiveBrokerTest {
	
	private final Character mm = 'a';
	
	public String toString(){return ""+mm;}

	public static void main(String[] args){
		/*
		Field f;
		try {
			f = InteractiveBrokerTest.class.getDeclaredField("mm");
			f.setAccessible(true);
			InteractiveBrokerTest iii = new InteractiveBrokerTest();
			f.set(iii,  (char)'b');
			System.out.println(iii);
			
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		for(byte b = Byte.MIN_VALUE ; b<Byte.MAX_VALUE; b++){
			
			if(b == 0X90){
				System.out.println("dsfsdf");
			}
		}
		
		HashMap<Integer, String> map = new HashMap<>();
		map.put(3, "aaa");
		map.put(new Integer(3), "bbbb");
		
		System.out.println(map);
		
		final List<Integer> list = new ArrayList<Integer>();

        Collections.addAll(list, 1, 5, 2, 3, 7, 3, 8, 9);

        final Integer pos = Integer.valueOf(3);

        list.remove(pos);

        System.out.println("99".matches("^([0-9]+)$"));
		
	}
}

enum ItemType{
	
	Company_Wide("Company");
	
	private String itemCode;
	
	private ItemType(String code){
		this.itemCode = code;
	}
	
	public String getItemCode(){
		return itemCode;
	}
}


class WareHouse{
	private int my;
	void addPacker(Packer packer){
		
	}
}

class Wrt extends WareHouse{
	
	
}

interface Packer{
	boolean pack();
}
