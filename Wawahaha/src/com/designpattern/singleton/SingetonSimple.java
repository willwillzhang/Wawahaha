package com.designpattern.singleton;

public class SingetonSimple {
	public final static SingetonSimple INSTANCE = new SingetonSimple();

	private SingetonSimple() {
		// Exists only to defeat instantiation.
	}
}
