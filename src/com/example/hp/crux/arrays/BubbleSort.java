package com.example.hp.crux.arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = { 55, 11, 44, 33, 22, 0 };
		display(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					arr[j] = arr[j] + arr[j + 1] - (arr[j + 1] = arr[j]);
				}
			}
			display(arr);
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
