/* StringTokenizer(String str, String deliminator, boolean returnDeliminator)	 
		 boolean hasMoreTokens()	checks if there is more tokens available. 
		 String nextToken()	returns the next token from the StringTokenizer object.
		 String nextToken(String delim)	returns the next token based on the delimeter.
		 boolean hasMoreElements()	same as hasMoreTokens() method. 
		 Object nextElement()	same as nextToken() but its return type is Object.
		 int countTokens()	returns the total number of tokens.*/
package string;
import java.util.StringTokenizer;

public class StringTokenizerDemo {
	 public static void main(String args[]){  
        
		   StringTokenizer st = new StringTokenizer("hello,how,are students ?","/,",true);  
	         System.out.println("Number of token "+st.countTokens());
		   while (st.hasMoreTokens()) {  
		         System.out.println(st.nextToken());
		     }  
		   }  
}
