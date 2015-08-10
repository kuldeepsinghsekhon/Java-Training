package windows.resources;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
 
public class ProgramFinder 
{
 
	public static void main(String args[]) 
	{ 
	try 
	{ 
	Process p=Runtime.getRuntime().exec("cmd /c  notepad"); 
	p.waitFor(); 
	BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream())); 
	String line=reader.readLine(); 
	while(line!=null) 
	{ 
	System.out.println(line); 
	line=reader.readLine(); 
	} 

	} 
	catch(IOException e1) {} 
	catch(InterruptedException e2) {} 

	System.out.println("Done"); 
	} 
}


