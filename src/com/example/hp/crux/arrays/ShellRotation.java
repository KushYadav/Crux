package com.example.hp.crux.arrays;

import java.util.Scanner;

public class ShellRotation {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
//		int[][] arr = { { 11, 12, 13, 14, 15, 16 }, { 21, 22, 23, 24, 25, 26 }, { 31, 32, 33, 34, 35, 36 } };
		int[][] arr = { { 11, 12, 13, 14, 15, 16 }, { 21, 22, 23, 24, 25, 26 }, { 31, 32, 33, 34, 35, 36 },
				{ 41, 42, 43, 44, 45, 46 }, { 51, 52, 53, 54, 55, 56 } };
		System.out.print("Enter Shell No.: ");
		int sn = scn.nextInt();
		System.out.print("Enter Rotations: ");
		int r = scn.nextInt();
		display(arr);
		shellRotation(arr, sn, r);
		display(arr);
	}

	private static void shellRotation(int[][] arr, int sn, int r) {
		int ss = arr.length < arr[0].length ? arr.length : arr[0].length; // shorter side of array
		if (sn > (ss + 1) / 2) {
			System.out.println("Shell Doesn't Exist");
		} else {
			int[] arr1D = rotate1D(arr, sn, r);
			putBack(arr, arr1D, sn);
		}
	}

	private static int[] rotate1D(int[][] arr, int sn, int r) {
		int arrSize;
		if (sn > arr.length / 2) {
			arrSize = (arr[0].length - 2 * (sn - 1) - 2) + 2 * (arr.length - 2 * (sn - 1));
		} else if (sn > arr[0].length / 2) {
			arrSize = 2 * (arr[0].length - 2 * (sn - 1)) + (arr.length - 2 * (sn - 1) - 2);
		} else {
			arrSize = 2 * (arr[0].length - 2 * (sn - 1)) + 2 * (arr.length - 2 * (sn - 1) - 2);
		}
		int[] arr1D = new int[arrSize];
		int row = sn - 1;
		int col = sn - 1;
		int x = 1, y = 0;
		for (int i = 0; i < arrSize; i++) {
			arr1D[i] = arr[row][col];
			row += y;
			col += x;
			if (row == sn - 1 && col == arr[0].length - sn) {
				x = 0;
				y = 1;
			} else if (row == arr.length - sn && col == arr[0].length - sn) {
				x = -1;
				y = 0;
			} else if (row == arr.length - sn && col == sn - 1) {
				x = 0;
				y = -1;
			}
		}
		r = r % arr1D.length;
		if (r < 0) {
			r += arr1D.length;
		}
		int[] new1D = new int[arr1D.length];
		for (int i = 0; i < arr1D.length; i++) {
			new1D[(i + r) % arr1D.length] = arr1D[i];
		}
		System.out.println();
		return new1D;
	}

	private static void putBack(int[][] arr, int[] arr1D, int sn) {
		int row = sn - 1;
		int col = sn - 1;
		int x = 1, y = 0;
		for (int i = 0; i < arr1D.length; i++) {
			arr[row][col] = arr1D[i];
			row += y;
			col += x;
			if (row == sn - 1 && col == arr[0].length - sn) {
				x = 0;
				y = 1;
			} else if (row == arr.length - sn && col == arr[0].length - sn) {
				x = -1;
				y = 0;
			} else if (row == arr.length - sn && col == sn - 1) {
				x = 0;
				y = -1;
			}
		}
	}

	private static void display(int[][] arr) {
		System.out.println("-----------------");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.print("-----------------");
	}
}
