package innerclasses;
abstract class AnonymousClass {
   public abstract void mymethod();
}

public class Anonymous_Outer_class{

   public static void main(String args[]) {
      AnonymousClass inner = new AnonymousClass() {
         public void mymethod() {
            System.out.println("This is an example of anonymous inner class");
         }
      };
      inner.mymethod();	
   }
}