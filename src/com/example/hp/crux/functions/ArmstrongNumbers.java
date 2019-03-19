package com.example.hp.crux.functions;

public class ArmstrongNumbers {

	public static void main(String[] args) {
		System.out.println(isArmStrong(153));
		printArmstrong(0, 1000);
	}

	private static boolean isArmStrong(int n) {
		int nod = 0;
		int temp = n;
		while (temp != 0) {
			temp /= 10;
			nod++;
		}
		temp = n;
		int sum = 0;
		while (temp != 0) {
			int rem = temp % 10;
			temp /= 10;
			sum += Math.pow(rem, nod);
		}
		return sum == n ? true : false;
	}

	private static void printArmstrong(int n1, int n2) {
		for (int i = n1; i <= n2; i++) {
			if (isArmStrong(i)) {
				System.out.print(i + " ");
			}
		}
	}
}
