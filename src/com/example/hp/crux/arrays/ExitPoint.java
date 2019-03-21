package com.example.hp.crux.arrays;

public class ExitPoint {

	public static void main(String[] args) {
		int[][] arr = { { 0, 0, 1, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 0 }, { 1, 1, 1, 0 } };
		int row = 0, col = 0;
		int x = 1, y = 0;
		display(arr);
		while (row >= 0 && row < arr.length && col >= 0 && col < arr[0].length) {
			if (arr[row][col] == 1) {
				if (x == 1) {
					x = 0;
					y = 1;
				} else if (x == -1) {
					x = 0;
					y = -1;
				} else if (y == 1) {
					y = 0;
					x = -1;
				} else {
					y = 0;
					x = 1;
				}
			}
			row += y;
			col += x;
		}
		row -= y;
		col -= x;
		System.out.println("\nExit Point is [" + row + "," + col + "]");
	}

	public static void display(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				System.out.print(arr[row][col] + "\t");
			}
			System.out.println();
		}
	}
}
