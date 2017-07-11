import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;

public class StreamTokenizerDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		Reader reader = new FileReader("hello.txt");
			StreamTokenizer streamTokenizer =  new StreamTokenizer(reader);
			
		    while(streamTokenizer.nextToken() != StreamTokenizer.TT_EOF){
		    
		        if(streamTokenizer.ttype == StreamTokenizer.TT_WORD) {
		            System.out.println(streamTokenizer.sval);
		        } else if(streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
		            System.out.println(streamTokenizer.nval);
		        } else if(streamTokenizer.ttype == StreamTokenizer.TT_EOL) {
		            System.out.println();
		        }   
		}
	}

}
