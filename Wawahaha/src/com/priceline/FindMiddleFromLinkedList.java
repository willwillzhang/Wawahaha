package com.priceline;

/**
 * 
 * Use two pointer fastptr and slowptr and initialize both to head of linkedlist
Move fastptr by two nodes and slowptr by one node in each iteration.
When fastptr reaches end of nodes, the slowptr pointer will be  pointing to middle element.

Read more at http://www.java2blog.com/2014/07/find-middle-element-of-linkedlist-in.html#hMDq0H5WYj9M5mW4.99
 * @author brianzhang
 *
 */
public class FindMiddleFromLinkedList {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		// Creating a linked list
		Node head = new Node(5);
		list.addToTheLast(head);
		list.addToTheLast(new Node(6));
		list.addToTheLast(new Node(7));
		list.addToTheLast(new Node(1));
		list.addToTheLast(new Node(2));
		//list.addToTheLast(new Node(8));

		list.printList();
		// finding middle element
		Node middle = list.findMiddleNode(head);
		System.out.println("Middle node will be: " + middle.value);

	}

}

class Node {
	public int value;
	public Node next;

	Node(int value) {
		this.value = value;
	}
}

class LinkedList {

	private Node head;

	public void addToTheLast(Node node) {

		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;

			temp.next = node;
		}
	}

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.format("%d ", temp.value);
			temp = temp.next;
		}
		System.out.println();
	}

	// This function will find middle element in linkedlist
	public Node findMiddleNode(Node head) {
		Node slowPointer, fastPointer;
		slowPointer = fastPointer = head;

		while (fastPointer != null) {
			fastPointer = fastPointer.next;
			if (fastPointer != null && fastPointer.next != null) {
				slowPointer = slowPointer.next;
				fastPointer = fastPointer.next;
			}
		}
		return slowPointer;
	}
}
