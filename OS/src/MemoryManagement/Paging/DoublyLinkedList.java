package MemoryManagement.Paging;

public class DoublyLinkedList {
	int size;
	Node head;
	Node tail;
	final int MAX_CAPACITY = 5;
	
	DoublyLinkedList() {
		this.size = 0;
		this.head = this.tail = null;
	}
	
	public void insert(int data) {
		
		if (head == null && tail == null) {
			Node node = new Node(data);
			head = node;
			tail = node;
		}
		else {
			if (size >= MAX_CAPACITY)
				delete();
			Node node = new Node(data);
			tail.next = node;
			node.prev = tail;
			tail = tail.next;
		}
		this.size++;
	}
	
	public int delete() {
		Node node = tail.prev;
		node.next = null;
		tail.prev = null;
		int x = tail.data;
		tail = null;
		size--;
		return x;
	}
	
	public void update(Node node) {
		
	}
	
}
