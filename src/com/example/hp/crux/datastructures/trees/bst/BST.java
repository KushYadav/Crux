package com.example.hp.crux.datastructures.trees.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class BST {
	private class Node {
		private int data;
		private Node left;
		private Node right;
	}

	private int size;
	private Node root;

	public BST() {
		Scanner scn = new Scanner(System.in);
		root = takeInput(null, false, scn);
	}

	private Node takeInput(Node parent, boolean ilc, Scanner scn) {
		if (parent == null) {
			System.out.println("Enter the data for the root child");
		} else {
			if (ilc) {
				System.out.println("Enter the data for the left child of " + parent.left);
			} else {
				System.out.println("Enter the data for the right child of " + parent.right);
			}
		}
		Node child = new Node();
		child.data = scn.nextInt();
		size++;
		System.out.println("Does " + child.data + " has left child");
		boolean hlc = scn.nextBoolean();
		if (hlc) {
			child.left = takeInput(child, true, scn);
		}
		System.out.println("Does " + child.data + " has right child");
		boolean hrc = scn.nextBoolean();
		if (hrc) {
			child.right = takeInput(child, false, scn);
		}
		return child;
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			System.out.print(node.left.data);
		}
		System.out.print("	<=" + node.data + "=>	");
		if (node.right != null) {
			System.out.print(node.right.data);
		}
		System.out.println();
		display(node.left);
		display(node.right);
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0) ? true : false;
	}

	public int sizeRecursive() {
		return sizeRecursive(root);
	}

	private int sizeRecursive(Node node) {
		if (node == null) {
			return 0;
		}
		return sizeRecursive(node.left) + sizeRecursive(node.right) + 1;
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}
		return Math.max(height(node.left), height(node.right)) + 1;
	}

	public boolean find(int value) {
		return find(root, value);
	}

	private boolean find(Node node, int value) {
		if (node == null) {
			return false;
		}
		if (find(node.left, value) == true || find(node.right, value) == true || node.data == value) {
			return true;
		}
		return false;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}
		return Math.max(max(node.left), Math.max(max(node.right), node.data));
	}

	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}

	public void postOrder() {
		postOrder(root);
	}

	private void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + " ");
	}

	private class Pair {
		private Node node;
		private boolean leftDone;
		private boolean selfDone;
		private boolean rightDone;
	}

	public void preOrderItertive() {
		Stack<Pair> stack = new Stack<>();
		Pair first = new Pair();
		first.node = root;
		stack.push(first);
		while (stack.isEmpty() != true) {
			Pair peek = stack.peek();
			if (peek.selfDone != true) {
				peek.selfDone = true;
				System.out.print(peek.node.data + " ");
			} else if (peek.leftDone != true) {
				peek.leftDone = true;
				Pair push = new Pair();
				push.node = peek.node.left;
				if (push.node != null) {
					stack.push(push);
				}
			} else if (peek.rightDone != true) {
				peek.rightDone = true;
				Pair push = new Pair();
				push.node = peek.node.right;
				if (push.node != null) {
					stack.push(push);
				}
			} else {
				stack.pop();
			}
		}
	}

	public void inOrderItertive() {
		Stack<Pair> stack = new Stack<>();
		Pair first = new Pair();
		first.node = root;
		stack.push(first);
		while (stack.isEmpty() != true) {
			Pair peek = stack.peek();
			if (peek.leftDone != true) {
				peek.leftDone = true;
				Pair push = new Pair();
				push.node = peek.node.left;
				if (push.node != null) {
					stack.push(push);
				}
			} else if (peek.selfDone != true) {
				peek.selfDone = true;
				System.out.print(peek.node.data + " ");
			} else if (peek.rightDone != true) {
				peek.rightDone = true;
				Pair push = new Pair();
				push.node = peek.node.right;
				if (push.node != null) {
					stack.push(push);
				}
			} else {
				stack.pop();
			}
		}
	}

	public void postOrderItertive() {
		Stack<Pair> stack = new Stack<>();
		Pair first = new Pair();
		first.node = root;
		stack.push(first);
		while (stack.isEmpty() != true) {
			Pair peek = stack.peek();
			if (peek.leftDone != true) {
				peek.leftDone = true;
				Pair push = new Pair();
				push.node = peek.node.left;
				if (push.node != null) {
					stack.push(push);
				}
			} else if (peek.rightDone != true) {
				peek.rightDone = true;
				Pair push = new Pair();
				push.node = peek.node.right;
				if (push.node != null) {
					stack.push(push);
				}
			} else if (peek.selfDone != true) {
				peek.selfDone = true;
				System.out.print(peek.node.data + " ");
			} else {
				stack.pop();
			}
		}
	}

	public void levelOrder() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);
		while (!queue.isEmpty()) {
			Node removed = queue.removeFirst();
			System.out.print(removed.data + " ");
			if (removed.left != null) {
				queue.addLast(removed.left);
			}
			if (removed.right != null) {
				queue.addLast(removed.right);
			}
		}
	}

	public void levelOrderLW() {
		LinkedList<Node> queue1 = new LinkedList<>();
		LinkedList<Node> queue2 = new LinkedList<>();
		queue1.addLast(root);
		while (!queue1.isEmpty()) {
			Node removed = queue1.removeFirst();
			System.out.print(removed.data + " ");
			if (removed.left != null) {
				queue2.addLast(removed.left);
			}
			if (removed.right != null) {
				queue2.addLast(removed.right);
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
		queue1.addLast(root);
		int count1 = 1;
		int count2 = 1;
		while (!queue1.isEmpty()) {
			Node removed = queue1.removeFirst();
			if (count1 == count2) {
				System.out.print(count1 + ". ");
				count1++;
			}
			System.out.print(removed.data + " ");

			if (removed.left != null) {
				queue2.addLast(removed.left);
			}
			if (removed.right != null) {
				queue2.addLast(removed.right);
			}
			if (queue1.isEmpty()) {
				queue1 = queue2;
				count2++;
				queue2 = new LinkedList<>();
				System.out.println();
			}
		}
	}

	public int diameter() {
		return diameter(root);
	}

	private int diameter(Node node) {
		if (node == null) {
			return 0;
		}
		int maxDia = Math.max(diameter(node.left), diameter(node.right));
		int heightSum = height(node.left) + height(node.right);
		return Math.max(maxDia, heightSum + 2);
	}

	private class DiaMover {
		private int diameter;
		private int height;
	}

	public int diaBetter() {
		DiaMover dm = diaBetter(root);
		return dm.diameter;
	}

	private DiaMover diaBetter(Node node) {
		if (node == null) {
			DiaMover dm = new DiaMover();
			dm.diameter = 0;
			dm.height = -1;
			return dm;
		}
		DiaMover sendBack = new DiaMover();
		DiaMover left = diaBetter(node.left);
		DiaMover right = diaBetter(node.right);
		sendBack.diameter = Math.max(left.diameter, Math.max(right.diameter, left.height + right.height + 2));
		sendBack.height = Math.max(left.height, right.height) + 1;
		return sendBack;
	}

	private class BalMover {
		private boolean isBalanced;
		private int height;
	}

	public boolean checkBalanced() {
		BalMover bm = checkBalanced(root);
		return bm.isBalanced;
	}

	private BalMover checkBalanced(Node node) {
		if (node == null) {
			BalMover bm = new BalMover();
			bm.height = -1;
			bm.isBalanced = true;
			return bm;
		}
		BalMover sendBack = new BalMover();
		BalMover left = checkBalanced(node.left);
		BalMover right = checkBalanced(node.right);
		if (!left.isBalanced || !right.isBalanced || Math.abs(left.height - right.height) > 1) {
			sendBack.isBalanced = false;
		} else {
			sendBack.isBalanced = true;
		}
		sendBack.height = Math.max(left.height, right.height) + 1;
		return sendBack;
	}

	public void removeLeaf() {
		removeLeaf(root, null, false);
	}

	private void removeLeaf(Node node, Node parent, boolean ilc) {
		if (node == null) {
			return;
		}
		if (parent != null) {
			if (ilc == true && node.left == null && node.right == null) {
				parent.left = null;
				size--;
			} else if (ilc == false && node.left == null && node.right == null) {
				parent.right = null;
				size--;
			}
		}
		removeLeaf(node.left, node, true);
		removeLeaf(node.right, node, false);
	}

	public BST(int[] in) {
		this.root = constructBST(in, 0, in.length - 1);
	}

	private Node constructBST(int[] in, int lo, int hi) {
		if (lo > hi) {
			return null;
		}
		int mid = (lo + hi) / 2;
		Node node = new Node();
		node.data = in[mid];
		size++;
		node.left = constructBST(in, lo, mid - 1);
		node.right = constructBST(in, mid + 1, hi);
		return node;
	}

	public int getMax() {
		return getMax(root).data;
	}

	private Node getMax(Node node) {
		if (node.right == null) {
			return node;
		} else {
			return getMax(node.right);
		}
	}

	public ArrayList<Integer> listPreOrder() {
		ArrayList<Integer> preOrder = new ArrayList<>();
		listPreOrder(preOrder, root);
		return preOrder;
	}

	private void listPreOrder(ArrayList<Integer> preOrder, Node node) {
		if (node == null) {
			return;
		}
		preOrder.add(node.data);
		listPreOrder(preOrder, node.left);
		listPreOrder(preOrder, node.right);
	}

	public ArrayList<Integer> listInOrder() {
		ArrayList<Integer> inorder = new ArrayList<>();
		listInOrder(inorder, root);
		return inorder;

	}

	private void listInOrder(ArrayList<Integer> inorder, Node node) {
		if (node == null) {
			return;
		}
		listInOrder(inorder, node.left);
		inorder.add(node.data);
		listInOrder(inorder, node.right);
	}

	public ArrayList<Integer> listPostOrder() {
		ArrayList<Integer> postOrder = new ArrayList<>();
		listPostOrder(postOrder, root);
		return postOrder;

	}

	private void listPostOrder(ArrayList<Integer> postOrder, Node node) {
		if (node == null) {
			return;
		}
		listPostOrder(postOrder, node.left);
		listPostOrder(postOrder, node.right);
		postOrder.add(node.data);
	}

	public class heapmover {
		int sum;
	}

	public void rwsol() { // Assign sum to the value of node starting from right
		heapmover mover = new heapmover();
		rwsol(mover, root);
	}

	private void rwsol(heapmover mover, Node node) {
		if (node == null) {
			return;
		}
		rwsol(mover, node.right);
		int temp = node.data;
		node.data = mover.sum;
		mover.sum += temp;
		rwsol(mover, node.left);
	}

	public void pir(int lo, int hi) {
		pir(root, lo, hi);
	}

	private void pir(Node node, int lo, int hi) {
		if (node == null) {
			return;
		}
		if (node.data < lo) {
			pir(node.right, lo, hi);
		} else if (node.data > hi) {
			pir(node.left, lo, hi);
		} else {
			System.out.print(node.data + " ");
			pir(node.left, lo, hi);
			pir(node.right, lo, hi);
		}
	}

	public void addNode(int value) {
		addNode(root, value);
	}

	private void addNode(Node node, int value) {
		if (value < node.data && node.left == null) {
			Node add = new Node();
			add.data = value;
			node.left = add;
			size++;
		}
		if (value > node.data && node.right == null) {
			Node add = new Node();
			add.data = value;
			node.right = add;
			size++;
		}
		if (value < node.data) {
			addNode(node.left, value);
		}
		if (value > node.data) {
			addNode(node.right, value);
		}
	}

	public void removeNode(int value) {
		removeNode(null, root, false, value);
	}

	private void removeNode(Node parent, Node child, boolean ilc, int value) {
		if (value > child.data) {
			removeNode(child, child.right, false, value);
		} else if (value < child.data) {
			removeNode(child, child.left, true, value);
		} else {
			if (child.left != null && child.right != null) {
				int lm = max(child.left);
				child.data = lm;
				removeNode(child, child.left, true, lm);
			} else {
				size--;
				if (ilc) {
					parent.left = child.left != null ? child.left : child.right;
				} else {
					parent.right = child.left != null ? child.left : child.right;
				}
			}
		}
	}
}
