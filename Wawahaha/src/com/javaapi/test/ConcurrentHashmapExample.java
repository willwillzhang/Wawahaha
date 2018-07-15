package com.javaapi.test;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/*
 * Interviewer : Can you write the simple  example which proves ConcurrentHashMap class behaves like fail safe iterator?
 */

public class ConcurrentHashmapExample {
	public static void main(String[] args)
    {
        ConcurrentHashMap<String,String> premiumPhone = new ConcurrentHashMap<String,String>();
        premiumPhone.put("Apple", "iPhone6");
        premiumPhone.put("HTC", "HTC one");
        premiumPhone.put("Samsung","S6");
        
        Iterator iterator = premiumPhone.keySet().iterator();
        
        while (iterator.hasNext())
        {
            System.out.println(premiumPhone.get(iterator.next()));
            premiumPhone.put("Sony", "Xperia Z");
        }
        
        premiumPhone.forEach((k,v) -> System.out.println(v));
        
    }
}
