package datastructure.heap;

public class MinHeapDriver {
	public static void main(String[] args) {
		MinHeap min = new MinHeap(7);
		System.out.println(min);
		min.generateHeap();
		System.out.println(min);
	}
}
