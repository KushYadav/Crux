package com.example.hp.crux.basics;

public class D2B {

	public static void main(String[] args) {
		int dec = 10;
		int bin = 0;
		int pow = 1;

		while (dec != 0) {
			bin += dec % 2 * pow;
			dec /= 2;
			pow *= 10;
		}
		System.out.println(bin);
	}
}
