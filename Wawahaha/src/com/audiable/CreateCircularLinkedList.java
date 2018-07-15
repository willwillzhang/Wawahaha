package com.audiable;

public class CircularLinkedList {

	Node2 start;
	Node2 end;
	int size;

	public CircularLinkedList() {
		start = null;
		end = null;
		size = 0;
	}

	public int insertStart(int val) {

		Node2 node = new Node2(val, null);

		if (start == null) {
			start = node;
			node.setLink(start);
			end = start;
		} else {
			end.setLink(node);
			start = node;
		}
		size++;
	}

	public int insertEnd(int val) {

		Node2 node = new Node2(val, null);

		if (start == null) {
			start = node;
			node.setLink(node);
			end = start;
		} else {
			end.setLink(node);
			start = end;
		}
		size++;
	}
}

class Node2 {

	int value;
	Node2 link;

	public Node2() {
		link = null;
		value = 0;
	}

	public Node2(int val, Node2 link) {
		value = val;
		this.link = link;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node2 getLink() {
		return link;
	}

	public void setLink(Node2 link) {
		this.link = link;
	}
}
