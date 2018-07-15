package com.priceline;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Use a queue to implement a stack
 * 
 * @author brianzhang
 *
 * @param <T>
 */
public class StackImplByQeue<T> {

	private Queue<T> queue = new LinkedList<T>();

	public void push(T val) {
		queue.offer(val);
		if (queue.size() > 1) {
			int loop = queue.size() - 1;
			while (loop > 0) {
				queue.offer(queue.poll());
				loop--;
			}
		}
	}

	public T peek() {
		return queue.peek();
	}

	public T poll() {
		return queue.poll();
	}

	public int size() {
		return queue.size();
	}

	public static void main(String[] args) {
		StackImplByQeue<Integer> sb = new StackImplByQeue<Integer>();
		sb.push(1);
		sb.push(2);
		sb.push(3);

		int size = sb.size();
		for (int i = 0; i < size; i++) {
			System.out.println(sb.poll());
		}
	}
}
