package com.javaapi.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

	private static final char SEPARATOR = 0x20;
	private static final int MESSAGE_TYPE = 1;

	static void login() {

		System.out.println(SEPARATOR + MESSAGE_TYPE + "=A");

	}

	public static void main(String[] args) {
		login();
	}
}

class A {
	int val;
}

class B {
	String ppp;

	String getVal() {
		return this.ppp;
	}
}