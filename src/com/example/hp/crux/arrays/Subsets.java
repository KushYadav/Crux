package com.example.hp.crux.arrays;

public class Subsets {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40 };
		for (int i = 0; i < Math.pow(2, arr.length); i++) {
			String paddedBin = Integer.toBinaryString(0x1000 | i);
			String bin = paddedBin.substring(paddedBin.length() - arr.length, paddedBin.length());
			System.out.print("[ ");
			for (int j = 0; j < bin.length(); j++) {
				if (bin.charAt(j) == '1') {
					System.out.print(arr[j] + " ");
				}
			}
			System.out.println("]");
		}
	}
}
