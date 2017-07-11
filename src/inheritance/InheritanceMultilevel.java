package inheritancs;
class InheritanceA{
	public void messageA(){
		System.out.println("show from classA and messageA");
	}
}
 class InheritanceB extends InheritanceA{
	public void messageB(){
		System.out.println("InheritanceB and InheritanceA");
	}
	public static void main(String args[]){
		InheritanceB obj= new InheritanceB();
		obj.messageA();
	}
		
	}
	public class InheritanceMultilevel extends InheritanceB
	{
		public void messageC()
		{
			System.out.println("InheritanceC and InheritanceB");
		}
		public static void main(String args[]){
		InheritanceMultilevel obj1= new InheritanceMultilevel();
		obj1.messageB();

	
	}
		
	}
	
	
		
		
		
		
		
		
		
		
		
