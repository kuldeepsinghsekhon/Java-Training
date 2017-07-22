package file;
import java.io.*;
public class SequenceMerge {
    public static void main(String[] args) throws IOException {
			FileInputStream fis1 = new FileInputStream("RandomFile.java");
           FileInputStream  fis2 = new FileInputStream("WordByWord.java");
            FileOutputStream out = new FileOutputStream("sequenceout.txt");
			SequenceInputStream sis= new SequenceInputStream(fis1,fis2);
            int c;
            while ((c = sis.read()) != -1) {
                out.write(c);
            }
    }
}
