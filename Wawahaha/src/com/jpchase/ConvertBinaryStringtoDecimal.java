package com.jpchase;

public class ConvertBinaryStringtoDecimal {

	public int BinaryToDecimal(int binaryNumber) {

		int decimal = 0;
		int binary = binaryNumber;
		int power = 0;
		while (binary != 0) {
			int lastDigit = binary % 10;
			decimal += lastDigit * Math.pow(2, power);
			power++;
			binary = binary / 10;
		}
		return decimal;

	}

	public static void main(String args[]) {
		ConvertBinaryStringtoDecimal obj = new ConvertBinaryStringtoDecimal();
		System.out.println("110 --> " + obj.BinaryToDecimal(110));
		System.out.println("1101 --> " + obj.BinaryToDecimal(1101));
		System.out.println("100 --> " + obj.BinaryToDecimal(100));
		System.out.println("110111 --> " + obj.BinaryToDecimal(110111));

		System.out.println(Math.pow(2.0, 3.0));

	}

}
