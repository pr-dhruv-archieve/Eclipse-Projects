package practice.bst;

import java.util.Scanner;

import datastructure.bst.BST;
import datastructure.bst.Node;

public class LeftView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = null;
		
		Scanner sc= new Scanner(System.in);
		
		int n = sc.nextInt();
		
		root = BST.createBST(root, n);
		
		//BST.inorder(root);
		System.out.println("\n");
		
		BST.graphicalView(root);
	}

}
