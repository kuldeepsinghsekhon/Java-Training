package tread1;

public class ThreadSleep1 extends Thread {
	public ThreadSleep1(String name) {
		super(name);
	}

	@Override
	public void run() {
		try {
			for (int i = 1; i < 20; i++) {
				System.out.println("Thread Sleepone " + "T" + i);
				sleep(1000);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
