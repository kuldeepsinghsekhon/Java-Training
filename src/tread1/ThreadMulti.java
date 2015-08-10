package tread1;

public class ThreadMulti {

	public static void main(String[] args) {
		Thread1 th1 =new Thread1("Thread 1");
		Thread2 th2 =new Thread2("Thread 2");
		th2.start();
		th1.start();
		
		System.out.println("Thread working finish");

	}

}
