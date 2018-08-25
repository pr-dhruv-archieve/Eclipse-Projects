package MemoryManagement.allocation;

public class MemoryFittingProblem {

	public static void main(String[] args) {
		
		DoublyLinkedList dll = DoublyLinkedList.getList();
		DoublyLinkedList.insert(dll, 15,45);
		DoublyLinkedList.insert(dll, 45,55);
		DoublyLinkedList.insert(dll, 75,100);
		DoublyLinkedList.insert(dll, 200,252);
		System.out.println(dll);
		
		DoublyLinkedList.firstFit(dll, 50);
		System.out.println(dll);
		DoublyLinkedList.worstFit(dll, 15);
		System.out.println(dll);
		DoublyLinkedList.bestFit(dll, 15);
		System.out.println(dll);
	}

}
