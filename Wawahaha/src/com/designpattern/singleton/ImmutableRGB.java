package com.designpattern.singleton;

import java.util.Date;

final public class ImmutableRGB {

	// int, String is immutalbe, Date is not that need be cloned, then return. To avoid directly return a reference. 
	final private int red;
	final private int green;
	final private int blue;
	final private String name;
	final private Date date; //reference need to cloned

	private void check(int red, int green, int blue) {
		if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
			throw new IllegalArgumentException();
		}
	}

	public ImmutableRGB(int red, int green, int blue, String name, Date date) {
		check(red, green, blue);
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.name = name;
		this.date = date;
	}

	public int getRGB() {
		return ((red << 16) | (green << 8) | blue);
	}

	public String getName() {
		return name;
	}

	public ImmutableRGB invert() {
		//return a clone copy
		return new ImmutableRGB(255 - red, 255 - green, 255 - blue, "Inverse of " + name, new Date());
	}
	
	public Date getDate(){
		//return date; //this is wrong that someone can change the date by modifying this reference
		return new Date(date.getTime());
	}
	
}