package console;
import java.io.*;
import java.util.Scanner;

public class InputByScanner {
	public static void main(String ars[]) throws IOException {
		Scanner s = null;
		try {
			s = new Scanner(System.in);
			System.out.println("Enter Next String Value");
			System.out.println(s.next());
			System.out.println("Enter Next Byte Value");
			System.out.println(s.nextByte());
			System.out.println("Enter Next Short Value");
			System.out.println(s.nextShort());
			System.out.println("Enter Next Integer Value");
			System.out.println(s.nextInt());
			System.out.println("Enter Next Long Value");
			System.out.println(s.nextLong());
			System.out.println("Enter Next Float Value");
			System.out.println(s.nextFloat());
			System.out.println("Enter Next Double Value");
			System.out.println(s.nextDouble());
			System.out.println("Enter Next Line Value");
			String str = s.nextLine();
			System.out.println(str);
			System.out.println("Enter Next Boolean Value");
			System.out.println(s.nextBoolean());
			//other method include hasNext(), hasInt(), hasNextLine(), hasNextDoble() etc....
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}
}
