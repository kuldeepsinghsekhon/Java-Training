package thread;
public class TreadSleep extends Thread  {

	public static void main(String[] args) throws InterruptedException {
for (int i = 1; i < 10; i++) {
			
			sleep(1000);
			if (Thread.interrupted()) {
				System.out.println("intruupted");
								return;
						    }
			System.out.println("Main Thread awake " + i);
		}
		ThreadOne1 t_one=new ThreadOne1("First");
		t_one.start();
		
	}

}

class ThreadOne1 extends Thread{
	ThreadOne1(String msg){
		super(msg);
	}
	@Override
	public void run(){
	for (int i=1;i<10;i++){
		try {
			
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"Thread running");
	}
	}
}