package com.example.hp.crux.basics;

import java.util.Scanner;

public class SumUptoN {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the Number: ");
		int N = scn.nextInt();

		int count = 1;
		int sum = 0;

		while (count <= N) {
			sum += count;
			count++;
		}
		System.out.println("Sum is: " + sum);
	}

}
