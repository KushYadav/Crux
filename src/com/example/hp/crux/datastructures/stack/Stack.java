package com.example.hp.crux.datastructures.stack;

public class Stack {
	protected int[] data;
	protected int tos = -1;

	public Stack(int cap) {
		data = new int[cap];
	}

	public void push(int value) throws Exception {
		if (tos >= data.length) {
			throw new Exception("Stack is Full");
		}
		tos++;
		data[tos] = value;
	}

	public int pop() throws Exception {
		if (tos <= -1) {
			throw new Exception("Stack is Empty");
		}
		int temp = data[tos];
		tos--;
		return temp;
	}

	public int top() throws Exception {
		if (tos <= -1) {
			throw new Exception("Stack is Empty");
		}
		return data[tos];
	}

	public int size() {
		return tos + 1;
	}

	public boolean isEmpty() {
		return tos == -1 ? true : false;
	}

	public void display() {
		for (int i = 0; i < tos + 1; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println(" : Start of Index");
	}
}
