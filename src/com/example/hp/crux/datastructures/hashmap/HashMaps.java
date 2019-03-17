package com.example.hp.crux.datastructures.hashmap;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMaps {

	public static void main(String[] args) {
		System.out.println(getMaxFreq("gwerfefweewvbre"));
		Integer[] one = { 3, 1, 2, 2, 1, 5, 1 };
		Integer[] two = { 5, 4, 2, 1, 2, 2, 1 };
		System.out.println(commonFreq1(one, two));
		System.out.println(common(one, two));
		Integer arr[] = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
		System.out.println(getLongestSeq(arr));
	}

	public static char getMaxFreq(String str) {
		HashMap<Character, Integer> freqMap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (freqMap.containsKey(str.charAt(i))) {
				freqMap.put(str.charAt(i), freqMap.get(str.charAt(i)) + 1);
			} else {
				freqMap.put(str.charAt(i), 1);
			}
		}
		ArrayList<Character> freqKeyset = new ArrayList<>(freqMap.keySet());
		int maxFreq = 0;
		char maxFreqChar = ' ';
		for (int i = 0; i < freqKeyset.size(); i++) {
			if (freqMap.get(freqKeyset.get(i)) > maxFreq) {
				maxFreq = freqMap.get(freqKeyset.get(i));
				maxFreqChar = freqKeyset.get(i);
			}
		}
		return maxFreqChar;
	}

	public static ArrayList<Integer> commonFreq1(Integer[] one, Integer[] two) {
		HashMap<Integer, Integer> commonMap = new HashMap<>();
		for (int i = 0; i < one.length; i++) {
			if (!commonMap.containsKey(one[i])) {
				commonMap.put(one[i], 1);
			}
		}
		ArrayList<Integer> common = new ArrayList<>();
		for (int i = 0; i < two.length; i++) {
			if (commonMap.containsKey(two[i])) {
				common.add(two[i]);
				commonMap.remove(two[i]);
			}
		}
		return common;
	}

	public static ArrayList<Integer> common(Integer[] one, Integer[] two) {
		HashMap<Integer, Integer> commonMap = new HashMap<>();
		for (int i = 0; i < one.length; i++) {
			if (!commonMap.containsKey(one[i])) {
				commonMap.put(one[i], 1);
			} else {
				commonMap.put(one[i], commonMap.get(one[i]) + 1);
			}
		}
		ArrayList<Integer> common = new ArrayList<>();
		for (int i = 0; i < two.length; i++) {
			if (commonMap.containsKey(two[i])) {
				common.add(two[i]);
				if (commonMap.get(two[i]) == 1) {
					commonMap.remove(two[i]);
				} else {
					commonMap.put(two[i], commonMap.get(two[i]) - 1);
				}
			}
		}
		return common;
	}

	public static ArrayList<Integer> getLongestSeq(Integer[] arr) {
		HashMap<Integer, Boolean> hm = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			hm.put(arr[i], true);
		}
		for (int i = 0; i < arr.length; i++) {
			if (hm.containsKey(arr[i] - 1)) {
				hm.put(arr[i], false);
			}
		}
		int maxseqLength = 0;
		int maxsp = -1;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (hm.get(arr[i]) == true) {
				int tempseqLength = 1;
				int tempsp = arr[i];
				while (hm.containsKey(tempseqLength + tempsp) == true) {
					tempseqLength++;
				}
				if (tempseqLength > maxseqLength) {
					maxseqLength = tempseqLength;
					maxsp = arr[i];
				}
			}
		}
		for (int i = 0; i < maxseqLength; i++) {
			list.add(i + maxsp);
		}
		return list;
	}
}
