package practice.bt;

import java.util.Scanner;

import datastructure.bt.BT;
import datastructure.bt.Node;

public class BinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int nodes = Integer.parseInt(args[0]);
		Scanner sc = new Scanner(System.in);
		
		Node root = null;
		root = BT.createBT(root, nodes);
		
		//Preorder with level
		System.out.println("Tree 1 : ");
		BT.graphicalView(root);
		/*
		System.out.print("Preorder Recursive :\t");
		BT.preorderRecursive(root);
		System.out.print("\nPreoder Iterative :\t");
		BT.preorderIterative(root);
		
		
		System.out.println("\nInorder Recursive:\t");
		BT.inorderRecursive(root);
		System.out.println("\nInorder Iterative :\t");
		BT.inorderIterative(root);
		
		System.out.println("\nPostorder Recursive :\t");
		BT.postordeRecursive(root);
		//System.out.println("\nPostorder Iterative :\t");
		
		System.out.println("\nHeight : "+BT.height(root));
		System.out.println("Max Element : "+BT.findMax(root));
		System.out.println("Max Element(Level order) : "+BT.findMaxUsingLevelOrder(root));
		
		int data = sc.nextInt();
		System.out.println("Find Element "+ data+" (Recursion) : "+ BT.findRecursion(root, data));
		System.out.println("Find Element "+ data+" (Level Order): "+ BT.findLevelOrder(root, data));
		
		System.out.println("Size (Recursion) : "+BT.sizeRecursion(root));
		System.out.println("Size (Iterative) : "+BT.sizeIterative(root));
		
		System.out.println("Level order in reverse : ");
		BT.levelOrderInReverse(root);
		
		System.out.println("Level (Iterative): ");
		System.out.println(BT.findHeightIterative(root));
		
		System.out.println("Deepest Node : "+BT.deepestNode(root));
		
		System.out.println("Full Node Count : "+BT.fullNodeCount(root));
		
		System.out.println("Half Node Count : "+BT.halfNodeCount(root));
		
		System.out.println("Leaf Node Count : "+BT.leafNodeCount(root));
		
		Node root1 = BT.createBT(null, nodes);
		System.out.println("Tree 2 :");
		BT.graphicalView(root1);
		System.out.println("Structured Identical : "+BT.isStructuredIdentical(root, root1));
		
		System.out.println("Tree Diameter : "+BT.treeDiameter(root));	
		*/
	}
}