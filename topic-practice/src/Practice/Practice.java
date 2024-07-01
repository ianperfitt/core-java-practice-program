package Practice;

public class Practice {

	public class MyThread extends Thread {

		@Override
		public void run() {
			System.out.println("Thread created by extending Thread class is running !");

		}

	}

	public static void main(String[] args) {

		// Multi-threading:
		//
		// 1. Create and run a thread t1 by extending the Thread class.
		Practice p = new Practice();
		MyThread t1 = p.new MyThread();
		t1.start();

		// Multi-threading:
		//
		// 2. Create and run a thread t2 by implementing the Runnable class using
		// Lambda.
		Runnable runnable = () -> System.out.println("Thread created by implementing Runnable interface via lambda");
		Thread t2 = new Thread(runnable);
		t2.start();

		// Multi-threading:
		//
		// 3. Put t1 to sleep for 1 second.
		try {
			t1.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Multi-threading:
		//
		// 4. Interrupt a thread's execution.
		t2.interrupt();

		// Multi-threading:
		//
		// 5. Tell t1 to wait until being notified.
		try {
			t1.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Multi-threading:
		//
		// 5. Tell t1 to wait until being notified or until 1sec has passed.
		try {
			t1.wait(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Multi-threading:
		//
		// 6. Notify t1 to begin execution.
		t1.notify();

		// Multi-threading:
		//
		// 7. Verify if t1 is running.
		t1.isAlive();

		// Multi-threading:
		//
		// 8. Set t1's name to "Thread 1"
		t1.setName("Thread 1");

		// Multi-threading:
		//
		// 9. Set t1 to highest priority
		t1.setPriority(10);

		// Multi-threading:
		//
		// 10. Set t1 to lowest priority
		t1.setPriority(1);

		// Multi-threading:
		//
		// 10. Set t1 to default priority
		t1.setPriority(5);

		// Multi-threading:
		//
		// 10. Ensure that t1 finishes before main thread (or other threads complete)
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}