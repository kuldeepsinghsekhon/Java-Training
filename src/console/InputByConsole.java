package console;
import java.io.Console;
public class InputByConsole {
	public static void main(String[] args) {
		int i = 10, j = 5;
		Console c = System.console();
		if (c == null) {
			System.err.println("No console.");
			System.exit(1);
		}
		System.out.println("Enter password");
		String s=new String(c.readPassword());
		System.out.println("password is "+ s);
		i = Integer.parseInt(c.readLine("Enter value of I"));
		j = Integer.parseInt(c.readLine("Enter value of I"));
		System.out.println((i < j) ? "i is less than j" : "i is greater than j");
	}
}
