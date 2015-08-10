package in18;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

	public static void main(String[] args) {
		String language=new String("hi");
		String country="IN";
		Locale local=new Locale(language,country);
ResourceBundle resourceBubdle= ResourceBundle.getBundle("Message",local);
System.out.println(resourceBubdle.getString("msg"));
	}

}
