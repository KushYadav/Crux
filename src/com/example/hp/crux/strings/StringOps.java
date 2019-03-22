package com.example.hp.crux.strings;

public class StringOps {

	public static void main(String[] args) {
		String str = "malayalam";
		printSubstrings(str);
		System.out.println(isPalindrome(str));
		printPalindromicSubsets(str);
	}

	private static void printSubstrings(String str) {
		for (int i = 1; i <= str.length(); i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(str.substring(j, i) + " ");
			}
		}
		System.out.println();
	}

	private static boolean isPalindrome(String str) {
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	private static void printPalindromicSubsets(String str) {
		for (int i = 1; i <= str.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (isPalindrome(str.substring(j, i))) {
					System.out.print(str.substring(j, i) + " ");
				}
			}
		}
	}
}
