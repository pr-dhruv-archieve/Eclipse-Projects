package MemoryManagement.allocation;

public class Node {

	public int startingAddress;
	public int endingAddress;
	public Node next;
	public Node prev;
	
	public Node() {
		this.startingAddress = 0;
		this.endingAddress = 0;
		this.next = this.prev = null;
	}
	
	public Node(int startingAddress, int endingAddress) {
		this.startingAddress = startingAddress;
		this.endingAddress = endingAddress;
		this.next = this.prev = null;
	}
}
