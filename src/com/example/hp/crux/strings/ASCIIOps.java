package com.example.hp.crux.strings;

public class ASCIIOps {

	public static void main(String[] args) {
		String str = "HelLo";
		System.out.println(toggle(str));
		System.out.println(incDec(str));
		System.out.println(addDiff(str));
	}

	private static String toggle(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch <= 'z' && ch >= 'a') {
				sb.append((char) (ch - 'a' + 'A'));
			} else {
				sb.append((char) (ch + 'a' - 'A'));
			}
		}
		return sb.toString();
	}

	public static String incDec(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (i % 2 == 0) {
				sb.append((char) (ch - 1));
			} else {
				sb.append((char) (ch + 1));
			}
		}
		return sb.toString();
	}

	public static String addDiff(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length() - 1; i++) {
			sb.append(str.charAt(i));
			sb.append(Math.abs(str.charAt(i) - str.charAt(i + 1)));
		}
		sb.append(str.charAt(str.length() - 1));
		return sb.toString();
	}
}
