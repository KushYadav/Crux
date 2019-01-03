package com.example.hp.crux.datastructures.queue;

public class ClientQueue {

	public static void main(String[] args) throws Exception {
//		Queue queue = new Queue(5);
//		queue.enqueue(10);
//		queue.enqueue(20);
//		queue.enqueue(30);
//		queue.enqueue(40);
//		queue.enqueue(50);
//		queue.display();
//		System.out.println(queue.dequeue());
//		System.out.println(queue.dequeue());
//		System.out.println(queue.dequeue());
//		queue.display();
//		System.out.println(queue.front());
		
		DynamicQueue dq=new DynamicQueue(5);
		dq.enqueue(10);
		dq.enqueue(20);
		dq.enqueue(30);
		dq.enqueue(40);
		dq.enqueue(50);
		dq.enqueue(60);
		dq.enqueue(70);
		dq.display();
	}

}
