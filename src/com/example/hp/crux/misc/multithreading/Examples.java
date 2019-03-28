package com.example.hp.crux.misc.multithreading;

public class Examples {

	public static void main(String[] args) {
		Thread bt1 = new Thread(new BuildThread(0, 25, ""));
		Thread bt2 = new Thread(new BuildThread(0, 25, ""));
		Thread bt3 = new Thread(new BuildThread(0, 25, ""));
		Thread bt4 = new Thread(new BuildThread(0, 25, ""));
		Long st = System.nanoTime();
		bt1.start();
		try {
			bt1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		bt2.start();
		try {
			bt2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Without Multi-Threading: " + (System.nanoTime() - st) / 1000000 + "ms");

		st = System.nanoTime();
		bt3.start();
		bt4.start();
		try {
			bt3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			bt4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("With Multi-Threading: " + (System.nanoTime() - st) / 1000000 + "ms");

	}

}

class BuildThread implements Runnable {

	int curr;
	int end;
	String path;

	public BuildThread(int curr, int end, String path) {
		this.curr = curr;
		this.end = end;
		this.path = path;
	}

	public void run() {
		Functions f = new Functions();
		f.printBoardPaths(curr, end, path);
	}

}

class Functions {
	public void printBoardPaths(int curr, int end, String path) {
		if (curr == end) {
//			System.out.print(path+"->");
		}
		for (int dice = 1; dice <= 6; dice++) {
			if (curr + dice <= end) {
				printBoardPaths(curr + dice, end, path + dice);
			}
		}
	}
}