package thread;

public class ExtendsThread extends Thread{
	
	public void run() {
		for (int i = 1; i < 10; i++) {
			
			System.out.println(" Thread Running ");
		}	
	}
	public static void main(String[] args) {
		ExtendsThread tho=new ExtendsThread();
		tho.start();
	}

}
