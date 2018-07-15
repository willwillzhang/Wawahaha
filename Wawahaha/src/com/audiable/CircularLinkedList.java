package com.audiable;

public class CircularLinkedList {
	
	static Node head;
	
	static class Node{
		int value;
		Node next;

		Node(int val){
			this.value = val;
			this.next = null;
		}
		
		Integer detectLoop(Node node){
			Node slow = null;
			Node fast = null;
			
			Integer result = null;
			
			while(slow != null && fast != null && fast.next != null){
				slow = node.next;
				fast = node.next.next;
				
				if(slow == fast){
					 result = slow.value;
				}
			}
			return result;
		}
		
		
		void removeLoop(Node loop, Node curr){
			
			
			
		}
		
		
		
		
	}

}
