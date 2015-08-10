package thread;
class ThreadOne extends Thread{
	ThreadOne(String msg){
		super(msg);
	}
	@Override
	public void run(){
	for (int i=1;i<10;i++){
		try {
			sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"Thread running");
	}
	}
}
class ThreadTwo extends Thread{
	ThreadTwo(String msg){
		super(msg);
	}
	@Override
	public void run(){
		try {
			sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	for (int i=1;i<10;i++){
		
		System.out.println(Thread.currentThread().getName()+"Thread running");
	}
	}
}

class ThreadThree extends Thread{
	ThreadThree(String msg){
		super(msg);
	}
	@Override
	public void run(){
		try {
			sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	for (int i=1;i<10;i++){
		
		System.out.println(Thread.currentThread().getName()+"Thread running");
	}
	}
}
public class TreadPriority {

	public static void main(String[] args) {

		ThreadOne t_one= new ThreadOne(" First");
		ThreadTwo t_two=new ThreadTwo("Second ");
		ThreadThree t_three =new ThreadThree("Third ");
		ThreadThree t_three1 =new ThreadThree("Fourth ");
	
		
		t_one.setPriority(1);
		t_two.setPriority(Thread.NORM_PRIORITY);
		
		t_three1.setPriority(Thread.MIN_PRIORITY);
		t_three.setPriority(Thread.MAX_PRIORITY);
		t_one.start();
		t_two.start();
		t_three.start();
		t_three1.start();
	}

}
