package com.example.hp.crux.datastructures.linkedlist;

public class LinkedList {
	private class Node {
		private int data;
		private Node next;
	}

	private int size;
	private Node head;
	private Node tail;

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0) ? true : false;
	}

	private Node getNode(int idx) {
		Node nodeAtIdx = head;
		for (int i = 0; i < idx; i++) {
			nodeAtIdx = nodeAtIdx.next;
		}
		return nodeAtIdx;
	}

	public void addLast(int value) {
		Node node = new Node();
		node.data = value;
		if (size == 0) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
		size++;
	}

	public void addAtIndex(int value, int idx) {
		if (idx == 0) {
			addFirst(value);
			return;
		}
		if (idx == size - 1) {
			addLast(value);
			return;
		}
		Node node = new Node();
		node.data = value;
		Node pred = getNode(idx - 1);
		node.next = pred.next;
		pred.next = node;
		size++;
	}

	public void addFirst(int value) {
		Node node = new Node();
		node.data = value;
		if (size == 0) {
			head = node;
			tail = node;
		} else {
			node.next = head;
			head = node;
		}
		size++;
	}

	public int removeFirst() throws Exception {
		if (size == 0) {
			throw new Exception("The list is Empty");
		} else {
			int removed = head.data;
			if (size == 1) {
				head = null;
				tail = null;
			} else {
				head = head.next;
			}
			size--;
			return removed;
		}
	}

	public int removeLast() throws Exception {
		if (size == 0) {
			throw new Exception("The list is Empty");
		} else {
			int removed = tail.data;
			if (size == 1) {
				head = null;
				tail = null;
			} else {
				Node pred = getNode(size - 1);
				tail = pred;
				tail.next = null;
			}
			size--;
			return removed;
		}
	}

	public int removeAtIndex(int idx) throws Exception {
		if (size == 0) {
			throw new Exception("The list is Empty");
		} else if (idx >= size) {
			throw new Exception("Index is out of bound");
		} else if (idx == 0) {
			return removeFirst();
		} else if (idx == size - 1) {
			return removeLast();

		} else {
			Node pred = getNode(idx - 1);
			int removed = pred.next.data;
			pred.next = pred.next.next;
			size--;
			return removed;
		}
	}

	public void display() {
		Node tempNode = head;
		while (tempNode != null) {
			System.out.print(tempNode.data + " ");
			tempNode = tempNode.next;
		}
		System.out.println("\n=============================");
	}

	public int getFirst() throws Exception {
		if (size == 0) {
			throw new Exception("List is Empty");
		} else {
			return head.data;
		}
	}

	public int getLast() throws Exception {
		if (size == 0) {
			throw new Exception("List is Empty");
		} else {
			return tail.data;
		}
	}

	public int getAtIndex(int idx) throws Exception {
		if (size == 0) {
			throw new Exception("List is Empty");
		} else {
			return getNode(idx).data;
		}
	}

	public void displayRecursive() {
		displayRecursive(head);
	}

	private void displayRecursive(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		displayRecursive(node.next);
	}

	public void reverseDataIterative() {
		Node start = head;
		for (int i = 0; i < size / 2; i++) {
			Node end = getNode(size - 1 - i);
			start.data = start.data + end.data - (end.data = start.data);
			start = start.next;
		}
	}

	public void reversePointerRecursive() {
		reversePointerRecursive(head);
		Node tempNode = head;
		head = tail;
		tail = tempNode;
		tail.next = null;
	}

	private void reversePointerRecursive(Node node) {
		if (node.next == null) {
			return;
		}
		reversePointerRecursive(node.next);
		node.next.next = node;
	}

	public void reversePointerIterative() {
		Node curr = head;
		Node next = head.next;
		while (next != null) {
			Node tempNode = next.next;
			next.next = curr;
			curr = next;
			next = tempNode;
		}
		Node tempNode = head;
		head = tail;
		tail = tempNode;
		tail.next = null;
	}

	private class HeapMover {
		private Node node;
	}

	public void reverseDataRecursive() {
		HeapMover hm = new HeapMover();
		hm.node = head;
		reverseDataRecursive(head, hm, 0);
	}

	private void reverseDataRecursive(Node node, HeapMover hm, int count) {
		if (node == null) {
			return;
		}
		reverseDataRecursive(node.next, hm, count + 1);
		if (count > size / 2) {
			node.data = hm.node.data + node.data - (hm.node.data = node.data);
		}
		hm.node = hm.node.next;
	}

	private class FoldMover {
		private Node node;
	}

	public void fold() {
		FoldMover fm = new FoldMover();
		fm.node = head;
		fold(head, fm, 0);
	}

	private void fold(Node node, FoldMover fm, int count) {
		if (node == null) {
			return;
		}
		fold(node.next, fm, count + 1);
		if (count > size / 2) {
			node.next = fm.node.next;
			fm.node.next = node;
			fm.node = node.next;

//			Node tempNode = fm.node.next;
//			fm.node.next = node;
//			node.next = tempNode;
//			fm.node = tempNode;
		} else if (count == size / 2) {
			tail = node;
			tail.next = null;
		}
	}

	private class KthMover {
		private int value;
	}

	public int kThFromLast(int kTh) {
		KthMover km = new KthMover();
		kThFromLast(head, km, 0, kTh);
		return km.value;
	}

	private void kThFromLast(Node node, KthMover km, int counter, int kTh) {
		if (node == null) {
			return;
		}
		kThFromLast(node.next, km, counter + 1, kTh);
		if (size - counter == kTh) {
			km.value = node.data;
		}
	}

	private class PallinMover {
		private Node node;
	}

	public boolean isPallindrome() {
		PallinMover pm = new PallinMover();
		pm.node = head;
		return isPallindrome(head, pm);
	}

	private boolean isPallindrome(Node node, PallinMover pm) {
		if (node == null) {
			return true;
		}
		if (isPallindrome(node.next, pm) == false || node.data != pm.node.data) {
			pm.node = pm.node.next;
			return false;
		}
		pm.node = pm.node.next;
		return true;
	}

	private Node getMidNode() {
		Node slow = head;
		Node fast = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	private LinkedList mergerhSortedLists(LinkedList ll) {
		Node head1 = this.head;
		Node head2 = ll.head;
		LinkedList toSend = new LinkedList();

		while (head1 != null && head2 != null) {
			if (head1.data < head2.data) {
				toSend.addLast(head1.data);
				head1 = head1.next;
			} else {
				toSend.addLast(head2.data);
				head2 = head2.next;
			}
		}
		while (head1 != null) {
			toSend.addLast(head1.data);
			head1 = head1.next;
		}
		while (head2 != null) {
			toSend.addLast(head2.data);
			head2 = head2.next;
		}
		return toSend;
	}

	public LinkedList mergeSort() {
		if (head == tail) {
			return this;
		}
		LinkedList sendBack = new LinkedList();
		LinkedList fh = new LinkedList();
		LinkedList sh = new LinkedList();

		Node midNode = getMidNode();
		fh.head = this.head;
		fh.tail = midNode;
		sh.head = midNode.next;
		sh.tail = this.tail;
		fh.tail.next = null;
		fh = fh.mergeSort();
		sh = sh.mergeSort();

		sendBack = fh.mergerhSortedLists(sh);
		return sendBack;

	}

}
