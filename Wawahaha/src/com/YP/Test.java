package com.YP;

import java.util.*;

public class Test {
	
	public static void main(String[] args) {
		   // creating tree map 
		   TreeMap<Integer, String> treemap = new TreeMap<Integer, String>();
		      
		   // populating tree map
		   treemap.put(2, "one");
		   treemap.put(1, "two");
		   treemap.put(3, "three");
		   treemap.put(6, "six");
		   treemap.put(5, "five");
		   
		   System.out.println(treemap);
		      
		   // putting values in navigable map
		   NavigableMap nmap=treemap.descendingMap();
		      
		   System.out.println("Checking value");
		   System.out.println("Navigable map values: "+nmap);
		   }   

}