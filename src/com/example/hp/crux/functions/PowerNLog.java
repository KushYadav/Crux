package com.example.hp.crux.functions;

public class PowerNLog {

	public static void main(String[] args) {
		int x = 3, n = 5;
		System.out.println(power(x, n));

		int a = 243, b = 3;
		System.out.println(log(a, b));
	}

	private static int power(int x, int n) {
//		x ^ n -> Xor
		int val = x;
		int counter = 1;
		while (counter < n) {
			val *= x;
			counter++;
		}
		return val;
	}

	private static int log(int a, int b) {
		int counter = 1;
		while (power(b, counter) != a) {
			counter++;
		}
		return counter;
	}
}
