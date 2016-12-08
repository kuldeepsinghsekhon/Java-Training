package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class CopyChar {

	public static void main(String[] args)throws IOException {
		FileReader filein=null;
		FileWriter fout =null;
		File f=new File("hello.txt");
try {
	filein =new FileReader(f);
	 fout =new FileWriter("hello2.txt",true);
	int c;
		while((c=filein.read())!=-1){
		fout.write(c);
			System.out.print((char)c);
		}
	} catch (IOException e) {
		e.printStackTrace();
	}finally{
		if(filein!=null){
		filein.close();
		}
		if(fout!=null){
			fout.close();
		}
	}

	}

}
