package com.example.hp.crux.arrays;

public class SumOfTwoNos {

	public static void main(String[] args) {
		int[] arr1 = { 1, 1, 1 };
		int[] arr2 = { 1, 1, 1, 1, 1, 1, 1 };

		int carry = 0;
		int[] sum = new int[arr1.length > arr2.length ? arr1.length + 1 : arr2.length + 1];
		int i = arr1.length - 1;
		int j = arr2.length - 1;
		int k = sum.length - 1;
		while (i >= 0 || j >= 0) {
			if (i >= 0 && j >= 0) {
				sum[k] = (arr1[i] + arr2[j] + carry) % 10;
				carry = (arr1[i] + arr2[j] + carry) / 10;
			} else if (i >= 0) {
				sum[k] = (arr1[i] + carry) % 10;
				carry = (arr1[i] + carry) / 10;
			} else {
				sum[k] = (arr2[j] + carry) % 10;
				carry = (arr2[j] + carry) / 10;
			}
			i--;
			j--;
			k--;
		}
		sum[0] = carry;
		for (int val : sum) {
			System.out.print(val + " ");
		}
	}
}
