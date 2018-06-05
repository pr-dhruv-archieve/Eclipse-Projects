package practice.bst;

import datastructure.bt.*;

public class FindMax {

	//recursive
	public static int findMaxRecursive(Node root) {
		if (root == null)
			return -1;
		else if (root.right == null)
			return root.data;
		else
			return findMaxRecursive(root.right);
	}
	
	//Iterative
	public static int findMaxInterative(Node root) {
		if (root == null)
			return -1;
		else {
			while (root.right != null) {
				root = root.right;
			}
			return root.data;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(args[0]);
		Node root = BST.createBST(null, n);
		
		BST.graphicalView(root);

		System.out.println("MAX : "+ findMaxRecursive(root));
		System.out.println("MAX : "+ findMaxInterative(root));
	}

}
