package datastructure.avltree;

import java.util.Scanner;

public class AVLTree {

	private static int height(Node root) {
		if (root == null)
			return 0;
		else
			return root.height;
	}

	private static Node rightRotate(Node root) {
        Node temp = root.right;
        Node child = temp.left;

        temp.left = root;
        root.right = child;
		
		root.height = Math.max(height(root.left), height(root.right)) + 1;
		temp.height = Math.max(height(temp.left), height(temp.right)) + 1;
		
		return temp;
	}
	
	private static Node leftRotate(Node root) {
        Node temp = root.right;
        Node child = temp.left;

        temp.left = root;
        root.right = child;

		root.height = Math.max(height(root.left), height(root.right)) + 1;
		temp.height = Math.max(height(temp.left), height(temp.right)) + 1;

		return temp;
	}
	
	public static int getBalance(Node root) {
		if (root == null)
			return 0;
		return (height(root.left) - height(root.right));
	}

	public static Node insert(Node root, int data) {
		if (root == null)
			return new Node(data);
		else if (data < root.data)
			root.left = insert(root.left, data);
		else if (root.data < data)
			root.right = insert(root.right, data);
		
		root.height = 1 + Math.max(height(root.left), height(root.right));
		
		int balance = getBalance(root);
		
		if (balance > 1 && data < root.left.data)
			return rightRotate(root);
		
		if (balance < -1 && data > root.right.data)
			return leftRotate(root);
		
		if (balance > 1 && data > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
		
		if (balance < -1 && data < root.right.data) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}
		return root;
	}

	public static Node createTree(Node root, int nodes) {

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < nodes; i++) {
			int data = sc.nextInt();
			root = insert(root, data);
	
			printChildWise(root);
		}

		return root;
	}
	
	private static void aux(Node root, int space)  {
		for (int i = 1; i < space; ++i)
			System.out.print(" ");
		if (root == null) {
			System.out.println("-");
			return;
		}
		System.out.println(root.data + "->"+root.height);

		aux(root.left, space + 4);
		aux(root.right, space + 4);
		
	}
	
	public static void printChildWise(Node root) {
		aux(root, 0);
	}

}
