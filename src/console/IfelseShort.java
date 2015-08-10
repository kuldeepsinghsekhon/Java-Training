package console;
import java.io.Console;


public class IfelseShort {

	public static void main(String[] args) {
		
int i=10,j=5;
Console c= System.console();
if(c==null){
	 System.err.println("No console.");
     System.exit(1);
    
}
i=Integer.parseInt(c.readLine("Enter value of I"));
j=Integer.parseInt(c.readLine("Enter value of I"));
System.out.println((i<j)?"i is less than j":"i is greater than j");
int[] numbers = {1,2,3,4,5,6,7,8,9,10};
for(int item : numbers) {
System.out.println("Count is: " + item);
}

	}
	

}
