package Practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ThreadPractice {

	// Inner class
	class SharedResource {
		private int data = 0;
		private boolean available = false;

		public void produce(int value) throws InterruptedException {
			// Using a synchronized block of code for more granular control
			synchronized (this) {
				while (available) {
					// Used for inter thread communication and
					// synchronize the activities of multiple threads.
					wait();
				}
				data = value;
				available = true;
				// Used for inter thread communication and
				// synchronize the activities of multiple threads.
				notify();
			}
		}

		public int consume() throws InterruptedException {
			synchronized (this) {
				while (!available) {
					wait();
				}
				available = false;
				notify();
				return data;
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		ThreadPractice threadPractice = new ThreadPractice();

		SharedResource sharedResource = threadPractice.new SharedResource();

		// Runnable passes method containing IntStream to
		// run() method
		Runnable producerRunnable = () -> {

			IntStream.range(1, 6).forEach((i) -> {
				try {
					sharedResource.produce(i);
					System.out.println("Produced: " + i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			});
		};

		Runnable consumerRunnable = () -> {

			IntStream.range(1, 6).forEach((i) -> {
				try {
					int value = sharedResource.consume();
					System.out.println("Consumed: " + value);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		};

		// Producer and consumer in New state.
		Thread producer = new Thread(producerRunnable);
		Thread consumer = new Thread(consumerRunnable);

		// Producer and consumer in Runnable state.
		producer.start();
		consumer.start();

		// Ensure that both consumer and producer
		// tasks have terminated before
		// proceeding with main thread
		producer.join();
		consumer.join();

		// At this point both producer
		// and consumer are in terminated state
		System.out.println("Producer is alive: " + producer.isAlive());
		System.out.println("Consumer is alive: " + consumer.isAlive());
		System.out.println("Final data count: " + sharedResource.data);

		// Thread pooling using ExecutorService example
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		IntStream.range(1, 6).forEach((i) -> {
			final int taskId = i;
			executorService.submit(() -> {
				System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		});
		executorService.shutdown();

		// Creating ThreadGroups
		ThreadGroup group1 = new ThreadGroup("Group 1");
		ThreadGroup parentGroup = new ThreadGroup("Parent Group");
		ThreadGroup group2 = new ThreadGroup(parentGroup, "Group 2");

		// Adding Threads to a ThreadGroup
		ThreadGroup group = new ThreadGroup("Group");

		// Set priority for thread group.
		group.setMaxPriority(Thread.NORM_PRIORITY);

		Thread thread1 = new Thread(group, () -> {
			IntStream.range(1, 6).forEach((e) -> {
				System.out.println(Thread.currentThread().getName() + " in " + group.getName());
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
		}, "Thread 1");

		Thread thread2 = new Thread(group, () -> {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + " in " + group.getName());
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "Thread 2");

		thread1.start();
		thread2.start();
		// Retreive number of active threads in "Group" thread group
		int activeThreads = group.activeCount();
		System.out.println("Active Threads: " + activeThreads);
		thread1.join();
		thread2.join();
	}
}