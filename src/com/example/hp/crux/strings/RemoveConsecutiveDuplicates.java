package com.example.hp.crux.strings;

public class RemoveConsecutiveDuplicates {

	public static void main(String[] args) {
		String str = "aaqbbccds";
		System.out.println(removeDuplicates(str));
	}

	private static String removeDuplicates(String str) {
		StringBuilder sb = new StringBuilder();
		sb.append(str.charAt(0));
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) != sb.charAt(sb.length() - 1)) {
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}
}
