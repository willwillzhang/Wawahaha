package com.javacore;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * To work properly in a multithreaded application, "check then act" operations must be atomic.
 * By atomic is meant that both the "check" and "act" actions are executed as an atomic (non-dividable) block of code. 
 * Any thread that starts executing the block will finish executing the block without interference from other threads. 
 * No other threads can execute the atomic block at the same time.
 * 
 */
public class AtomicExample {

	public static void main(String[] args) {

	}
}

class MyLock {

	private boolean locked = false;

	public synchronized boolean lock() {
		if (!locked) {
			locked = true;
			return true;
		}
		return false;
	}
}

class MyLockByAtomic {
	private AtomicBoolean locked = new AtomicBoolean(false);

	public boolean lock() {
		return locked.compareAndSet(false, true);
	}

}