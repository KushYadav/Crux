package com.example.hp.crux.recursion;

public class Sorting {

	public static void main(String[] args) {
		int[] arr = { 81, 55, 22, 44, 33 };
		display(arr);
//		bubbleSort(arr, 0, arr.length - 1);
//		selectionSort(arr, 0, 1);
//		insertionSort(arr, 1, 1);
//		display(mergeSort(arr, 0, arr.length - 1));
		quickSort(arr, 0, arr.length - 1);
		display(arr);
	}

	private static void bubbleSort(int[] arr, int si, int ei) {
		if (ei == 0) {
			return;
		}
		if (si == ei) {
			bubbleSort(arr, 0, ei - 1);
			return;
		}
		if (arr[si] > arr[si + 1]) {
			arr[si] = arr[si + 1] + arr[si] - (arr[si + 1] = arr[si]);
		}
		bubbleSort(arr, si + 1, ei);
	}

	private static void selectionSort(int[] arr, int si, int ei) {
		if (si == arr.length) {
			return;
		}
		if (ei == arr.length) {
			selectionSort(arr, si + 1, si + 2);
			return;
		}
		if (arr[si] > arr[ei]) {
			arr[si] = arr[ei] + arr[si] - (arr[ei] = arr[si]);
		}
		selectionSort(arr, si, ei + 1);
	}

	private static void insertionSort(int[] arr, int si, int ei) {
		if (ei == arr.length) {
			return;
		}
		if (si == 0) {
			insertionSort(arr, ei + 1, ei + 1);
			return;
		}
		if (arr[si] < arr[si - 1]) {
			arr[si] = arr[si - 1] + arr[si] - (arr[si - 1] = arr[si]);
		}
		insertionSort(arr, si - 1, ei);
	}

	private static int[] mergeTwoSortedArray(int[] one, int[] two) {
		int[] arr = new int[one.length + two.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
				arr[k] = one[i];
				i++;
			} else {
				arr[k] = two[j];
				j++;
			}
			k++;
		}
		while (i < one.length) {
			arr[k] = one[i];
			i++;
			k++;
		}
		while (j < two.length) {
			arr[k] = two[j];
			j++;
			k++;
		}
		return arr;
	}

	private static int[] mergeSort(int[] arr, int lo, int hi) {
		if (lo == hi) {
			int[] fa = { arr[lo] };
			return fa;
		}
		int[] l = mergeSort(arr, lo, (lo + hi) / 2);
		int[] r = mergeSort(arr, (lo + hi) / 2 + 1, hi);
		return mergeTwoSortedArray(l, r);
	}

	private static void quickSort(int[] arr, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		int pivot = arr[(lo + hi) / 2];
		int i = lo;
		int j = hi;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
			while (arr[j] > pivot) {
				j--;
			}
			if (i <= j) {
				arr[i] = arr[j] + arr[i] - (arr[j] = arr[i]);
				i++;
				j--;
			}
		}
		quickSort(arr, lo, j);
		quickSort(arr, i, hi);
	}

	private static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println("\n===============");
	}
}
