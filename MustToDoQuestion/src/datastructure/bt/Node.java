package datastructure.bt;

public class Node {
	public int data;
	public Node left;
	public Node right;

	public Node () {
		this.data = -1;
		this.left = null;
		this.right = null;
	}
	
	public Node (int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
}
