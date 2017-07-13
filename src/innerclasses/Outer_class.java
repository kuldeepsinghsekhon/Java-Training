package innerclasses;
public class Outer_class {
   int num;
   
   // inner class
   private class Inner_class {
      public void print() {
         System.out.println("This is an inner class");
      }
   }
   
   // Accessing he inner class from the method within
   void display_Inner() {
      Inner_class inner = new Inner_class();
      inner.print();
   }
   public static void main(String args[]) {
      // Instantiating the outer class 
      Outer_class outer = new Outer_class();
      // Accessing the display_Inner() method.
      outer.display_Inner();
	  Outer_class.Inner_class inner =  outer.new Inner_class();
	  inner.print();
   }
}
   
