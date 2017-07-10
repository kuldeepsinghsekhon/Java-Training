package url;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLconnect {
	public static void main(String[] args)throws Exception {
	    URL url = new URL("http://javaexpertshub.blogspot.in/");
		URLConnection myURLConnection =url.openConnection();
	    myURLConnection.connect();
	     BufferedReader in = new BufferedReader(
	        new InputStreamReader(myURLConnection.getInputStream()));
			String inputLine;
	        while ((inputLine = in.readLine()) != null)
	            System.out.println(inputLine);		
	        in.close();
	  }
}
