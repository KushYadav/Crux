package com.example.hp.crux.arrays;

public class MatrixMultiplication {

	public static void main(String[] args) {
		int[][] first = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 }, };
		int[][] second = { { 3, 3, 3 }, { 3, 3, 3 }, { 3, 3, 3 } };
		display(first);
		display(second);
		multiplication(first, second);
	}

	private static void multiplication(int[][] first, int[][] second) {
		if (first[0].length != second.length) {
			System.out.println("Matrix are not Compatible");
		} else {
			int[][] result = new int[first.length][second[0].length];
			for (int i = 0; i < first.length; i++) {
				for (int j = 0; j < second[0].length; j++) {
					for (int k = 0; k < second.length; k++) {
						result[i][j] += first[i][k] * second[k][j];
					}
				}
			}
			display(result);
		}
	}

	public static void display(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				System.out.print(arr[row][col] + "\t");
			}
			System.out.println();
		}
		System.out.println("=================");
	}
}
