package com.javaapi.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.lang.reflect.Field;

class AAA {
    private final Character m_value = 'a';
    
    public String toString() { return "" + m_value; }

//    public static void main(String[] args) {
//        try {
//            Field f = A.class.getDeclaredField("m_value");
//            f.setAccessible(true);
//            A a = new A();
//            f.set(a, (char) 'b' );
//            System.out.println(a);
//        } catch (Exception e) {    
//            e.printStackTrace();
//        }
//    }
}

public class YYY {

    public static void main(String[] args) {
//
//        for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {
//
//            if (b == 0x90) {
//
//                System.out.print("We found it");
//
//             }
//
//        }
//        
//        Map<Integer, String> hashMap = new HashMap<Integer, String>(5);
//        hashMap.put(1, "apple");
//        hashMap.put(2, null);
//        hashMap.put(new Integer(3), "peach");
//        hashMap.put(3, "orange");
//        hashMap.put(4, "peach");
//
//        for (String v : hashMap.values()) {
//
//            if ("orange".equals(v)) {
//                hashMap.put(5, "banana");
//            }    
//        }
//        System.out.println(hashMap.get(5));

        
//        final List<Integer> list = new ArrayList<Integer>();
//
//        Collections.addAll(list, 1, 5, 2, 3, 7, 3, 8, 9);
//
//        final Integer pos = Integer.valueOf(3);
//
//        list.remove(pos);
//
//        System.out.println(list);
    	
    	
    	int[] aa = new int[10];
    	
    	char a = "A".charAt(0);
    	
    	System.out.println((int)a);

    }

}