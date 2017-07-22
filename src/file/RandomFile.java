package file;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.io.IOException;
public class RandomFile {
	public static void main(String[] args)throws IOException {
		RandomAccessFile rwfile=null;
		File f=new File("hello.txt");
		try {
			rwfile =new RandomAccessFile(f,"rw");
			rwfile.writeChar('c');
			rwfile.writeDouble(3.1412);
			rwfile.writeInt(1212);
			rwfile.seek(0);
			//reading file
			System.out.println(rwfile.readChar()+"\n"+rwfile.readDouble()+"\n"+rwfile.readInt());
			rwfile.seek(rwfile.length());
			rwfile.writeBoolean(false);
			System.out.println("Reaing Last Location");
			rwfile.seek(3);
			System.out.println(rwfile.readBoolean());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
