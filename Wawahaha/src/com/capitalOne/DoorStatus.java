package com.capitalOne;

/*
 * http://www.javacodex.com/Math-Examples/One-Hundred-Doors
 * http://codereview.stackexchange.com/questions/61309/open-and-closed-doors-riddle
 */
public class DoorStatus {

	public static boolean checkDoorStatus(final int doors, final int passes, final int xDoor){
		
		boolean[] doorStatuses = new boolean[101];
		
		for(int i=1; i<passes; i++){
			for(int j = i; j<doors; j++){
				if(j % i == 0){
					doorStatuses[j] = !doorStatuses[j];
				}
			}
		}
		
		for(int i=1; i<doorStatuses.length;i++){
			System.out.println(doorStatuses[i]);
		}
		
		return doorStatuses[xDoor];
	}
	
	public static void main(String[] args){
	
		System.out.println(checkDoorStatus(100, 50, 80));
	}
}


/**
 * 
 *  Light Bulb 64 is on. The total number of bulbs which are on including #64 is 10.

	First think who will operate each bulb, obviously person #2 will do all the even numbers, and say person #10 will 
	operate all the bulbs that end in a zero. So who would operate for example bulb 48: Persons numbered: 1 & 48, 2 & 24, 3 & 16, 4 & 12, 6 & 8 ........ 
	That is all the factors (numbers by which 48 is divisible) will be in pairs. This means that for every person who switches a bulb on there will be someone 
	to switch it off. This will result in the bulb being back at it's original state.
	
	So why aren't all the bulbs off? Think of bulb 36:- The factors are: 1 & 36, 2 & 13, 6 & 6 Well in this case whilst all the factors are in pairs 
	the number 6 is paired with it's self. Clearly the sixth person will only flick the bulb once and so the pairs don't cancel. This is true of all
	the square numbers.
	
	There are 10 square numbers between 1 and 100 (1, 4, 9, 16, 25, 36, 49, 64, 81 & 100) hence 10 bulbs remain on.
 * 
 */


