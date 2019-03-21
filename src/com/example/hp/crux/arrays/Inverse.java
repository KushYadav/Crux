package com.example.hp.crux.arrays;

public class Inverse {

	public static void main(String[] args) {
		int[] arr = { 5, 1, 2, 0, 3, 4 };
		display(arr);
		display(inverse(arr));
	}

	public static void display(int[] arr) {
		int i;
		for (i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n================");
	}

	public static int[] inverse(int[] arr) {
		int[] arr1 = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			arr1[arr[i]] = i;
		}
		return arr1;
	}
}
