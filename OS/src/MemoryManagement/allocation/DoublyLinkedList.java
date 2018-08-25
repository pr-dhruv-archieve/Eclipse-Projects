package MemoryManagement.allocation;

public class DoublyLinkedList {

	private static DoublyLinkedList dll = null;

	private Node head;
	private Node tail;
	int size;

	private DoublyLinkedList() {
		this.head = this.tail = new Node();
		this.size = 0;
	}

	public static DoublyLinkedList getList() {
		if (dll == null)
			return new DoublyLinkedList();
		else
			return dll;
	}

	public Node getHead() {
		return head;
	}

	public Node getTail() {
		return tail;
	}

	public static void insert(DoublyLinkedList dll, int startingAddress, int endingAddress) {
		if (dll.getHead() == null) {
			dll.head = dll.tail = new Node(startingAddress, endingAddress);
			dll.size++;
		} else {
			dll.tail.next = new Node(startingAddress, endingAddress);
			dll.tail = dll.tail.next;
			dll.size++;
		}
	}

	public static boolean firstFit(DoublyLinkedList dll, int reqSpace) {
		Node node = null;
		for (Node cur = dll.head; cur.next != null; cur = cur.next) {
			int freeSpace = cur.next.startingAddress - cur.endingAddress;
			if (freeSpace >= reqSpace) {
				node = new Node(cur.endingAddress, cur.endingAddress + reqSpace);

				Node temp = cur.next;

				node.next = temp;
				node.prev = cur;

				cur.next = node;

				temp.prev = node;

				return true;
			}
		}
		return false;

	}

	public static boolean worstFit(DoublyLinkedList dll, int reqSpace) {
		int space = 0;
		Node temp = null;
		for (Node cur = dll.head; cur.next != null; cur = cur.next) {
			int freeSpace = cur.next.startingAddress - cur.endingAddress;
			if (freeSpace >= space) {
				temp = cur;
				space = freeSpace;
			}
		}
		if (space < reqSpace)
			return false;
		else {
			Node node = new Node(temp.endingAddress, temp.endingAddress + reqSpace);
			Node cur = temp;
			temp = temp.next;
			node.next = temp;
			node.prev = cur;

			cur.next = node;

			temp.prev = node;

			return true;
		}
	}
	
	public static boolean bestFit(DoublyLinkedList dll, int reqSpace) {
		int space = Integer.MAX_VALUE;
		Node temp = null;
		for (Node cur = dll.head; cur.next != null; cur = cur.next) {
			int freeSpace = cur.next.startingAddress - cur.endingAddress;
			if (freeSpace < space && freeSpace >= reqSpace) {
				temp = cur;
				space = freeSpace;
			}
		}
		if (space < reqSpace)
			return false;
		else {
			Node node = new Node(temp.endingAddress, temp.endingAddress + reqSpace);
			Node cur = temp;
			temp = temp.next;
			node.next = temp;
			node.prev = cur;

			cur.next = node;

			temp.prev = node;

			return true;
		}
	}

	public String toString() {
		String s = this.getHead().startingAddress + "";

		for (Node cur = this.getHead().next; cur != null; cur = cur.next)
			s += "->[" + cur.startingAddress + "-" + cur.endingAddress + "]";
		return s;
	}

}
