package exception;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class ThrowsException {
    public void divison()throws Exception{
         int i = 10, j = 5, k = 5, r = 0;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("Enter the value of j");
        String s = br.readLine();
        j = Integer.parseInt(s);
             r = i / (j - k);
            System.out.println("Result is" + r);
    }
    public static void main(String[] args) {
       ThrowsException te=new ThrowsException();
        try {
            te.divison();
        } catch (Exception ex) {
           System.out.println(ex.getMessage());
        }
    }
}
