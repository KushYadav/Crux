package com.example.hp.crux.basics;

import java.util.Scanner;

public class Pattern12321 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter no. of Rows: ");
		int n = scn.nextInt();

		int sppr = n / 2, csp = 1;
		int stpr = 1, cst = 1;
		int row = 1;
		int val = 0;

		while (row <= n) {
			
			// Space
			while (csp <= sppr) {
				System.out.print(" ");
				csp++;
			}
			csp = 1;
			
			// Star
			while (cst <= stpr) {
				if (cst > stpr / 2) {
					System.out.print(val + stpr - cst + 1);
				} else {
					System.out.print(cst + val);
				}
				cst++;
			}
			cst = 1;
			
			// Space
			while (csp <= sppr) {
				System.out.print(" ");
				csp++;
			}
			csp = 1;
			
			//Changes for next row
			if (row <= n / 2) {
				sppr -= 1;
				stpr += 2;
				val++;
			} else {
				sppr += 1;
				stpr -= 2;
				val--;
			}
			row++;
			System.out.println();
		}
	}

}
