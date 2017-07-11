package inheritance;
class Parent{
	int i=10;
	public void message(){
		System.out.println("value of i in Parent is" +i);
	}
}
class InheritanceOverriding extends Parent{
	int i=20;
public void message(){
	System.out.println("value of i in Inheritance1 is:" +i);
}
public static void main (String args[]){
	InheritanceOverriding ch=new InheritanceOverriding();
	ch.message();
}
}
