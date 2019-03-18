package com.example.hp.crux.basics;

public class RotateNumber {

	public static void main(String[] args) {
		int n = 42615;
		int r = -338;
		int nod = 0;
		int temp = n;
		while (temp != 0) {
			nod++;
			temp /= 10;
		}
		r = r % nod;
		if (r < 0) {
			r += nod;
		}
		int pow=(int)Math.pow(10, r);
		int rem=n%(pow);
		n=rem*((int)Math.pow(10,(nod-r)))+n/pow;
		System.out.println(n);
	}

}
