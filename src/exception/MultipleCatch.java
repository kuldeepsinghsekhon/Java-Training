
package exception;

public class MultipleCatch {

    public static void main(String args[]) {
        int j[] = {5, 6, 8, 2, 1};
        int i = 10, k = 5, r = 0;
        try {
            r = i / (j[10] - k);
            System.out.println("result is" + r);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            System.out.println("You have aithmatic exception");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println("Yor trying to access wrong index of array");
        } finally {
            System.out.println("I will always execute");
        }
        System.out.println("rest of the code...");
    }
}
