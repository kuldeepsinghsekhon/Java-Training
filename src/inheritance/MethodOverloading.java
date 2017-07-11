public class MethodOverloading{
	public double area(double k, double l)
	{
		return k*l;
	}
	public double area(double s){
		return s*s;
	}
	public static void main (String arg[])
	{
		MethodOverloading obj= new MethodOverloading();
		System.out.println(obj.area(50));
		System.out.println(obj.area(10,10));
	}
}