package com.example.hp.crux.arrays;

import java.util.ArrayList;

public class Intersection {

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 2, 2, 3, 4, 5, 6, 7 };
		int[] arr2 = { 1, 2, 2, 3, 4, 5, 5, 5, 6, 6, 7, 7 };
		ArrayList<Integer> list = intersection(arr1, arr2);
		System.out.println(list);
	}

	public static ArrayList<Integer> intersection(int[] arr1, int[] arr2) {
		int i = 0, j = 0;
		ArrayList<Integer> result = new ArrayList<>();
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] == arr2[j]) {
				result.add(arr1[i]);
				i++;
				j++;
			} else if (arr1[i] < arr2[j]) {
				i++;
			} else {
				j++;
			}
		}
		return result;
	}
}
