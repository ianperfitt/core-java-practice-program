package com.practice.threads;

public class RunnableExampleUsingAnonymousClass {

	public static void main(String[] args) {

		System.out.println(" main thread started : " + Thread.currentThread().getName());

		System.out.println("Creating Runnable...");

		final Runnable runnable = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("Inside : " + Thread.currentThread().getName());
				}
			}
		};

		System.out.println("Creating Thread...");
		final Thread thread = new Thread(runnable);

		System.out.println("Starting Thread...");
		thread.start();

		System.out.println(" main thread ended : " + Thread.currentThread().getName());
	}
}
