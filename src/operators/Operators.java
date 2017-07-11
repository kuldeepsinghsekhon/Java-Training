package operators;
class Operators {
	public static void main(String args[]) {

		int a = 10, b = 20, c = 30;
		// Arithmetic Operators
		System.out.println("Addition of a and b is" + " " + (a + b));
		System.out.println("Substraction of a and b is" + " " + (a - b));
		System.out.println("Multiplication of a and b is" + " " + (a * b));
		System.out.println("Division of a and b is" + " " + (a / b));
    System.out.println("Division of a and b is" + " " + (a % b));
    
		// Unary Operators
		System.out.println(a++);
		System.out.println(++a);
		System.out.println(a--);
		System.out.println(--a);

		// Relational Operators With Condition
		if (a == b)
			System.out.println("a==b");
		if (a <= b)
			System.out.println("a<=b");
		if (a < b)
			System.out.println("a<b");
		if (a > b)
			System.out.println("a>b");
		if (a != b)
			System.out.println("a!=b");

		// Logical Operators
		System.out.println(a < b && b > c);
		System.out.println(a > b || b > c);

		// Bitwise Operators
		System.out.println(a < b ^ b < c);
		System.out.println(a < b | b < c);
		System.out.println(a < b & b < c);

		// Ternary Operators
		System.out.println((a < b) ? a : b);

		// Shift Operators
		System.out.println(a >> b);
		System.out.println(a << b);
		System.out.println(a >>> b);

		// Assignment Operators
		System.out.println(a = b);
		System.out.println(a += b);
		System.out.println(a -= b);
		System.out.println(a *= b);
		System.out.println(a /= b);
		System.out.println(a %= b);
		System.out.println(a &= b);
		System.out.println(a ^= b);
		System.out.println(a |= b);
		System.out.println(a <<= b);
		System.out.println(a >>= b);
		System.out.println(a >>>= b);
	}
}
