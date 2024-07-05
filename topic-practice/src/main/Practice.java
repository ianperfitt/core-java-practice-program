package main;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

public class Practice {

	// Create a thread-local variable.
	private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
	// Specify an initial value for thread-local variable.
	private static ThreadLocal<Integer> threadLocal2 = ThreadLocal.withInitial(() -> 1);
	// InheritableThreadLocal extends ThreadLocal and allows threads to inherit
	// values from their parent thread.
	private static InheritableThreadLocal<Integer> threadLocal3 = new InheritableThreadLocal<>();

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

	class Task implements Runnable {
		private final String name;

		public Task(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			System.out.println("Task " + name + " is being executed by " + Thread.currentThread().getName());
			try {
				Thread.sleep(2000); // Simulate long-running task
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	class CallableTask implements Callable<String> {
		private final String name;

		public CallableTask(String name) {
			this.name = name;
		}

		@Override
		public String call() throws Exception {
			System.out.println("Task " + name + " is being executed by " + Thread.currentThread().getName());
			Thread.sleep(2000); // Simulate long-running task
			return "Result of " + name;
		}
	}

	class MyCallable implements Callable<Integer> {

		@Override
		public Integer call() throws Exception {
			// Simulate long-running task
			Thread.sleep(5000);
			return 123;
		}
	}

	public class ReentrantLockExample {
		private final Lock lock = new ReentrantLock();
		private int counter = 0;

		public void increment() {
			// increment method is protected by the lock which ensures thread-safe access to
			// counter variable
			lock.lock();
			try {
				counter++;
				System.out.println(Thread.currentThread().getName() + " - Counter: " + counter);
			} finally {
				lock.unlock();
			}
		}
	}

	public class ReadWriteLockExample {
		private final ReadWriteLock lock = new ReentrantReadWriteLock();
		private int counter = 0;

		public void increment() {
			lock.writeLock().lock();
			try {
				counter++;
				System.out.println(Thread.currentThread().getName() + " - Counter: " + counter);
			} finally {
				lock.writeLock().unlock();
			}
		}

		public int getCounter() {
			lock.readLock().lock();
			try {
				return counter;
			} finally {
				lock.readLock().unlock();
			}
		}
	}

	public class AtomicIntegerExample {

		private final AtomicInteger counter = new AtomicInteger(0);

		public void increment() {
			int newValue = counter.incrementAndGet();
			System.out.println(Thread.currentThread().getName() + " - Counter: " + newValue);
		}
	}

	private static void multiThreading() throws InterruptedException {

		Practice threadPractice = new Practice();

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

		// Creating ThreadGroups
		ThreadGroup parentGroup = new ThreadGroup("Parent Group");
		ThreadGroup group1 = new ThreadGroup(parentGroup, "Group 1");
		ThreadGroup group2 = new ThreadGroup(parentGroup, "Group 2");

		// Obtain the estimated number of active groups in a thread group.
		int activeGroups = parentGroup.activeGroupCount();
		System.out.println("Active Groups: " + activeGroups);

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
		// Retrieve number of active threads in "Group" thread group
		int activeThreads = group.activeCount();
		System.out.println("Active Threads: " + activeThreads);

		// Copy into the specified array every active thread in the group
		Thread[] threads = new Thread[group.activeCount()];
		group.enumerate(threads);
		for (Thread t : threads) {
			System.out.println("Thread name: " + t.getName());
		}
		thread1.join();
		thread2.join();

		// Set ThreadLocal variable for main thread
		threadLocal.set(100);
		System.out.println("Main Thread Value: " + threadLocal.get());

		Thread thread3 = new Thread(() -> {
			// Set ThreadLocal variable for thread 3
			threadLocal.set(200);
			System.out.println("Thread 3 Value: " + threadLocal.get());
		});

		Thread thread4 = new Thread(() -> {
			// Set ThreadLocal variable for thread 4
			threadLocal.set(300);
			System.out.println("Thread 4 Value: " + threadLocal.get());
		});

		thread3.start();
		thread4.start();

		System.out.println("Main Thread Initial Value: " + threadLocal2.get());

		Thread thread5 = new Thread(() -> {
			threadLocal.set(threadLocal2.get() + 1);
			System.out.println("Thread 1 Incremented Value: " + threadLocal.get());
		});

		Thread thread6 = new Thread(() -> {
			threadLocal.set(threadLocal2.get() + 2);
			System.out.println("Thread 2 Incremented Value: " + threadLocal.get());
		});

		thread5.start();
		thread6.start();

		threadLocal3.set(42);
		System.out.println("Main Thread value: " + threadLocal3.get());
		Thread childThread = new Thread(() -> {
			System.out.println("Child Thread Value: " + threadLocal3.get());
		});
		childThread.start();

		// Create a fixed thread pool with 2 threads
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		// Submit tasks to the executor service
		executorService.submit(() -> System.out.println("Task 1 executed by " + Thread.currentThread().getName()));
		executorService.submit(() -> System.out.println("Task 2 executed by " + Thread.currentThread().getName()));
		executorService.submit(() -> System.out.println("Task 3 executed by " + Thread.currentThread().getName()));

		// Submitting a Runnable task to ExecutorService.
		Future<?> future1 = executorService.submit(() -> {
			System.out.println("Runnable task executed by " + Thread.currentThread().getName());
		});

		// Submitting a Callable task to the ExecutorService.
		Future<String> future2 = executorService.submit(() -> {
			System.out.println("Callable task executed by " + Thread.currentThread().getName());
			return "Result from Callable task";
		});

		String result;
		try {
			result = future2.get();
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		executorService.shutdown();

		ExecutorService executorService2 = Executors.newFixedThreadPool(3);

		IntStream.range(1, 6).forEach((i) -> {
			Task task = threadPractice.new Task("Task " + i);
			executorService2.submit(task);
		});

		executorService2.shutdown();

		// Gracefully shutdown threadExecutor
		try {
			if (!executorService2.awaitTermination(60, TimeUnit.SECONDS)) {
				executorService2.shutdownNow();
			}
		} catch (InterruptedException e) {
			executorService2.shutdownNow();
		}
		System.out.println("All  tasks are finished !");

		// Another CallableFuture demo
		ExecutorService executorService3 = Executors.newFixedThreadPool(3);

		Future<String> future3 = executorService3.submit(threadPractice.new CallableTask("Task 3"));
		Future<String> future4 = executorService3.submit(threadPractice.new CallableTask("Task 4"));

		try {
			System.out.println(future3.get());
			System.out.println(future4.get());

		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			executorService.shutdown();
		}

		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

		// Schedule a task to run every 3 seconds, with an initial delay of 2 seconds
		scheduledExecutorService.scheduleAtFixedRate(() -> {
			System.out.println("Fixed rate task executed at " + System.currentTimeMillis());
		}, 2, 3, TimeUnit.SECONDS);

		// Let the main thread sleep for 10 seconds to observe the scheduled task
		// execution
		Thread.sleep(10000);

		scheduledExecutorService.shutdown();

		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<Integer> future = executor.submit(threadPractice.new MyCallable());

		System.out.println("Task submitted.");

		Integer result2 = null;
		try {
			result2 = future.get(2, TimeUnit.SECONDS);
			System.out.println("Task completed with result: " + result2);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			System.out.println("Task timed out. Cancelling...");
			future.cancel(true);
			e.printStackTrace();
		} finally {
			executor.shutdown();
		}

		if (future.isCancelled()) {
			System.out.println("Task was cancelled.");
		} else if (future.isDone()) {
			System.out.println("Task completed.");
		}

		// Creating a cached thread pool
		ExecutorService executorServiceCached = Executors.newCachedThreadPool();

		for (int i = 1; i <= 5; i++) {
			final int taskId = i;
			executorServiceCached.submit(() -> {
				System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
			});
		}
		executorServiceCached.shutdown();

		// ReentrantLock example
		ReentrantLockExample example = threadPractice.new ReentrantLockExample();
		Runnable task = () -> {
			for (int i = 0; i < 5; i++) {
				example.increment();
			}
		};

		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);

		t1.start();
		t2.start();

		// ReadWriteLock Example
		ReadWriteLockExample example2 = threadPractice.new ReadWriteLockExample();

		Runnable writeTask = () -> {
			for (int i = 0; i < 5; i++) {
				example.increment();
			}
		};

		Runnable readTask = () -> {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + " - Counter: " + example2.getCounter());
			}
		};

		Thread t5 = new Thread(writeTask);
		Thread t6 = new Thread(readTask);

		t5.start();
		t6.start();

		AtomicIntegerExample example3 = threadPractice.new AtomicIntegerExample();
		Runnable task2 = () -> {
			for (int i = 0; i < 5; i++) {
				example3.increment();
			}
		};

		Thread t7 = new Thread(task2);
		Thread t8 = new Thread(task2);

		t7.start();
		t8.start();

	}

	public static void main(String[] args) throws InterruptedException {

		multiThreading();
	}
}