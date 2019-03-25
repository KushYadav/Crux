package com.example.hp.crux.recursion;

import java.util.ArrayList;

public class RecursionOps2 {

	public static void main(String[] args) {

		System.out.println(fibonacci(4));
		printRows(5);
		System.out.println();
		printCols(5);
		printSquare(5, 0, 0);
		System.out.println();
		printTriangle(5, 0, 0);
		System.out.println(getSS("abc"));
		System.out.println(getPermutations("abc"));
	}

	private static int fibonacci(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	private static void printRows(int n) {
		if (n == 0) {
			return;
		}
		System.out.print("*");
		printRows(n - 1);
	}

	private static void printCols(int n) {
		if (n == 0) {
			return;
		}
		System.out.println("*");
		printCols(n - 1);
	}

	private static void printSquare(int n, int row, int col) {
		if (row >= n) {
			return;
		}
		if (col >= n) {
			System.out.println();
			printSquare(n, row + 1, 0);
			return;
		}
		System.out.print("*");
		printSquare(n, row, col + 1);
	}

	private static void printTriangle(int n, int row, int col) {
		if (row >= n) {
			return;
		}
		if (col > row) {
			System.out.println();
			printTriangle(n, row + 1, 0);
			return;
		}
		System.out.print("*");
		printTriangle(n, row, col + 1);
	}

	public static ArrayList<String> getSS(String str) {
		if (str.isEmpty()) {
			ArrayList<String> fl = new ArrayList<>();
			fl.add("");
			return fl;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> get = getSS(ros);
		ArrayList<String> nl = new ArrayList<>();
		for (String ss : get) {
			nl.add(ss);
			nl.add(ch + ss);
		}
		return nl;
	}

	public static ArrayList<String> getPermutations(String str) {
		if (str.isEmpty()) {
			ArrayList<String> fl = new ArrayList<>();
			fl.add("");
			return fl;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> get = getPermutations(ros);
		ArrayList<String> nl = new ArrayList<>();
		for (String ss : get) {
			for (int i = 0; i <= ss.length(); i++) {
				StringBuilder sb = new StringBuilder(ss);
				nl.add(sb.insert(i, ch).toString());
			}
		}
		return nl;
	}

}
