package innerclasses;
// interface
interface Message {
   String greet();
}

public class Anonymous_outer_class2 {
   // method which accepts the object of interface Message
   public void displayMessage(Message m) {
      System.out.println(m.greet() +
         ", This is an example of anonymous inner class as an argument");  
   }

   public static void main(String args[]) {
      // Instantiating the class
      Anonymous_outer_class2 obj = new Anonymous_outer_class2();

      // Passing an anonymous inner class as an argument
      obj.displayMessage(new Message() {
         public String greet() {
            return "Hello";
         }
      });
   }
}