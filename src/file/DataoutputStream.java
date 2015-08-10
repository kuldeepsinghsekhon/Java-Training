package file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DataoutputStream  {

	public static void main(String[] args) throws Exception{
		 File file =new File("C:\\Users\\kuldeep\\Desktop\\dataFile");
		 if(!file.exists()){
			 throw new  Exception();
		 }
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(
	              new FileOutputStream(file,true)));

	

	
	    out.writeDouble(4);
	    out.writeInt(4);
	    out.writeUTF(in.readLine());
	
out.close();
	}

}
