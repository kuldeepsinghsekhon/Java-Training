package tread1;

public class ThreadSleep2 extends Thread{
	public ThreadSleep2(String name) {
		super(name);
			}
	@Override
	public void run() {
		try {
			for (int i = 1; i < 20; i++) {
				System.out.println("Thread Sleep2 " + "T" + i);
				sleep(1000);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
