
package exception;

public class TryCatchFinally {

    public static void main(String args[]) {
       
        int i = 10,j=5, k = 5, r = 0;
        try {
            r = i / (j - k);
            System.out.println("result is" + r);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            System.out.println("You have aithmatic exception");
        } finally {
            System.out.println("I will always execute");
        }
        System.out.println("rest of the code...");
    }
}
