package com.example.hp.crux.misc;

import java.math.BigInteger;

public class BigIntegerOps {

	public static void main(String[] args) {
//		BigIntegers are immutable ie their internal state cannot be changed.
		BigInteger a = new BigInteger("1234");
		BigInteger b = BigInteger.TEN;
		a.add(b);
		System.out.println(a);// Value won't change as immutable.

		BigInteger c = a.add(b);
		System.out.println(c);

		BigInteger d = a.divide(b);
		System.out.println(d);

		BigInteger e = a.mod(b);
		System.out.println(e);

		BigInteger f = a.gcd(b);
		System.out.println(f);

		BigInteger[] g = a.divideAndRemainder(b);
		System.out.println(g[0] + "," + g[1]);

		BigInteger[] h = a.sqrtAndRemainder();
		System.out.println(h[0] + "," + h[1]);

		System.out.println(a.isProbablePrime(0)); // parameter us certainity, more certainity more accuracy.
													// Probability=(1-(1/2)^certainity)

		// Programs
		System.out.println("=====================");
		System.out.println(factorial(500));
		System.out.println();
		fibonacci(500);
	}

	private static BigInteger factorial(int n) {
		if (n == 0) {
			return BigInteger.ONE;
		}
		return BigInteger.valueOf(n).multiply(factorial(n - 1));
	}

	private static void fibonacci(int n) {
		BigInteger a = BigInteger.ZERO;
		BigInteger b = BigInteger.ONE;
		for (int i = 0; i < n; i++) {
			System.out.println(a);
			b = a.add(a = b);
		}
	}
}
