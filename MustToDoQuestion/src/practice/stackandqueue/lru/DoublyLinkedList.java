package practice.stackandqueue.lru;

public class DoublyLinkedList {
	
	private Node head;
	private Node last;
	int size;
	int MAX_CAPACITY = 5;
	
	public DoublyLinkedList() {
		head = last = null;
		size = 0;
	}
	
	public Node insert(int data) {
		Node node = new Node(data);
		
		if (head == null)
			head = last = node;
		else {
			if (this.size < this.MAX_CAPACITY) {
				last.next = node;
				node.prev = last;
			}
			else {
				removeFirst();
				insertLast(new Node(data));
			}
		}
		
		return node;
	}
	
	public Node remove(Node node) {
		Node p = node.prev;
		Node n = node.next;
		
		p.next = n;
		n.prev = p;
		
		node.next = node.prev = null;
		this.size--;
		
		return node;
		
	}
	
	public void insertLast(Node node) {
		last.next = node;
		node.prev =last;
		this.size++;
	}
	
	public void access(Node node) {
		node = remove(node);
		insertLast(node);
	}
	
	public String toString() {
		String out = "[";
		out = out + head.data;
		for (Node cur = head.next; cur != null; cur = cur.next) 
			out = out + ", " + cur.data ;
		out = out + "]";
		return out;
	}
	
	public Integer removeFirst() {
		Integer data = head.data;
		Node temp = head;
		head = head.next;
		temp.next = null;
		return data;
	}
	
}
