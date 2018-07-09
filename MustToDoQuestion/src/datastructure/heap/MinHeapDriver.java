package datastructure.heap;

public class MinHeapDriver {
	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap(7);
		System.out.println("Initial Heap : " + minHeap);
		minHeap.generateHeap();
		System.out.println("Generated Heap : " + minHeap);
		minHeap.insertKey(50);
	}
}
