package com.example.hp.crux.arrays;

public class Rotate {

	public static void main(String[] args) {
		int[] arr = { 4, 2, 6, 1, 5 };
		int r = -338;
		display(arr);
		display(rotate(arr, r));
	}

	private static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n================");
	}

	private static int[] rotate(int[] arr, int r) {
		int[] arr1 = new int[arr.length];
		r = r % arr.length;
		if (r < 0) {
			r += arr.length;
		}
		for (int i = 0; i < arr.length; i++) {
			arr1[(i + r) % arr.length] = arr[i];
		}
		return arr1;
	}
}
