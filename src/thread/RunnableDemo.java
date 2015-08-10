package thread;

public class RunnableDemo implements Runnable {

	public static void main(String[] args) {
		RunnableDemo rdo =new RunnableDemo();
		Thread t =new Thread(rdo);
		t.start();

	}

	@Override
	public void run() {
		for (int i = 1; i < 10; i++) {
			
			System.out.println(" Thread Running ");
		}	
	}

}
