package classt;

public class BasicClass {

	int i=19;
	int j=3;
	int area(){
		return i*j;
	}
	public static void main(String[] args) {
		BasicClass obj1 =new BasicClass();
		//obj1.i=10;
		//obj1.j=20;
		System.out.println(obj1.area());

	}

}
