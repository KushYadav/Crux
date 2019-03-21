package com.example.hp.crux.arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 55, 11, 44, 33, 22 };
		display(arr);
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = arr.length - 1; j > i; j--) {
//				if (arr[j] < arr[j - 1]) {
//					arr[j] = arr[j - 1] + arr[j] - (arr[j - 1] = arr[j]);
//				}
//			}
//		}
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					arr[i] = arr[j] + arr[i] - (arr[j] = arr[i]);
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
