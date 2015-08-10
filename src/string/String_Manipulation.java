package string;

public class String_Manipulation {
public static void main(String[]args)
{
String s1  = "Hello how are you deep";
String s2 = "Bye";
String s3="BYE";
int a= 7;
System.out.println(s1.toUpperCase());
System.out.println(s1.toLowerCase());
System.out.println(s1.equals(s2));
System.out.println(s2.equalsIgnoreCase(s3));
System.out.println(s1.indexOf('o'));
System.out.println(String.valueOf(a));
System.out.println(s2.trim());
System.out.println(s1.charAt(3));
System.out.println(s1.concat(s2));
System.out.println(s1.substring(7));
System.out.println(s1.length());
System.out.println(s1.substring(7,14));
}
}
