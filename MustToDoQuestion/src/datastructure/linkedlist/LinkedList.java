package datastructure.linkedlist;

import java.util.Random;

public class LinkedList {
	private Node head;
	private Node tail;
	private int size;
	
	public LinkedList () {
		head = tail = new Node();
		size = 0;
	}
	
	public LinkedList(int size) {
		head = tail = new Node();
		this.size = size;
		
		Random r = new Random();
		for (int i = 1; i <= size; i++) {
			int number = r.nextInt()%100;
			if(number < 0)
				number = number * -1;
			Node temp = new Node(number + 1);
			tail.next = temp;
			tail = tail.next;
		}
	}
	
	public void insert(int data) {
		Node temp = new Node(data);
		tail.next = temp;
		tail = tail.next;
		this.size++;
	}
	
	public void insert(Node node) {
		tail.next = node;
		tail = tail.next;
		this.size++;
	}
	
	public void insertAtHead(int data) {
		Node temp = new Node(data);
		Node cur = this.head.next;
		this.head.next = temp;
		temp.next = cur;
		this.size++;
	}
	
	public void insertAtHead(Node node) {
		Node cur = this.head.next;
		this.head.next = node;
		node.next = cur;
		this.size++;
	}
	
	public String toString() {
		String data = "";
		Node cur = this.head.next;
		data += cur.data;
		for (cur = cur.next; cur != null; cur = cur.next)
			data += ("-> " + cur.data);
		data += "-> X";
		return data;
	}
	
	public int getMiddle() {
		Node slow = this.head.next;
		Node fast = this.head.next;
		while(true) {
			if(fast.next == null)
				return slow.data;
			else if(fast.next != null && fast.next.next == null)
				return slow.data;
			else {
				slow = slow.next;
				fast = fast.next.next;						
			}
		}
	}
	
	public LinkedList reverse() {
		
		Node cur = this.head;
		
		LinkedList rll = new LinkedList();
		
		while(cur.next != null) {
			Node temp  = cur.next;
			cur.next = temp.next;
			temp.next = null;
			rll.insertAtHead(temp);
		}
		return rll;
	}
	
	public void rotateToRight(int pos) {
		
	}
	
}
