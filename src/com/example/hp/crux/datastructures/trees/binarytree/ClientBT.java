package com.example.hp.crux.datastructures.trees.binarytree;

public class ClientBT {

	// 50 true 25 false false true 75 false false

	// 50 true 25 true 12 false false true 37 false false true 75 true 62 false false true 87 false false

	// 50 true 25 true 12 false false true 37 true 30 false false true 40 false false true 75 true 62 true 60 false false true 70 false false true 87 false false

	// 10 true 20 true 40 true 60 false false true 70 false true 100 false false false true 30 false true 50 true 80 true 110 false false false true 90 false false

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.display();
		System.out.println("Is Empty?: " + bt.isEmpty());
		System.out.println("Size is: " + bt.getSize());
		System.out.println("Size is: " + bt.sizeRecursive());
		System.out.println("Height is: " + bt.height());
		System.out.println("Found? " + bt.find(12));
		System.out.println("Max is: " + bt.max());
		System.out.print("\nPreOrder: ");
		bt.preOrder();
		System.out.print("\nInOrder: ");
		bt.inOrder();
		System.out.print("\nPostOrder: ");
		bt.postOrder();
		System.out.print("\nPreOrder: ");
		bt.preOrderItertive();
		System.out.print("\nInOrder: ");
		bt.inOrderItertive();
		System.out.print("\nPostOrder: ");
		bt.postOrderItertive();
		System.out.print("\nLevel Order: ");
		bt.levelOrder();
		System.out.println("\nLevel Order Levelwise: ");
		bt.levelOrderLW();
		System.out.println("\nLevel Order Levelwise with Count: ");
		bt.levelOrderLWC();
		System.out.println("Diameter is: " + bt.diameter());
		System.out.println("DiaBetter is: " + bt.diaBetter());
		System.out.println("Is Balanced?:" + bt.checkBalanced());
		bt.largestBST();
		bt.printDoesntHaveSibling();
		System.out.println();
		bt.removeLeaf();
		bt.display();
		System.out.println("Size after removing leaf: "+bt.getSize());
		int[] pre = { 10, 20, 40, 50, 30, 60, 70 };
		int[] in = { 40, 20, 50, 10, 60, 30, 70 };
		int[] post = { 40, 50, 20, 60, 70, 30, 10 };
//		BinaryTree construct=new BinaryTree(pre, in);
		BinaryTree construct=new BinaryTree(post, in);
		construct.display();
		
	}

}
