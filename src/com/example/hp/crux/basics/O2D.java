package com.example.hp.crux.basics;

import java.util.Scanner;

public class O2D {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int oct = scn.nextInt();
		int pow = 1;
		int dec = 0;

		while (oct != 0) {
			dec += pow * (oct % 10);
			oct /= 10;
			pow *= 8;
		}
		System.out.println(dec);
	}

}
