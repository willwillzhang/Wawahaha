package com.audiable;

import java.util.Iterator;
import java.util.PriorityQueue;

public class FindNthLargestElementFromArray {

	public static int find(int[] arr, int nth){
		if(arr == null)
			return -1;
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		int i=0;
		
		while(i<arr.length){
			queue.offer(arr[i]);
			i++;
			
			if(i>nth){
				queue.poll();
			}
		}
		return queue.peek();
	}
	
	public static void main(String[] args){
		int[] arr = {1,6,7,4,5,5};
		System.out.println(find(arr, 5));
		
		int[] ia = { 1, 10, 5, 3, 4, 7, 6, 9, 8 ,0};
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
 
		// use offer() method to add elements to the PriorityQueue pq1
		for (int x : ia) {
			pq1.offer(x);
		}
		
		//print out the element as the sequence in the binary tree - priority heap
		pq1.forEach(e -> System.out.println(e));
		
		System.out.println("=======================");
		Iterator it = pq1.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		System.out.println("=======================");
		//print out as the natural order
		int i = 0;
		while(i<10){
			i++;
			System.out.println(pq1.poll());
		}
		
	}
}
