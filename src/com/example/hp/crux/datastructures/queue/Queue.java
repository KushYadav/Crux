package com.example.hp.crux.datastructures.queue;

public class Queue {
	protected int[] data;
	protected int front;
	protected int size;

	public Queue(int cap) {
		data = new int[cap];
	}

	public void enqueue(int value) throws Exception {
		if (size >= data.length) {
			throw new Exception("Queue is Full");
		}
		int tail = (front + size) % data.length;
		data[tail] = value;
		size++;
	}

	public int dequeue() throws Exception {
		if (size <= 0) {
			throw new Exception("Queue is Empty");
		}
		int send = data[front];
		front = (front + 1) % data.length;
		size--;
		return send;
	}

	public int front() throws Exception {
		if (size <= 0) {
			throw new Exception("Queue is Empty");
		}
		return data[front];
	}

	public void display() {
		System.out.print("Front : ");
		for (int i = 0; i < size; i++) {
			System.out.print(data[(i + front) % data.length] + " ");
		}
		System.out.println(": End");
	}
}
