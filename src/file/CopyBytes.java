package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class CopyBytes {

	public static void main(String[] args)throws IOException {
		FileInputStream filein=null;
		FileOutputStream fout =null;
		File f=new File("C:\\Users\\kuldeep\\Desktop\\hello.txt");
try {
	filein =new FileInputStream(f);
	 fout =new FileOutputStream("C:\\Users\\kuldeep\\Desktop\\deep.mp3");
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
