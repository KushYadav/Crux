package com.example.hp.crux.arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 55, 11, 44, 33, 22 };
		display(arr);
		for (int i = 1; i < arr.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j + 1] < arr[j]) {
					arr[j] = arr[j + 1] + arr[j] - (arr[j + 1] = arr[j]);
				}
			}
		}
		display(arr);
	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println("\n======================");
	}
}