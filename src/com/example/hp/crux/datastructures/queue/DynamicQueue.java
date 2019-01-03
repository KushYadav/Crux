package com.example.hp.crux.datastructures.queue;

public class DynamicQueue extends Queue {

	public DynamicQueue(int cap) {
		super(cap);
	}

	@Override
	public void enqueue(int value) throws Exception {
		if (size == data.length) {
			int[] newArray = new int[2 * data.length];
			for (int i = 0; i < size; i++) {
				newArray[i] = data[(i + front) % data.length];
			}
			data = newArray;
			front = 0;
		}
		int tail = (front + size) % data.length;
		data[tail] = value;
		size++;
	}

}
