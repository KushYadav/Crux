package com.example.hp.crux.datastructures.trees.generictree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class GenericTree {
	private class Node {
		private int data;
		private ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;
	private int size;

	public GenericTree() {
		Scanner scn = new Scanner(System.in);
		root = takeInput(null, 0, scn);
	}

	private Node takeInput(Node parent, int cidx, Scanner scn) {
		if (parent == null) {
			System.out.println("Enter the data for root");
		} else {
			System.out.println("Enter the data for the " + cidx + "th child of" + parent.data);
		}

		Node child = new Node();
		child.data = scn.nextInt();
		size++;

		System.out.println("Enter the number of children for " + child.data);
		int NOC = scn.nextInt();
		for (int i = 0; i < NOC; i++) {
			child.children.add(takeInput(child, i, scn));
		}
		return child;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0) ? true : false;
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		System.out.print(node.data + "	=>	");
		for (Node child : node.children) {
			System.out.print(child.data + " ");
		}
		System.out.println();
		for (Node child : node.children) {
			display(child);
		}
	}

	public int sizeRecursive() {
		return sizeRecursive(root);
	}

	private int sizeRecursive(Node node) {
		int count = 0;
		for (Node child : node.children) {
			count += sizeRecursive(child);
		}
		return count + 1;
	}

	public int getMax() {
		return getMax(root);
	}

	private int getMax(Node node) {
		int max = Integer.MIN_VALUE;
		for (Node child : node.children) {
			max = getMax(child);
		}
		return Math.max(max, node.data);
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		int height = -1;
		for (Node child : node.children) {
			height = height(child);
		}
		return height + 1;
	}

	public boolean find(int value) {
		return find(root, value);
	}

	private boolean find(Node node, int value) {
		boolean b = false;
		for (Node child : node.children) {
			if (find(child, value)) {
				return true;
			}
		}
		if (node.data == value) {
			return true;
		}
		return false;
	}

	public void mirror() {
		mirror(root);
	}

	private void mirror(Node node) {
		for (Node child : node.children) {
			mirror(child);
		}
		for (int i = 0; i < node.children.size() / 2; i++) {
			Node tempNode = node.children.get(i);
			node.children.set(i, node.children.get(node.children.size() - 1));
			node.children.set((node.children.size() - 1), tempNode);
		}
	}

	public void printAtDepth(int desiredDepth) {
		printAtDepth(root, 0, desiredDepth);
	}

	private void printAtDepth(Node node, int currentDepth, int desiredDepth) {
		if (currentDepth == desiredDepth) {
			System.out.print(node.data + " ");
		}
		for (Node child : node.children) {
			printAtDepth(child, currentDepth + 1, desiredDepth);
		}
	}

	public void linearize() {
		linearize(root);
	}

	private void linearize(Node node) {
		for (Node child : node.children) {
			linearize(child);
		}
		if (node.children.size() > 1) {
			while (node.children.size() > 1) {
				Node removed = node.children.remove(1);
				Node tail = node;
				while (tail.children.size() != 0) {
					tail = tail.children.get(0);
				}
				tail.children.add(removed);
			}
		}
	}

	public void flatten() {
		flatten(root);
	}

	public void flatten(Node node) {
		ArrayList<Node> nloc = new ArrayList<>();
		for (Node child : node.children) {
			flatten(child);
		}
		for (Node child : node.children) {
			nloc.add(child);
			nloc.addAll(child.children);
			child.children = new ArrayList<>();
		}
		node.children = nloc;
	}

	private class ListMover {
		ArrayList<Integer> preOrder = new ArrayList<>();
	}

	public ArrayList<Integer> storePreOrder() {
		ListMover lm = new ListMover();
		storePreOrder(root, lm);
		return lm.preOrder;
	}

	private void storePreOrder(Node node, ListMover lm) {
		lm.preOrder.add(node.data);
		for (Node child : node.children) {
			storePreOrder(child, lm);
		}
	}

	public boolean mirrorIso() {
		if (!mirrorIso(root)) {
			System.out.println("Break");
			return false;
		}
		ArrayList<Integer> list1 = this.storePreOrder();
		GenericTree mirrorTree = this;
		mirrorTree.mirror();
		ArrayList<Integer> list2 = mirrorTree.storePreOrder();
		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i) != list2.get(i)) {
				this.mirror();
				return false;
			}
		}
		this.mirror();
		return true;

	}

	private boolean mirrorIso(Node node) {
		for (int i = 0; i < node.children.size() / 2; i++)
			if (node.children.get(i).children.size() != node.children.get(node.children.size() - i - 1).children
					.size()) {
				return false;
			}
		for (Node child : node.children) {
			boolean b = mirrorIso(child);
			if (b == false) {
				return false;
			}
		}
		return true;
	}

	public void removeLeaf() {
		removeLeaf(root);
	}

	private void removeLeaf(Node node) {
		for (int i = 0; i < node.children.size(); i++) {
			if (node.children.get(i).children.size() == 0) {
				node.children.remove(i);
				i--;
			}
		}
		for (Node child : node.children) {
			removeLeaf(child);
		}
	}

	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Node node) {
		System.out.print(node.data + " ");
		for (Node child : node.children) {
			preOrder(child);
		}
	}

	public void postOrder() {
		postOrder(root);
	}

	private void postOrder(Node node) {
		for (Node child : node.children) {
			postOrder(child);
		}
		System.out.print(node.data + " ");
	}

	private class HeapMover {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int size = 0;
		int height = -1;
		boolean find = false;
		Node pred;
		Node succ;
		Node curr;
		Node prev;
		Node justLarger;
	}

	public void multiSolver(int value) {
		HeapMover hm = new HeapMover();
		multiSolver(root, hm, value, -1);
		System.out.println("Max is : " + hm.max);
		System.out.println("Min is : " + hm.min);
		System.out.println("Size is : " + hm.size);
		System.out.println("Height is : " + hm.height);
		System.out.println("found the number : " + hm.find);
		if (hm.justLarger == null) {
			System.out.println("Just Larger not found");
		} else {
			System.out.println("Just larger is : " + hm.justLarger.data);
		}
		if (hm.pred == null) {
			System.out.println("Predecessor not found");
		} else {
			System.out.println("Predecessor is : " + hm.pred.data);
		}
		if (hm.succ == null) {
			System.out.println("Successor not found");
		} else {
			System.out.println("Successor is : " + hm.succ.data);
		}

	}

	private void multiSolver(Node node, HeapMover hm, int value, int height) {
		hm.size++;
		hm.prev = hm.curr;
		hm.curr = node;
		if (node.data > hm.max) {
			hm.max = node.data;
		}
		if (node.data < hm.min) {
			hm.min = node.data;
		}
		if (hm.find == true && hm.succ == null) {
			hm.succ = hm.curr;
		}
		if (node.data == value) {
			hm.find = true;
		}
		if (node.data == value) {
			hm.pred = hm.prev;
		}
		if (hm.height > height) {
			hm.height = height;
		}
		if (hm.justLarger == null && node.data > value) {
			hm.justLarger = node;
		} else if (node.data > value && node.data < hm.justLarger.data) {
			hm.justLarger = node;
		}

		for (Node child : node.children) {
			multiSolver(child, hm, value, height + 1);
		}
	}

	private class Pair {
		Node node;
		boolean selfDone;
		int nocd;
	}

	public void preOrderIterative() {
		Stack<Pair> stack = new Stack<>();
		Pair pair = new Pair();
		pair.nocd = root.children.size();
		stack.push(pair);
		while (!stack.isEmpty()) {
			Pair top = stack.peek();
			if (!top.selfDone) {
				top.selfDone = true;
				System.out.println(top.node.data + " ");
			} else if (top.nocd < top.node.children.size()) {
				Pair tempPair = new Pair();
				tempPair.node = top.node.children.get(top.nocd);
				top.nocd++;
			} else {
				stack.pop();
			}
		}
	}

	public void levelOrder() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node removed = queue.removeFirst();
			System.out.print(removed.data + " ");
			for (Node child : removed.children) {
				queue.addLast(child);
			}
		}
	}

	public void levelOrderLW() {
		LinkedList<Node> queue1 = new LinkedList<>();
		LinkedList<Node> queue2 = new LinkedList<>();
		queue1.add(root);
		while (!queue1.isEmpty()) {
			Node removed = queue1.removeFirst();
			System.out.print(removed.data + " ");
			for (Node child : removed.children) {
				queue2.addLast(child);
			}
			if (queue1.isEmpty()) {
				queue1 = queue2;
				queue2 = new LinkedList<>();
				System.out.println();
			}
		}
	}

	public void levelOrderLWC() {
		LinkedList<Node> queue1 = new LinkedList<>();
		LinkedList<Node> queue2 = new LinkedList<>();
		int count1 = 1;
		int count2 = 1;
		queue1.add(root);
		while (!queue1.isEmpty()) {
			if (count1 == count2) {
				System.out.print(count1 + ". ");
				count1++;
			}
			Node removed = queue1.removeFirst();
			System.out.print(removed.data + " ");
			for (Node child : removed.children) {
				queue2.addLast(child);
			}
			if (queue1.isEmpty()) {
				queue1 = queue2;
				queue2 = new LinkedList<>();
				System.out.println();
				count2++;
			}
		}
	}

	public int diameter() {
		return diameter(root);
	}

	private int diameter(Node node) {
		int MaxDia = 0;
		int maxHeight1 = -1;
		int maxHeight21 = -1;
		for (Node child : node.children) {
			MaxDia = diameter(child);
		}
		for (int i = 0; i < node.children.size(); i++) {
			int height = height(node.children.get(i));
			if (height > maxHeight1) {
				maxHeight1 = height;
			} else if (height > maxHeight21) {
				maxHeight21 = height;
			}
		}
		return Math.max(MaxDia, (maxHeight1 + maxHeight21 + 2));
	}
}
