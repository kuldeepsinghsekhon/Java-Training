package staticdemo;
/*
        The static variable gets memory only once in class area at the time of class loading.
*/
public class StaticDemo {
	
	//Static
	int k=10;
	int l=10;
	int sum2(int m,int n){
		k=m;
		l=n;
		return k+l;
	}
	int sum3(){
		
		return k+l;
	}
////////////////////////////////////////////////////////////////////////////////////
	static int i=10;
	static int j=10;
	
	static int sumnum(int x,int y){
		i=4;
		 j=5;
		return i+j;
	}
	static int sumnum1(){
		
		return i+j;
	}

	public static void main(String[] args) {
StaticDemo obj1=new StaticDemo();
StaticDemo obj2=new StaticDemo();
System.out.println("call of Static sumnum  " +obj1.sumnum(4,5));
System.out.println("call of Static sumnum1  " +obj2.sumnum1());
//////////////////////////////////////////////////////////////
StaticDemo obj3=new StaticDemo();
StaticDemo obj4=new StaticDemo();
System.out.println("Sum of int k l : " +obj3.sum2(4,5));
System.out.println("Sum of int k l : " +obj4.sum3());
	}

}
