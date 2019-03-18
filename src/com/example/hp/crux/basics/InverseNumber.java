package com.example.hp.crux.basics;

public class InverseNumber {

	public static void main(String[] args) {
		int n = 463215;
		int inverted = 0;
		
		while(n!=0) {
			int rem=n%10;
			n=n/10;
			inverted=inverted*10+rem;
		}
		System.out.println(inverted);
	}
}
