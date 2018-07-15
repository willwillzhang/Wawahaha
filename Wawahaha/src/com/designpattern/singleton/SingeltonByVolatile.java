package com.designpattern.singleton;

class Food {

	private static volatile Food food = null;
	
	private Food(){}

	public static Food getFoo1() {
		if (food == null) {
			synchronized (Food.class) {
				if (food == null)
					food = new Food();
			}
		}
		return food;
	}
}

public class SingeltonByVolatile {

}
