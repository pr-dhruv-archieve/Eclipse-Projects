package datastructure.heap;

import java.util.Random;

/* Heap is complete binary tree means every root has at most 2 child and filled form left to right.
 * If root is smaller than its both the child then it is called as MIN HEAP.
 * 
 *          10             10
 *         /  \          /    \  
 *       20   100      15      30  
 *       /           /   \    /   
 *     30          40    50  100   
 * 
 */

public class MinHeap implements Heap {
	
	int[] heap;
	int MAX_CAPACITY;
	int heapSize;
	
	MinHeap() {
		super();
		this.MAX_CAPACITY = 10;
		heap = new int[MAX_CAPACITY];
		this.heapSize = 0;
	}
	
	MinHeap(int size) {
		super();
		this.MAX_CAPACITY = size;
		heap = new int[MAX_CAPACITY];
		this.heapSize = 0;
	}
	
	public String toString() {
		String out = this.heap[0] + "";
		for (int i =1 ;i < this.MAX_CAPACITY; i++)
			out += " " + heap[i];
		return out;
	}	
	
	public void swap(int parentIndex, int childIndex) {
		int temp = this.heap[parentIndex];
		this.heap[parentIndex] = this.heap[childIndex];
		this.heap[childIndex] = temp;
	}
	
	public int getParent(int index) {
		return (index - 1) / 2;
	}
	
	public void generateHeap() {
		Random r = new Random();
	
		for (int i = 1; i <= this.MAX_CAPACITY; i++) {
			int data = r.nextInt() % 20 + 1;
			if (data < 0)
				data *= -1;
			
			insertKey(data);
		}
	}
	
	public void insertKey(int data) {
		
		if (this.heapSize == MAX_CAPACITY)
			throw new HeapOverFlowExcpetion();
		
		this.heapSize++;
		
		int index = this.heapSize - 1;
		this.heap[index] = data;
		// If parent is grater than 
		while (index != 0 && this.heap[getParent(index)] > this.heap[index]) {
			swap(getParent(index), index);
			index = getParent(index);
		}
	}
	/*
	 * If we replace the value at some index and we assumes that new value is smaller than the previous one 
	 */
	public void replace(int index, int newValue) {
		if (this.heap[index] >= newValue)
			return ;
		else {
			this.heap[index] = newValue;
			
			while (index != 0 && this.heap[getParent(index)] > this.heap[index]) {
				swap(getParent(index), index);
				index = getParent(index);
			}
		}
	}
}
