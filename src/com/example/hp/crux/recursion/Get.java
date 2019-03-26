package com.example.hp.crux.recursion;

import java.util.ArrayList;

public class Get {

	public static void main(String[] args) {
		System.out.println(getBoardPaths(0, 10));
		System.out.println(getMazePath(0, 0, 2, 2));
		System.out.println(getMazePathWD(0, 0, 2, 2));
		System.out.println(getMultiStepMazePathWD(0, 0, 2, 2));
		int[] arr = { 0, 0, 0, 0, 7, 0, 9, 0, 0, 0 };
		System.out.println(getBoardPathsWL(0, 10, arr));
		int[] snl = { 0, 0, 0, 0, 7, 0, 9, 0, 4, 3, 0 };
		int[] dices = { 2, 6, 3, 2, 4, 1, 1, 1, 2, 5, 4 };
//		int[] dices = { 4, 2, 3, 1 };
//		int[] dices = { 4, 3};
		System.out.println(isValidPath(0, 10, snl, dices, 0));
	}

	private static ArrayList<String> getBoardPaths(int curr, int end) {
		if (curr == end) {
			ArrayList<String> fl = new ArrayList<>();
			fl.add("");
			return fl;
		}
		ArrayList<String> nl = new ArrayList<>();

		for (int dice = 1; dice <= 6; dice++) {
			if (curr + dice <= end) {
				ArrayList<String> get = getBoardPaths(curr + dice, end);
				for (String sb : get) {
					nl.add(dice + sb);
				}
			}
		}
		return nl;
	}

	private static ArrayList<String> getMazePath(int cr, int cc, int er, int ec) {
		if (cc == ec && cr == er) {
			ArrayList<String> fl = new ArrayList<>();
			fl.add("");
			return fl;
		}
		ArrayList<String> nl = new ArrayList<>();
		if (cr < er) {
			ArrayList<String> get = getMazePath(cr + 1, cc, er, ec);
			for (String sb : get) {
				nl.add("V" + sb);
			}
		}
		if (cc < ec) {
			ArrayList<String> get = getMazePath(cr, cc + 1, er, ec);
			for (String sb : get) {
				nl.add("H" + sb);
			}
		}
		return nl;
	}

	private static ArrayList<String> getMazePathWD(int cr, int cc, int er, int ec) {
		if (cc == ec && cr == er) {
			ArrayList<String> fl = new ArrayList<>();
			fl.add("");
			return fl;
		}
		ArrayList<String> nl = new ArrayList<>();
		if (cr < er) {
			ArrayList<String> get = getMazePathWD(cr + 1, cc, er, ec);
			for (String sb : get) {
				nl.add("V" + sb);
			}
		}
		if (cc < ec) {
			ArrayList<String> get = getMazePathWD(cr, cc + 1, er, ec);
			for (String sb : get) {
				nl.add("H" + sb);
			}
		}
		if (cc < ec && cr < er) {
			ArrayList<String> get = getMazePathWD(cr + 1, cc + 1, er, ec);
			for (String sb : get) {
				nl.add("D" + sb);
			}
		}
		return nl;
	}

	private static ArrayList<String> getMultiStepMazePathWD(int cr, int cc, int er, int ec) {
		if (cc == ec && cr == er) {
			ArrayList<String> fl = new ArrayList<>();
			fl.add("");
			return fl;
		}
		ArrayList<String> nl = new ArrayList<>();
		for (int i = 1; i <= er - cr; i++) {
			ArrayList<String> get = getMultiStepMazePathWD(cr + i, cc, er, ec);
			for (String sb : get) {
				nl.add("V" + i + sb);
			}
		}
		for (int i = 1; i <= ec - cc; i++) {
			ArrayList<String> get = getMultiStepMazePathWD(cr, cc + i, er, ec);
			for (String sb : get) {
				nl.add("H" + i + sb);
			}
		}
		for (int i = 1; i <= ec - cc && i <= er - cr; i++) {
			ArrayList<String> get = getMultiStepMazePathWD(cr + i, cc + i, er, ec);
			for (String sb : get) {
				nl.add("D" + i + sb);
			}
		}
		return nl;
	}

	private static ArrayList<String> getBoardPathsWL(int curr, int end, int[] arr) {
		if (curr == end) {
			ArrayList<String> list = new ArrayList<>();
			list.add("");
			return list;
		}
		ArrayList<String> nl = new ArrayList<>();
		if (arr[curr] == 0) {
			for (int dice = 1; dice <= 6; dice++) {
				if (curr + dice <= end) {
					ArrayList<String> get = getBoardPathsWL(curr + dice, end, arr);
					for (String sb : get) {
						nl.add(dice + sb);
					}
				}
			}
		} else {
			ArrayList<String> get = getBoardPathsWL(arr[curr], end, arr);
			for (String sb : get) {
				nl.add("[" + curr + "-" + arr[curr] + "]" + sb);
			}
		}
		return nl;
	}

	private static boolean isValidPath(int curr, int end, int[] snl, int[] dices, int vidx) {
		if (curr == end) {
			return true;
		}
		if (curr > end) {
			return false;
		}
		if (vidx == dices.length) {
			return false;
		}
		if (snl[curr] != 0) {
			return isValidPath(snl[curr], end, snl, dices, vidx);
		} else {
			if (curr + dices[vidx] <= end) {
				return isValidPath(curr + dices[vidx], end, snl, dices, vidx + 1);
			} else {
				return isValidPath(curr, end, snl, dices, vidx + 1);
			}
		}
	}
}
