package tread1;
import java.lang.Thread;
public class Thread1 extends Thread{
	public Thread1(String name) {
		super(name);
			}
	@Override
	public void run() {
		for(int i=1;i<20;i++){
			System.out.println("Thread one " + "T"+i);
			
		}
		try {
			wait(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i=1;i<20;i++){
			System.out.println("Thread one " + "T"+i);
			
		}
		
	}

}
