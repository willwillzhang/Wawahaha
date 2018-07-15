package com.designpattern.singleton;

import java.io.Serializable;

/**
 *  Lazy initialization way to implement the Singleton before java5
 */
final class Foo implements Serializable {

	private static final long serialVersionUID = 1L;

	// Wrapped in a inner static class so that loaded only when required
	private static class SingletonHolder {
		// And no more fear of threads
		private static final Foo INSTANCE = new Foo();
	}

	private Foo() {
		if (SingletonHolder.INSTANCE != null) {
			throw new IllegalStateException("Already instantiated");
		}
	}

	public static Foo getInstance() {
		//Foo foo = new Foo(); //Test avoid instantiate foo more than once
		return SingletonHolder.INSTANCE;
	}

	// Damn you serialization
	@SuppressWarnings("unused")
	private Foo readResolve() {
		return SingletonHolder.INSTANCE;
	}
}

public class SingleTonGetInstance {
	public static void main(String[] args) {
		Foo foo = Foo.getInstance();
	}
}

//the non-static inner class has the fully access of outer class, vise versa. but, static inner class
//can only access the static variable of outer class, but outer class have fully access for static inner class
//inner glass: It is a way of logically grouping classes that are only used in one place
//it's kind of that the inner class actually belong to the out class, just a member.

class A{
	private String aaa;
	
	private static class B{
		private static String cc = "aa";
		
		public void zhang(){
			//System.out.println(aaa);
		}
	}
	
	public void C() {
		B b = new B();
		System.out.println(B.cc);
	}
}