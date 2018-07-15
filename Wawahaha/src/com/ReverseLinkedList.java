package com;

//Java program for reversing the linked list
// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class ReverseLinkedList {

	/* Function to reverse the linked list */
	static ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode current = head;
		while (current != null) {
			ListNode next = current.next;
			//reverse the pointer
			current.next = prev;
			//moving currentNode and prevNode one step e.g. (1- A, B)  (2- B, C)
			prev = current;
			current = next;
		}
		
		head = prev;
		return head;
	}

	// prints content of double linked list

	public static void main(String[] args) {
		ListNode node = new ListNode(85);
		node.next = new ListNode(15);
		node.next.next = new ListNode(4);
		node.next.next.next = new ListNode(20);

		System.out.println("Original Linked list is :");
		printList(node);
		node = reverse(node);
		System.out.println("Reversed linked list : ");
		printList(node);
	}
	
	static void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}
}

// This code has been contributed by Mayank Jaiswal
