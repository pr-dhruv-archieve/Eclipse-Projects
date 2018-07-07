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
		this.size = size;
		
		Random r = new Random();
		int number = r.nextInt()%100;
		if(number < 0)
			number = number * -1;
		this.head = this.tail = new Node(number);
		
		for (int i = 2; i <= size; i++) {
			number = r.nextInt()%100;
			if(number < 0)
				number = number * -1;
			Node temp = new Node(number);
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
		Node cur = this.head;
		this.head.next = temp;
		temp.next = cur;
		this.size++;
	}
	
	public void insertAtHead(Node node) {
		Node cur = this.head;
		this.head.next = node;
		node.next = cur;
		this.size++;
	}
	
	public String toString() {
		String data = "";
		Node cur = this.head;
		data += cur.data;
		for (cur = cur.next; cur != null; cur = cur.next)
			data += ("-> " + cur.data);
		return data;
	}
	
	public int getMiddle() {
		Node slow = this.head;
		Node fast = this.head;
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
	
	public Node reverseInPair() {
		if (this.head == null || this.head.next == null)
			return head;
		else  {
			return null;
		}
	
	}
	
}
