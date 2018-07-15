package com.javacore;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionExample {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		Class<?> c = Class.forName("com.javacore.RandomTest");
		Object object = c.newInstance();
		Method m = c.getDeclaredMethod("reflectionTest", new Class<?>[0]);
		m.invoke(object);
	}
}
