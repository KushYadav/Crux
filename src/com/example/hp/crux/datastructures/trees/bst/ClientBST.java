package com.example.hp.crux.datastructures.trees.bst;

public class ClientBST {

	// 50 true 25 false false true 75 false false

	// 50 true 25 true 12 false false true 37 false false true 75 true 62 false false true 87 false false

	// 50 true 25 true 12 false false true 37 true 30 false false true 40 false false true 75 true 62 true 60 false false true 70 false false true 87 false false

	public static void main(String[] args) {
		BST bst = new BST();
		bst.display();
		System.out.println("Is Empty?: " + bst.isEmpty());
		System.out.println("Size is: " + bst.getSize());
		System.out.println("Size is: " + bst.sizeRecursive());
		System.out.println("Height is: " + bst.height());
		System.out.println("Found? " + bst.find(12));
		System.out.println("Max is: " + bst.max());
		System.out.print("\nPreOrder: ");
		bst.preOrder();
		System.out.print("\nInOrder: ");
		bst.inOrder();
		System.out.print("\nPostOrder: ");
		bst.postOrder();
		System.out.print("\nPreOrder: ");
		bst.preOrderItertive();
		System.out.print("\nInOrder: ");
		bst.inOrderItertive();
		System.out.print("\nPostOrder: ");
		bst.postOrderItertive();
		System.out.print("\nLevel Order: ");
		bst.levelOrder();
		System.out.println("\nLevel Order Levelwise: ");
		bst.levelOrderLW();
		System.out.println("\nLevel Order Levelwise with Count: ");
		bst.levelOrderLWC();
		System.out.println("Diameter is: " + bst.diameter());
		System.out.println("DiaBetter is: " + bst.diaBetter());
		System.out.println("Is Balanced?:" + bst.checkBalanced());
		System.out.println("Max is: " + bst.getMax());
		System.out.print("\nPreOrder: " + bst.listPreOrder());
		System.out.print("\nInOrder: " + bst.listInOrder());
		System.out.println("\nPostOrder: " + bst.listPostOrder());
		System.out.print("Nodes between the range are: ");
		bst.pir(10, 50);
		System.out.println();
		bst.removeLeaf();
		bst.display();
		bst.addNode(20);
		bst.removeNode(75);
		bst.display();
//		bst.rwsol();
//		bst.display();
	}

}
