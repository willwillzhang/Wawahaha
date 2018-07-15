package com.java.newfeature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Lambda Expression
 * When you're trying to pass functionality as an argument to another method, 
 * such as what action should be taken when someone clicks a button. Lambda expressions enable 
 * you to do this, to treat functionality as method argument, or code as data.
 *
 */

public class TestFunctionalInterface {
	
	public static List<Integer> convert(Converter<String, Integer> converter, List<String> strs){
		List<Integer> convertedArr = new ArrayList<Integer>();
		
		strs.forEach(e ->{
			convertedArr.add(converter.convert(e));
		});
		
		return convertedArr;
	}
	
	public static void main(String[] args){
		
		Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		//Converter<String, Integer> converter = Integer::valueOf;
		
		Converter<String, Integer> converter1 = (from) -> {return Integer.valueOf(from) + 31;};
		
		Converter<String, Integer> converter2 = (from) -> {return Integer.valueOf(from) + 100;};
		
		List<String> input = Arrays.asList("22", "11", "33");
		
		convert(converter, input);
		
		convert(converter1, input);
		
		convert(converter2, input);
		
	}
}
