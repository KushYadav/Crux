package com.example.hp.crux.datastructures.stack;

public class DynamicStack extends Stack {

	public DynamicStack(int cap) {
		super(cap);
	}

	@Override
	public void push(int value) throws Exception {
		if (tos == data.length - 1) {
			int[] newArray = new int[2 * data.length];
			for (int i = 0; i < data.length; i++) {
				newArray[i] = data[i];
			}
			data = newArray;
		}
		tos++;
		data[tos] = value;
	}

}
