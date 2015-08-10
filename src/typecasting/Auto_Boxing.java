package typecasting;
 class Auto_Boxing {
public static void main(String []args)
{ 
	String is = "45";
int i = Integer.parseInt(is);
byte b = Byte.parseByte(is);
float f = Float.parseFloat(is);
double d = Double.parseDouble(is);
System.out.println("This is unboxing of i"+i);
System.out.println("This is unboxing of b"+b);
System.out.println("This is unboxing of f"+f);
System.out.println("This is unboxing of d"+d); //Unboxing

String s = Integer.toString(i);
s = Byte.toString(b);
s = Float.toString(f);
s=Double.toString(d);
s = Integer.toString(i);
System.out.println("This is boxing of s"+ s);//Boxing


}

}

