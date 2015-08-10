package url;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;


public class URL_reader {
	public static void main(String arg []) {
		try{
			
		
		URL ur = new URL("http://go.microsoft.com/fwlink/?LinkId=69157");	
		BufferedReader in=new BufferedReader(new InputStreamReader(ur.openStream()));
		String  s;
		while((s=in.readLine()) !=null){
			System.out.println(s);
		}
	}	catch (Exception  e){
		
	}
	
	}
}

	   
	
