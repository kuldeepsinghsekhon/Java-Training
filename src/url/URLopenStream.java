package url;
import java.net.*;
import java.io.*;
public class URLopenStream {
	 public static void main(String[] args)throws Exception {
		    URL url = new URL("http://javaexpertshub.blogspot.in/");
			//openStream() method open Stream and get data 
		     BufferedReader in = new BufferedReader(
		        new InputStreamReader(url.openStream()));
				
				String inputLine;
		        while ((inputLine = in.readLine()) != null)
		            System.out.println(inputLine);
			
		        in.close();
		  }
}
