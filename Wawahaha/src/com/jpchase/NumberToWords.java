package com.jpchase;

import java.awt.Rectangle;

public class NumberToWords {

	final private  static String[] units = {"Zero","One","Two","Three","Four",
		"Five","Six","Seven","Eight","Nine","Ten",
		"Eleven","Twelve","Thirteen","Fourteen","Fifteen",
		"Sixteen","Seventeen","Eighteen","Nineteen"};
	final private static String[] tens = {"","","Twenty","Thirty","Forty","Fifty",
		"Sixty","Seventy","Eighty","Ninety"};


	public static String convert(Integer i) {
		
		if( i < 20)  return units[i];
		if( i < 100) return tens[i/10] + ((i % 10 > 0)? " " + convert(i % 10):"");
		if( i < 1000) return units[i/100] + " Hundred " + ((i % 100 > 0)? convert(i % 100):"");
		if( i < 1000000) return convert(i / 1000) + " Thousand " + ((i % 1000 > 0)?  convert(i % 1000):"");
		if(i < 1000000000) return convert(i / 1000000) + " Millon " + ((i % 1000000 > 0) ?  convert(i%1000000):"");
		return convert(i / 1000000000) + " Billon " + ((i % 1000000000 > 0)? convert(i % 1000000000):"") ;
	}

	public static void main(String[] args) {
//		System.out.println("*** " + NumberawToWords.convert(110));
//		System.out.println("*** " + NumberToWords.convert(1));
//		System.out.println("*** " + NumberToWords.convert(16));
//		System.out.println("*** " + NumberToWords.convert(900));
//		System.out.println("*** " + NumberToWords.convert(118));
//		System.out.println("*** " + NumberToWords.convert(200));
//		System.out.println("*** " + NumberToWords.convert(219));
//		System.out.println("*** " + NumberToWords.convert(800));
//		System.out.println("*** " + NumberToWords.convert(801));
//		System.out.println("*** " + NumberToWords.convert(1316));
//		System.out.println("*** " + NumberToWords.convert(1000000));
//		System.out.println("*** " + NumberToWords.convert(2000000));
//		System.out.println("*** " + NumberToWords.convert(3000200));
//		System.out.println("*** " + NumberToWords.convert(700000));
//		System.out.println("*** " + NumberToWords.convert(9000000));
//		System.out.println("*** " + NumberToWords.convert(9001000));
//		System.out.println("*** " + NumberToWords.convert(123456789));
//		System.out.println("*** " + NumberToWords.convert(2147483647));
//		//System.out.println("*** " + NumberToWords.convert(3000000010));
//		
//		Integer e = 10;
//		
//		
//		System.out.println(Integer.parseInt("1101",2));
//		
		System.out.println(Math.pow(2, 3));
		
		
		
		
		
	}


}