package com.example.hp.crux.misc.multithreading;

public class LifeCycle {

	public static void main(String[] args) {
		Thread lt1 = new Thread(new LifeThread());
		System.out.println(lt1.getState());
		lt1.start();
		System.out.println(lt1.getState());
		try {
			lt1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(lt1.getState());
	}
}

class LifeThread implements Runnable {

	@Override
	public void run() {
		System.out.println("Thread Running");
	}
}
