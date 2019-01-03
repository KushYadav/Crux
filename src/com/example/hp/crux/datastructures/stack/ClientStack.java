package com.example.hp.crux.datastructures.stack;

public class ClientStack {

	public static void main(String[] args) throws Exception {
		Stack stack = new Stack(5);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.display();
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.display();
		System.out.println(stack.top());

		DynamicStack ds = new DynamicStack(5);
		ds.push(10);
		ds.push(20);
		ds.push(30);
		ds.push(40);
		ds.push(50);
		ds.push(60);
		ds.push(70);
		ds.display();
		ds.pop();
		ds.display();
	}

}
