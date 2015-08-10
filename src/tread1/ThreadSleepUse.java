package tread1;

public class ThreadSleepUse {

	public static void main(String[] args) {
		ThreadSleep1 ths1 =new ThreadSleep1("Sleep1");
		ThreadSleep2 ths2 =new ThreadSleep2("Sleep2");
		ths1.start();
		
		ths2.start();
	}

}
