package datastructure.linkedlist;

public class Node {
	
	int data;
	Node next;
	
	public Node() {
		data = 0;
		next = null;
	}
	
	public Node (int data) {
		this.data = data;
		next = null;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public int getData () {
		return data;
	}
	
}
