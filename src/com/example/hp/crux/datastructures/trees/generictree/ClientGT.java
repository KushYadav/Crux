package com.example.hp.crux.datastructures.trees.generictree;

public class ClientGT {

	// 10 3 20 2 50 0 60 0 30 3 70 0 80 0 90 0 40 1 100 0
	// Tree for MirrorIso
	// 10 3 20 2 50 0 60 0 30 3 70 0 80 0 70 0 20 2 60 0 50 0
	// 10 3 20 0 30 2 50 1 70 1 90 0 60 1 80 1 100 0 40 0
	// 10 1 20 2 30 2 50 0 60 0 70 0 0
	// Tree for Diameter
	// 10 2 20 2 30 0 40 0 50 3 60 0 70 0 80 3 90 1 100 2 110 0 120 1 130 1 140 0 150 0 160 1 170 1 180 1 190 0

	public static void main(String[] args) {
		GenericTree gt = new GenericTree();
		gt.display();
		System.out.println("Size is: " + gt.size());
		System.out.println("Size is: " + gt.sizeRecursive());
		System.out.println("Max is: " + gt.getMax());
		System.out.println("Height is: " + gt.height());
		System.out.println("Found the Number: " + gt.find(80));
		System.out.println("is Mirror iso: " + gt.mirrorIso());
		gt.printAtDepth(1);
		gt.mirror();
		gt.linearize();
		gt.flatten();
		gt.removeLeaf();
		gt.display();
		gt.preOrder();
		System.out.println();
		gt.postOrder();
		System.out.println();
		gt.multiSolver(30);
		gt.preOrder();
		System.out.println();
		gt.levelOrder();
		System.out.println();
		gt.levelOrderLW();
		System.out.println();
		gt.levelOrderLWC();
		System.out.println("Diameter: " + gt.diameter());
	}
}
