package tutorials;
class Shared {
  synchronized void call(String msg) {
    System.out.println("Start" );
    for(int i=1;i<10;i++){
    	   System.out.println(msg);
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      System.out.println("Interrupted");
    }
    }
    System.out.println("end");
  }
}

class Caller implements Runnable {
  String msg;
  Shared target;
  Thread t;

  public Caller(Shared targ, String s) {
    target = targ;
    msg = s;
    t = new Thread(this);
    t.start();
  }

  public void run() {
    target.call(msg);
  }
}

public class Main {
  public static void main(String args[]) {
    Shared target = new Shared();
    Caller ob1 = new Caller(target, "A");
    Caller ob2 = new Caller(target, "B");

    try {
      ob1.t.join();
      ob2.t.join();
    } catch (InterruptedException e) {
      System.out.println("Interrupted");
    }
  }
}