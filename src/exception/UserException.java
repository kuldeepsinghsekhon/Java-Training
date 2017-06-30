package exception;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class AgeException extends Exception{
    AgeException(String msg){
        super(msg);
    }
}
public class UserException {
    public void drivingTest()throws IOException,AgeException{
        int age=0;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("Enter the Your Age");
        String s = br.readLine();
        age=Integer.parseInt(s);
        if(age<16){
           throw new AgeException("you are not eligible for driving test");
        }else{
            System.out.println("Welcome for driving test");
        }
    }
    public static void main(String[] args) {
        UserException ux=new UserException();
        try {
            ux.drivingTest();
        } catch (AgeException ex) {
           System.out.println(ex.getMessage());
        } catch (IOException e) {
          System.out.println(e.getMessage());
        }
    }
}
