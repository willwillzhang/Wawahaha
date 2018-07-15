package com.designpattern.singleton;

import java.util.Arrays;

/**
 * Single element enum type singleton
 * 
 * The Right Way to Implement a Serializable Singleton
 *
 *enum instance fields are not "initialized by a compile-time constant expression".
 *so, enum singleton is lazy load.
 */
enum SingletonEnum {
	INSTANCE;       //equals to: public final static SingletonEnum singleton = new SingletonEuum(); 
	 
	private final String[] songs = {"dazhongguo", "mengxiang"}; //String is immutable, so here is thread safe. otherwise, you have to clone the object when return it to outside.
	public void printSongs(){
			System.out.println(Arrays.toString(songs));
	}
}

public class SingleTonByEnum{
	public static void main(String[] args){
		SingletonEnum singleton = SingletonEnum.INSTANCE;
		singleton.printSongs();
	}
}
