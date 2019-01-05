package com.example.hp.crux.datastructures.trees.binarytree;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTree {
	private class Node {
		private int data;
		private Node left;
		private Node right;
	}

	private int size;
	private Node root;

	public BinaryTree() {
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

	private class BSTMover {
		private Node largestNode;
		private int max;
		private int min;
		private int size;
		private boolean isBST;
	}

	public void largestBST() {
		BSTMover bstm = largestBST(root);
		System.out.println("Node of Largest BST is: " + bstm.largestNode.data);
		System.out.println("Size of Largest BST is: " + bstm.size);
	}

	private BSTMover largestBST(Node node) {
		if (node == null) {
			BSTMover bstm = new BSTMover();
			bstm.isBST = true;
			bstm.largestNode = null;
			bstm.max = Integer.MIN_VALUE;
			bstm.min = Integer.MAX_VALUE;
			bstm.size = 0;
			return bstm;
		}
		BSTMover sendBack = new BSTMover();
		BSTMover left = largestBST(node.left);
		BSTMover right = largestBST(node.right);

		if (left.isBST && right.isBST && node.data > left.max && node.data < right.min) {
			sendBack.largestNode = node;
			sendBack.isBST = true;
			sendBack.size = left.size + right.size + 1;
			sendBack.max = Math.max(node.data, left.max);
			sendBack.min = Math.min(node.data, right.min);
			System.out.println(sendBack.max + "," + sendBack.min);
		} else {
			sendBack.isBST = false;
			BSTMover previousLargest = left.size > right.size ? left : right;
			sendBack.size = previousLargest.size;
			sendBack.largestNode = previousLargest.largestNode;
			sendBack.max = previousLargest.max;
			sendBack.min = previousLargest.min;
			System.out.println(sendBack.max + "," + sendBack.min);
		}
		return sendBack;
	}

	public void printDoesntHaveSibling() {
		System.out.print("Nodes Having no siblings are: ");
		printDoesntHaveSibling(root, null, false);
	}

	private void printDoesntHaveSibling(Node node, Node parent, boolean ilc) {
		if (node == null) {
			return;
		}
		if (parent != null) {
			if (ilc == true && parent.right == null) {
				System.out.print(node.data + " ");
			} else if (ilc == false && parent.left == null) {
				System.out.print(node.data + " ");
			}
		}
		printDoesntHaveSibling(node.left, node, true);
		printDoesntHaveSibling(node.right, node, false);
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
			} else if (ilc == false && node.left == null && node.right == null) {
				parent.right = null;
			}
		}
		removeLeaf(node.left, node, true);
		removeLeaf(node.right, node, false);
	}

	public BinaryTree(int[] pre, int[] in) {
//		this.root = constructPreIn(pre, 0, pre.length - 1, in, 0, in.length - 1);
		this.root = constructPostIn(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private Node constructPreIn(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {
		if (plo > phi || ilo > ihi) {
			return null;
		}

		Node node = new Node();
		size++;
		node.data = pre[plo];
		int searchIdx = -1;
		for (int i = ilo; i <= ihi; i++) {
			if (in[i] == pre[plo]) {
				searchIdx = i;
				break;
			}
		}
		int nele = searchIdx - ilo;
		node.left = constructPreIn(pre, plo + 1, plo + nele, in, ilo, searchIdx - 1);
		node.right = constructPreIn(pre, plo + 1 + nele, phi, in, searchIdx + 1, ihi);
		return node;
	}

	private Node constructPostIn(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {
		if (plo > phi || ilo > ihi) {
			return null;
		}

		Node node = new Node();
		this.size++;
		node.data = pre[phi];

		int srchIndex = -1;
		for (int i = ilo; i <= ihi; i++) {
			if (in[i] == pre[phi]) {
				srchIndex = i;
				break;
			}
		}
		int nele = srchIndex - ilo;
		node.left = constructPostIn(pre, plo, plo + nele - 1, in, ilo, srchIndex - 1);
		node.right = constructPostIn(pre, plo + nele, phi - 1, in, srchIndex + 1, ihi);
		return node;
	}
}
