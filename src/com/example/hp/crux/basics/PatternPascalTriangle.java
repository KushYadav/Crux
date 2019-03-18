package com.example.hp.crux.basics;

import java.util.Scanner;

public class PatternPascalTriangle {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter no. of Rows: ");
		int n = scn.nextInt();
		int row = 0;

		while (row < n) {
			int val = 1;
			int col = 0;

			while (col <= row) {
				System.out.print(val + " ");
				col++;
				val = val * (row - col + 1) / col;
			}
			System.out.println();
			row++;
		}
	}

}
