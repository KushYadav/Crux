package com.example.hp.crux.basics;

import java.util.Scanner;

public class PatternCross {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter no. of Rows: ");
		int n = scn.nextInt();
		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= n; col++) {
				if (col == row || (n - row + 1) == col) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
