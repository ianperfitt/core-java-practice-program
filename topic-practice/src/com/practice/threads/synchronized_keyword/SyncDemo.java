package com.practice.threads.synchronized_keyword;

class Counter {
	int count;

	public synchronized void increment() {
		count++;
	}
}

public class SyncDemo {

	public static void main(String[] args) {

		Counter c = new Counter();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 1; i <= 1000; i++) {
					c.increment();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 1; i <= 1000; i++) {
					c.increment();
				}
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
		}

		System.out.println("Count " + c.count);
	}
}