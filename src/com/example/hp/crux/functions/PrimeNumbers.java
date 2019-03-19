package com.example.hp.crux.functions;

public class PrimeNumbers {

	public static void main(String[] args) {
		System.out.println(isPrime(1));
		printPrimes(0, 100);
	}

	private static boolean isPrime(int n) {
		boolean isPrime = true;
		int counter = 2;

		while (counter * counter <= n) {
			if (n % counter == 0) {
				isPrime = false;
				break;
			}
			counter++;
		}
		if (n < 2) {
			isPrime = false;
		}
		return isPrime;
	}

	private static void printPrimes(int n1, int n2) {
		for (int i = n1; i <= n2; i++) {
			if (isPrime(i)) {
				System.out.print(i + " ");
			}
		}
	}
}
