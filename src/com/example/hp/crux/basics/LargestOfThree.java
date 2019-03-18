package com.example.hp.crux.basics;

public class LargestOfThree {

	public static void main(String[] args) {
		int a = 100;
		int b = 150;
		int c = 50;

//		if(a>=b&&a>=c) {
//			System.out.println("a is largest");
//			return;
//		}
//		if(b>=a&&b>=c) {
//			System.out.println("b is largest");
//			return;
//		}
//		System.out.println("c is largest");

		if (a >= b && a >= c) {
			System.out.println("a is largest");
		} else {
			if (b >= c) {
				System.out.println("b is largest");
			} else {
				System.out.println("c is largest");
			}
		}
	}
}
