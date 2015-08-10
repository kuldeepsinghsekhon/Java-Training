package url;
import java.net.*;
import java.io.*;
public class URL_New {
public static void main(String[]args) throws Exception
{
URL aURL = new URL("http://google.com:80/docs.books"+"/index.html?name=networking#DOWNLOADS");
System.out.println("Protocol is "+aURL.getProtocol());
System.out.println("Authority"+aURL.getAuthority());
System.out.println("Host"+aURL.getHost());
System.out.println("port"+aURL.getPort());
System.out.println("Path"+aURL.getPath());
System.out.println("Query"+aURL.getQuery());
System.out.println("Filename"+aURL.getFile());
System.out.println("Ref"+aURL.getRef());
}
}
