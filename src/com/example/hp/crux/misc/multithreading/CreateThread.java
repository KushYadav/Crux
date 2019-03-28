package com.example.hp.crux.misc.multithreading;

public class CreateThread {

//	1. Extending the thread class
//	2. Implimenting the runnable interface
	
//	Thread scheduler in java is the part of the JVM that decides which thread should run.

	public static void main(String[] args) {
		CreateThread1 ct1 = new CreateThread1();
		ct1.start();
		Thread ct2 = new Thread(new CreateThread2());
		ct2.start();

	}
}

class CreateThread1 extends Thread {
	@Override
	public void run() {
		System.out.println("Thread 1 is Running");
	}
}

class CreateThread2 implements Runnable {
	@Override
	public void run() {
		System.out.println("Thread 2 is Running");
	}
}
