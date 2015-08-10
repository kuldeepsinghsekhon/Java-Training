package socket;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Tested{
	public static void main (String []arg){
		try {
			ServerSocket ss = new ServerSocket(1444);
			Socket s = ss.accept();
			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 
			   String MsgIn="",MsgOut="";
			   
			   while(!MsgIn.equals("end")){
				   MsgIn = din.readUTF();
				   System.out.println(MsgIn);
				   MsgOut = br.readLine();
				   dos.writeUTF(MsgOut);
				   dos.flush();
			   }
			   s.close();	   
		   }catch(Exception e){
		}
		
	}

}
