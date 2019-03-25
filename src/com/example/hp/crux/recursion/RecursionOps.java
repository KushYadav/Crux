package com.example.hp.crux.recursion;

public class RecursionOps {

	public static void main(String[] args) {
		odd2even(5);
		System.out.println("\n" + factorial(5));
		System.out.println(power(2, 5));
		System.out.println(powerBtr(2, 5));
		int[] arr = { 2, 8, 3, 8, 5, 8, 7 };
		display(arr, 0);
		System.out.println();
		displayRev(arr, 0);
		System.out.println("\n" + find(arr, 0, 7));
		System.out.println(findIndex(arr, 0, 8));
		System.out.println(max(arr, 0));
		System.out.println(firstIndex(arr, 0, 8));
		System.out.println(lastIndex(arr, 0, 8));
		int[] idxArr = allIndex(arr, 0, 8, 0);
		display(idxArr, 0);
	}

	private static void odd2even(int n) {
		if (n == 0) {
			return;
		}
		if (n % 2 == 1) {
			System.out.print(n + " ");
		}
		odd2even(n - 1);
		if (n % 2 == 0) {
			System.out.print(n + " ");
		}
	}

	private static int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	private static int power(int x, int n) {
		if (n == 0) {
			return 1;
		}
		return x * power(x, n - 1);
	}

	private static int powerBtr(int x, int n) {
		if (n == 0) {
			return 1;
		}
		int get = power(x, n / 2);
		if (n % 2 == 0) {
			return get * get;
		} else {
			return get * get * x;
		}
	}

	public static void display(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return;
		}
		System.out.print(arr[vidx] + " ");
		display(arr, vidx + 1);
	}

	public static void displayRev(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return;
		}
		displayRev(arr, vidx + 1);
		System.out.print(arr[vidx] + " ");
	}

	private static int max(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return Integer.MIN_VALUE;
		}
		return Math.max(arr[vidx], max(arr, vidx + 1));
	}

	public static boolean find(int[] arr, int vidx, int val) {
		if (vidx == arr.length) {
			return false;
		}
		if (arr[vidx] == val || find(arr, vidx + 1, val)) {
			return true;
		}
		return false;
	}

	public static int findIndex(int[] arr, int vidx, int val) {
		if (vidx == arr.length) {
			return -1;
		}
		if (arr[vidx] == val) {
			return vidx;
		} else {
			return findIndex(arr, vidx + 1, val);
		}
	}

	public static int firstIndex(int[] arr, int vidx, int val) {
		if (vidx == arr.length) {
			return -1;
		}
		if (arr[vidx] == val) {
			return vidx;
		} else {
			return firstIndex(arr, vidx + 1, val);
		}
	}

	public static int lastIndex(int[] arr, int vidx, int val) {
		if (vidx == arr.length) {
			return -1;
		}
		int get = lastIndex(arr, vidx + 1, val);
		if (arr[vidx] == val) {
			return Math.max(get, vidx);
		}
		return get;
	}

	public static int[] allIndex(int[] arr, int vidx, int val, int size) {
		if (vidx == arr.length) {
			return new int[size];
		}
		if (arr[vidx] == val) {
			size++;
		}
		int[] get = allIndex(arr, vidx + 1, val, size);
		if (arr[vidx] == val) {
			get[size - 1] = vidx;
			size--;
		}
		return get;
	}
}
