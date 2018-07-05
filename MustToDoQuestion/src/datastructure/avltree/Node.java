package datastructure.avltree;

public class Node {
	int data;
	Node left;
	Node right;
	int height;
	
	public Node () {
		this.data = this.height = 0;
		this.left = this.right = null;
	}
	
	public Node (int data) {
		this.data = data;
		this.left = this.right = null;
		this.height = 1;
	}
	
}
