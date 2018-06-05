package practice.bst;

import datastructure.bt.*;

public class FindMin {

	//recursive
	public static int findMinRecursive(Node root) {
		if (root == null)
			return -1;
		else if (root.left == null)
			return root.data;
		else
			return findMinRecursive(root.left);
	}
	
	//Iterative
	public static int findMinInterative(Node root) {
		if (root == null)
			return -1;
		else {
			while (root.left != null) {
				root = root.left;
			}
			return root.data;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(args[0]);
		Node root = BST.createBST(null, n);
		
		BST.graphicalView(root);

		System.out.println("Min : "+ findMinRecursive(root));
		System.out.println("Min : "+ findMinInterative(root));
	}

}
