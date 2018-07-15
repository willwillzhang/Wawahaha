package com.javacore;

import java.util.Random;

//前面介绍过，相同种子数的Random对象，相同次数生成的随机数字是完全相同的，下面是测试的代码：

public class RandomTest {
	
	public static void main(String[] args) {
		Random r1 = new Random(10);

		Random r2 = new Random(10);

		for (int i = 0; i < 5; i++) {

			System.out.println(r1.nextInt());

			System.out.println(r2.nextInt());

		}

	}
	
	private void reflectionTest(){
		System.out.println("Invoked by reflection way.");
	}
}
