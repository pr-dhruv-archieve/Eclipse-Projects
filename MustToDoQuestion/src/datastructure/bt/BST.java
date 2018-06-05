package datastructure.bt;

import java.util.Random;

public class BST {

	public static Node insert(Node root, int data) {
		if (root == null) {
			root = new Node(data);
		}
		else {
			if (data < root.data)
				root.left = insert(root.left, data);
			if (data > root.data)
				root.right = insert(root.right, data);
		}
		return root;
	}
	
	public static Node createBST(Node root, int n) {
		Random r = new Random();
		for (int i = 1; i <= n; i++) {
			int data = r.nextInt() % 100 + 1;
			if (data < 0)
				data = data * -1;
			root = insert(root, data);
		}
		return root;
	}
	
	public static void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
	}
	
	public static void preorder(Node root) {
		if (root != null) {
			System.out.print(root.data+" ");
			inorder(root.left);
			inorder(root.right);
		}
	}
	
	public static void postorder(Node root) {
		if (root != null) {
			inorder(root.left);
			inorder(root.right);
			System.out.print(root.data+" ");
		}
	}
	
	private static void auxPrint(Node root, int space) {
		if (root == null)	return;
		
		for (int i=1;i<space;++i)
			System.out.print(" ");
		System.out.println(root.data);
		
		auxPrint(root.left, space+4);
		auxPrint(root.right, space+4);
	}
	
	public static void graphicalView(Node root) {
		auxPrint(root, 0);
	}

}
