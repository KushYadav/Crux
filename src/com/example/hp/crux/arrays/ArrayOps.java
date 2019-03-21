package com.example.hp.crux.arrays;

public class ArrayOps {

	public static void main(String[] args) {
		int[] arr = { 55, 11, 44, 77, 22, 88, 33 };
		System.out.println(getMax(arr));
		System.out.println(find(arr, 22));
		display(arr);
		reverse(arr);
		display(arr);
	}

	private static int getMax(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] >= max) {
				max = arr[i];
			}
		}
		return max;
	}

	private static boolean find(int[] arr, int val) {
		boolean found = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == val) {
				found = true;
				break;
			}
		}
		return found;
	}

	private static void reverse(int[] arr) {
		for (int i = 0; i < arr.length / 2; i++) {
			arr[i] = arr[arr.length - 1 - i] + arr[i] - (arr[arr.length - 1 - i] = arr[i]);
		}
	}

	private static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println("\n========================");
	}

}
