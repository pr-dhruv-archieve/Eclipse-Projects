package datastructure.heap;

public interface Heap {

	void swap(int parentIndex, int childIndex);
	void insertKey(int data);
	int getParent(int index);
	void generateHeap();
	
	
}
