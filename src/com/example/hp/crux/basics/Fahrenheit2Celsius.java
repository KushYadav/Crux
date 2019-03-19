package com.example.hp.crux.basics;

public class Fahrenheit2Celsius {

	public static void main(String[] args) {
		int f1 = 0;
		int f2 = 300;

		for (int i = f1; i <= f2; i += 20) {
			System.out.println(i + "	" + (i - 32) * 5 / 9);
		}
	}
}
