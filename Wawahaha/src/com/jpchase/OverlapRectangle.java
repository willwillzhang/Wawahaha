package com.jpchase;

import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Define and implement a function which takes an input of two rectangles A and B and returns a boolean value which 
 * indicates if the two rectangles overlap or not (i.e. it should return 'true' if they overlap and ‘false’ otherwise). 
 * Both input rectangles should be defined as 4 integers each where the first two integers are representing the 'x' and 'y' coordinates of 
 * the lower left point followed by two integers which represent the 'width' and 'height' of the rectangle. 
 * The rectangles are considered overlapping if they have at least one common point.

Input:

Wrap your function defined and implemented above into a program which should read a line from standard input and write the result on the standard output. 
Your program should read from standard input 8 integers separated by spaces. The first four will be the definition of rectangle A and the second four will
be the definition of rectangle B (both as per the definition in the description - i.e. 'x', 'y', 'width' and 'height').

Output:

For each line in the input parse the inputs into the rectangles, invoke the function defined in the description and then print 
a line to standard output with the result as a string (i.e. print 'true' if A and B intersect and 'false' otherwise).

 
questions:
 
Test1
Input: 0 0 1 1 -1 -1 1 1
expected Output: true
 
 
Test2:
Input: 1 1 1 1 -1 -1 2 1
expected output: false
 
Test3
Input: 1 1 1 1 -1 -1 3 1
 expected  output:false
 
Test4:
Input:1 1 1 1 -1 -1 3 3
expected Output:true
*/

public class OverlapRectangle {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		String b[] = s.split(" ");
		int a[] = new int[8];

		for (int i = 0; i < a.length; i++)
			a[i] = Integer.parseInt(b[i]);
		Rectangle r1 = new Rectangle(a[0], a[1], a[2], a[3]);
		Rectangle r2 = new Rectangle(a[4], a[5], a[6], a[7]);
		System.out.println(intersection2(r1, r2));
	}

	private static boolean intersection2(Rectangle r1, Rectangle r2) {
		float x1 = r1.x + r1.width;
		float y1 = r1.y + r1.height;

		float x2 = r2.x + r2.width;
		float y2 = r2.y + r2.height;

		if (x1 < r2.x || x2 < r1.x)
			return false;

		// up or down
		if (r1.y > y2 || y1 < r2.y)
			return false;

		return true;
	}
}
