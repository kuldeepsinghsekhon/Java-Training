package socket;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class Client_Tested  {
	public static void main(String arg []) {
		try{
		Socket s = new Socket("192.168.1.128",1444);

		 DataInputStream Din = new DataInputStream(s.getInputStream());
		 DataOutputStream Dout = new DataOutputStream(s.getOutputStream());
		 
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 String MsgIn="",MsgOut="";

		 while(!MsgIn.equals("end")){
			 MsgOut = br.readLine();
			 Dout.writeUTF(MsgOut);
			 MsgIn = Din.readUTF();
			 System.out.println(MsgIn);
		 }
	 }catch(Exception e){
		 
	 }
	}

}
