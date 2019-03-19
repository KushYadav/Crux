package com.example.hp.crux.functions;

import java.util.Scanner;

public class GCDnLCM {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n1 = scn.nextInt();
		int n2 = scn.nextInt();
		System.out.println(GCD(n1, n2));
		System.out.println(LCM(n1, n2));
	}

	private static int GCD(int n1, int n2) {
		int rem = -1;
		while (rem != 0) {
			rem = n2 % n1;
			n2 = n1;
			n1 = rem;
		}
		return n2;
	}

	private static int LCM(int n1, int n2) {
		return n1 * n2 / GCD(n1, n2);
	}
}
