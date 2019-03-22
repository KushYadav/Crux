package com.example.hp.crux.strings;

public class StringCompression {

	public static void main(String[] args) {
		String str = "aaabbccds";
		System.out.println(compress(str));
	}

	private static String compress(String str) {
		StringBuilder sb = new StringBuilder();
		sb.append(str.charAt(0));
		int counter = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) != sb.charAt(sb.length() - 1)) {
				if (counter > 1) {
					sb.append(counter);
				}
				sb.append(str.charAt(i));
				counter = 0;
			}
			counter++;
		}
		if (counter > 1) {
			sb.append(counter);
		}
		return sb.toString();
	}
}
