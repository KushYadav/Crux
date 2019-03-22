package com.example.hp.crux.strings;

public class MaxFrequency {

	public static void main(String[] args) {
		String str = "rsgiw9993rg2wvsdfweow";
		System.out.println(getMaxFreq(str));
	}

	public static char getMaxFreq(String str) {
		int[] charArr = new int[256];
		for (int i = 0; i < str.length(); i++) {
			charArr[str.charAt(i)] += 1;
		}
		int maxFreq = 0;
		char ch = '5';
		for (int i = 0; i < charArr.length; i++) {
			if (charArr[i] > maxFreq) {
				maxFreq = charArr[i];
				ch = (char) i;
			}
		}
		return ch;
	}
}
