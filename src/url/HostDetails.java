package url;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostDetails {
	public static void main(String arg[]) {
		try {
			//Applications should use the methods getLocalHost, getByName, or getAllByName to create a new InetAddress instance.
			InetAddress ia = InetAddress.getByName("java.sun.com");
			System.out.println("Host Name" + ia.getHostName());
			System.out.println("IP Address" + ia.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
