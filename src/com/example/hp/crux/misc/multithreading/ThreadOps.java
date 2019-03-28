package com.example.hp.crux.misc.multithreading;

public class ThreadOps {

	public static void main(String[] args) {
		CreateThread3 ct3 = new CreateThread3();
		CreateThread4 ct4 = new CreateThread4();
//		ct3.start();
//		ct4.start();
//		ct3.run();
//		ct3.run();
//		They will behave as normal object on calling run function not as thread object.

		JoinThread jt1 = new JoinThread();
		JoinThread jt2 = new JoinThread();
		JoinThread jt3 = new JoinThread();
//		jt1.start();
		try {
			jt1.join(); // Wait until jt1 dies
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		jt2.start();
//		jt3.start();

		NameThread nt1 = new NameThread();
		System.out.println("Name: " + nt1.getName());
		nt1.setName("Name Thread");
		System.out.println("Name: " + nt1.getName());

//		NORM_PRIORITY=5 //Default
//		MAX_PRIORITY=10
//		MIN PRIORITY=1

		PriorityThread pt1 = new PriorityThread();
		PriorityThread pt2 = new PriorityThread();
		pt1.setPriority(10);
		pt2.setPriority(2);
		pt1.start();
		pt2.start();

	}
}

class CreateThread3 extends Thread {
	@Override
	public void run() {
		for (int i = 1; i < 5; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			System.out.println(i);
		}
	}
}

class CreateThread4 extends Thread {
	@Override
	public void run() {
		for (int i = 1; i < 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			System.out.println(i);
		}
	}
}

class JoinThread extends Thread {
	public void run() {
		for (int i = 1; i <= 5; i++) {
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println(i);
		}
	}
}

class NameThread extends Thread {
	public void run() {
		System.out.println("Name thread is Running");
	}
}

class PriorityThread extends Thread {
	public void run() {
		System.out.println("Priority: " + Thread.currentThread().getPriority());
	}
}
