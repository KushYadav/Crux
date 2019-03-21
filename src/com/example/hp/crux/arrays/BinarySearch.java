package com.example.hp.crux.arrays;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = { 11, 22, 33, 44, 55, 66, 77, 88, 99 };
		int start = 0;
		int end = arr.length - 1;
		boolean found = false;
		int val = 22;

		while (true) {
			int mid = (start + end) / 2;
			if (arr[mid] == val) {
				found = true;
				break;
			}
			if (start == end) {
				break;
			}
			if (arr[mid] < val) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		System.out.println(found);
	}
}
