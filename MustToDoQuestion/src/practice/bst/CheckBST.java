package practice.bst;

import datastructure.bt.*;

public class CheckBST {

	public static int auxCheckBST(Node root, int max, int min) {
		if (root == null)
			return 1;
		if (root.data < max && root.data > min && auxCheckBST(root.left,root.data, min) == 1 && auxCheckBST(root.right, max,root.data) == 1 )
			return 1;
		else
			return 0;
	}
	
	public static int checkBST(Node root) {
		return auxCheckBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nodes = Integer.parseInt(args[0]);
		
		Node root = null;
		root = BST.createBST(root, nodes);
		BST.graphicalView(root);
		System.out.println("\n\n");
		System.out.println(checkBST(root));
	}

}
