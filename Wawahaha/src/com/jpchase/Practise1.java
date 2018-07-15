package com.jpchase;

public class Practise1 {

	private final static String[] units = {"Zero","One","Two","Three","Four",
			"Five","Six","Seven","Eight","Nine","Ten",
			"Eleven","Twelve","Thirteen","Fourteen","Fifteen",
			"Sixteen","Seventeen","Eighteen","Nineteen"};
	
	private final static String[] tens = {"","","Twenty","Thirty","Forty","Fifty",
			"Sixty","Seventy","Eighty","Ninety"};
	
	public static String convert(Integer i){
		
		if(i<20) return units[i];
		if(i<100) return tens[i/10] + ((i%10 > 0)? " " + convert(i%10):"");
		if(i<1000) return units[i/100] + " Hundred " +((i%100>0)? convert(i%100):"");
		if(i<1000000) return convert(i/1000) + " Thousand " + ((i%1000>0)? convert(i%1000):"");
		if(i<1000000000) return convert(i/1000000) + " Millon " + ((i%1000000>0)?convert(i%1000000):"");
		return units[i/1000000000] + " Billon " + ((i%1000000000>0)?convert(i%1000000000):"");
		
	}
	
	public static void main(String[] args) {
		System.out.println("*** " + Practise1.convert(110));
		System.out.println("*** " + Practise1.convert(1));
		System.out.println("*** " + Practise1.convert(16));
		System.out.println("*** " + Practise1.convert(900));
		System.out.println("*** " + Practise1.convert(118));
		System.out.println("*** " + Practise1.convert(200));
		System.out.println("*** " + Practise1.convert(219));
		System.out.println("*** " + Practise1.convert(800));
		System.out.println("*** " + Practise1.convert(801));
		System.out.println("*** " + Practise1.convert(1316));
		System.out.println("*** " + Practise1.convert(1000000));
		System.out.println("*** " + Practise1.convert(2000000));
		System.out.println("*** " + Practise1.convert(3000200));
		System.out.println("*** " + Practise1.convert(700000));
		System.out.println("*** " + Practise1.convert(9000000));
		System.out.println("*** " + Practise1.convert(9001000));
		System.out.println("*** " + Practise1.convert(123456789));
		System.out.println("*** " + Practise1.convert(2147483647));
		//System.out.println("*** " + Practise1.convert(3000000010L));
	}
	
}
