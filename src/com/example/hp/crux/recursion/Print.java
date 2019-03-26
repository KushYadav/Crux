package com.example.hp.crux.recursion;

public class Print {

	public static void main(String[] args) {
		printBoardPaths(0, 10, "");
		System.out.println();
		printMazePaths(0, 0, 2, 2, "");
		System.out.println();
		printMazePathsWD(0, 0, 2, 2, "");
		System.out.println();
		printMultistepMazePathsWD(0, 0, 2, 2, "");
		System.out.println();
		printKPC("689", "");
		System.out.println();
		int[] arr = { 10, 20, 30, 40, 50, 60 };
		printSubsets(arr, 0, "");
		System.out.println();
		printTargetSubsets(arr, 0, 70, "");
		System.out.println();
		printLexicoCounting(1, 1000);
		System.out.println();
		boolean[][] board = new boolean[4][4];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = false;
			}
		}
		nQueens(board, 0, "");
	}

	private static void printBoardPaths(int curr, int end, String path) {
		if (curr == end) {
			System.out.print(path + " ");
		}
		if (curr < end) {
			for (int dice = 1; dice <= 6; dice++) {
				printBoardPaths(curr + dice, end, path + dice);
			}
		}
	}

	private static void printMazePaths(int cr, int cc, int er, int ec, String path) {
		if (cr == er && cc == ec) {
			System.out.print(path + " ");
		}
		if (cr < er) {
			printMazePaths(cr + 1, cc, er, ec, path + "V");
		}
		if (cc < ec) {
			printMazePaths(cr, cc + 1, er, ec, path + "H");
		}
	}

	private static void printMazePathsWD(int cr, int cc, int er, int ec, String path) {
		if (cr == er && cc == ec) {
			System.out.print(path + " ");
		}
		if (cr < er) {
			printMazePathsWD(cr + 1, cc, er, ec, path + "V");
		}
		if (cc < ec) {
			printMazePathsWD(cr, cc + 1, er, ec, path + "H");
		}
		if (cr < er && cc < ec) {
			printMazePathsWD(cr + 1, cc + 1, er, ec, path + "D");
		}
	}

	private static void printMultistepMazePathsWD(int cr, int cc, int er, int ec, String path) {
		if (cr == er && cc == ec) {
			System.out.print(path + " ");
		}
		for (int i = 1; i <= er - cr; i++) {
			printMultistepMazePathsWD(cr + i, cc, er, ec, path + "V" + i);
		}
		for (int i = 1; i <= ec - cc; i++) {
			printMultistepMazePathsWD(cr, cc + i, er, ec, path + "H" + i);
		}
		for (int i = 1; i <= ec - cc && i <= er - cr; i++) {
			printMultistepMazePathsWD(cr + i, cc + i, er, ec, path + "D" + i);
		}
	}

	private static void printKPC(String ques, String ans) {
		if (ques.isEmpty()) {
			System.out.print(ans + " ");
			return;
		}
		char ch = ques.charAt(0);
		String ros = ques.substring(1);
		String str = getkey(ch);
		for (int i = 0; i < str.length(); i++) {
			printKPC(ros, ans + str.charAt(i));
		}
	}

	private static String getkey(char key) {
		if (key == '1') {
			return "abc";
		} else if (key == '2') {
			return "def";
		} else if (key == '3') {
			return "ghi";
		} else if (key == '4') {
			return "jkl";
		} else if (key == '5') {
			return "mno";
		} else if (key == '6') {
			return "pqrs";
		} else if (key == '7') {
			return "tuv";
		} else if (key == '8') {
			return "wx";
		} else if (key == '9') {
			return "yz";
		} else if (key == '0') {
			return ".,";
		} else {
			return "";
		}
	}

	private static void printSubsets(int[] arr, int vidx, String ss) {
		if (vidx == arr.length) {
			System.out.print("[" + ss + "]" + ",");
			return;
		}
		printSubsets(arr, vidx + 1, ss);
		printSubsets(arr, vidx + 1, ss + " " + arr[vidx] + " ");
	}

	private static void printTargetSubsets(int[] arr, int vidx, int target, String ss) {
		if (vidx == arr.length) {
			return;
		}
		if (target < 0) {
			return;
		}
		if (target == 0) {
			System.out.print("[" + ss + "]" + ",");
		}
		printTargetSubsets(arr, vidx + 1, target, ss);
		printTargetSubsets(arr, vidx + 1, target - arr[vidx], ss + " " + arr[vidx] + " ");
	}

	private static void printLexicoCounting(int curr, int end) {
		System.out.print(curr + "->");
		for (int i = 0; i <= 9; i++) {
			if (curr * 10 + i <= end) {
				printLexicoCounting(curr * 10 + i, end);
			}
		}
		if (curr < 9) {
			printLexicoCounting(curr + 1, end);
		}
	}

	private static void nQueens(boolean[][] board, int row, String config) {
		if (row == board.length) {
			System.out.println(config);
			return;
		}
		for (int i = 0; i < board.length; i++) {
			if (isQueenSafe(board, row, i) == true) {
				board[row][i] = true;
				nQueens(board, row + 1, config + "[" + row + "," + i + "]");
				board[row][i] = false;
			}
		}
	}

	private static boolean isQueenSafe(boolean[][] board, int row, int col) {
		int r = row;
		int c = col;
		while (r >= 0) {
			if (board[r][c] == true) {
				return false;
			}
			r--;
		}
		r = row;
		c = col;
		while (r >= 0 && c >= 0) {
			if (board[r][c] == true) {
				return false;
			}
			r--;
			c--;
		}
		r = row;
		c = col;
		while (r >= 0 && c < board.length) {
			if (board[r][c] == true) {
				return false;
			}
			r--;
			c++;
		}
		return true;
	}
}
