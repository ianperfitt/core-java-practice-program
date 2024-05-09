package com.practice.threads;

public class InstantiateUsingRunnable {

	public static void main(String[] args) {

		System.out.println("Thread main started");

		final Thread thread1 = new Thread(new WorkerThread("Process data through Runnable interface"));
		thread1.start();
		thread1.setName("Demo Thread");

		System.out.println("Thread main finished");
	}
}