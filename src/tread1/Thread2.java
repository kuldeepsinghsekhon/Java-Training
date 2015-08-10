package tread1;

public class Thread2 extends Thread{
	public Thread2(String name) {
super(name);
	}

	@Override
	public void run() {
		for(int i=1;i<20;i++){
			System.out.println("Thread Two " + "T"+i);
			notifyAll();
		}
	}

}
