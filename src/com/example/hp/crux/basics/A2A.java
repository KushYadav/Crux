package com.example.hp.crux.basics;

import java.util.Scanner;

public class A2A {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter Source base: ");
		int sb = scn.nextInt();
		System.out.print("Enter Destination base: ");
		int db = scn.nextInt();
		System.out.print("Enter Source No.: ");
		int sn = scn.nextInt();
		int dn = 0;

		int pow = 1;
		int dec = 0;
		while (sn != 0) {
			dec += pow * (sn % 10);
			sn /= 10;
			pow *= sb;
		}

		pow = 1;
		while (dec != 0) {
			dn += pow * (dec % db);
			dec /= db;
			pow *= 10;
		}
		System.out.print("Destination No.: " + dn);
	}
}
