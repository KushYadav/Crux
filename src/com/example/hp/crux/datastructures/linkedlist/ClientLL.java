package com.example.hp.crux.datastructures.linkedlist;

public class ClientLL {

	public static void main(String[] args) throws Exception {
		LinkedList ll = new LinkedList();
		ll.addFirst(70);
		ll.addFirst(0);
		ll.addLast(10);
		ll.addLast(40);
		ll.addLast(10);
		ll.addAtIndex(30, 2);
		ll.addAtIndex(70, 5);
		ll.display();
		System.out.println(ll.removeAtIndex(2));
		System.out.println(ll.removeFirst());
		ll.display();
//		ll.displayRecursive();
//		System.out.println();
//		ll.reverseDataIterative();
//		ll.reversePointerRecursive();
//		ll.reversePointerIterative();
//		ll.reverseDataRecursive();
//		ll.fold();
		System.out.println(ll.isPallindrome());
		System.out.println(ll.kThFromLast(3));
//		ll.display();
		System.out.println(ll.getSize());
		System.out.println(ll.isEmpty());
		ll = ll.mergeSort();
		ll.display();
	}
}
