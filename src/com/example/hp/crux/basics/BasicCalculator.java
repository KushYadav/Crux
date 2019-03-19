package com.example.hp.crux.basics;

import java.util.Scanner;

public class BasicCalculator {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		while (true) {
			System.out.print("Enter Operation: ");
			char ch = scn.next().charAt(0);
			if (ch == 'x' || ch == 'X') {
				break;
			} else {
				System.out.print("Operand_1 : ");
				int n1 = scn.nextInt();
				System.out.print("Operand_2 : ");
				int n2 = scn.nextInt();
				switch (ch) {
				case '+': {
					System.out.println("Addition : " + (n1 + n2));
					break;
				}
				case '-': {
					System.out.println("Subtraction : " + (n1 - n2));
					break;
				}
				case '*': {
					System.out.println("Multiplication : " + (n1 * n2));
					break;
				}
				case '/': {
					System.out.println("Division : " + (n1 / n2));
					break;
				}
				default:
					System.out.println("Error! Try Again");
				}
			}
		}
	}
}
