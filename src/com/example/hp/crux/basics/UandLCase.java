package com.example.hp.crux.basics;

import java.util.Scanner;

public class UandLCase {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		char ch = scn.next().charAt(0);
		if (ch >= 'a' && ch <= 'z') {
			System.out.println("Lower Case");
		} else if (ch >= 'A' && ch <= 'Z') {
			System.out.println("Upper Case");
		} else {
			System.out.println("Invalid Input");
		}
	}
}
