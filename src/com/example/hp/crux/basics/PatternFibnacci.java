package com.example.hp.crux.basics;

import java.util.Scanner;

public class PatternFibnacci {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter no. of Rows: ");
		int n = scn.nextInt();
		int a = 0, b = 1;

		int row = 1;
		while (row <= n) {
			int col = 1;
			while (col <= row) {
				System.out.print(a + " ");
				b = a + (a = b);
				col++;
			}
			row++;
			System.out.println();
		}
	}
}
