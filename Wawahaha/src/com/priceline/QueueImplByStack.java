package com.priceline;

import java.util.Stack;

public class QueueImplByStack {

	private Stack<Integer> stackA = new Stack<Integer>();
	private Stack<Integer> stackB = new Stack<Integer>();

	public void push(Integer val) {
		if (val == null)
			return;

		if (!stackB.isEmpty()) {
			int size = stackB.size();
			while (size-- > 0) {
				stackA.push(stackB.pop());
			}
		}

		stackB.push(val);

		if (!stackA.isEmpty()) {
			int size = stackA.size();
			while (size-- > 0) {
				stackB.push(stackA.pop());
			}
		}
	}

	public Integer pop() {
		return stackB.pop();
	}

	public Integer peek() {
		return stackB.peek();
	}
	
	public Integer size() {
		return stackB.size();
	}

	public static void main(String[] args) {
		QueueImplByStack queue = new QueueImplByStack();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		
		int size = queue.size();
		while(size-->0){
			System.out.println(queue.pop());
		}

	}

}
