package MemoryManagement.Paging;

import java.util.LinkedList;
import java.util.Queue;

public class FIFO {
	
	static Queue<Integer> q;
	static int size;
	private static final int MAX_CAPACITY = 3;
	
	public FIFO() {
		q = new LinkedList<Integer>(); 
		size = 0;
	}
	
	public static void insert(int item) {
		if (size >= MAX_CAPACITY) {
			q.poll();
			size--;
		}
		q.offer(item);
		size++;
	}
	
	public static int delete() {
		size--;
		return q.poll();
	}
	
	public String toString() {
		String s = "";
		for (Integer i : q) {
			s += i+" ";
		}
		return s;
	}
	
	public static void main(String[] args) {
		FIFO pr = new FIFO();
		FIFO.insert(10);
		FIFO.insert(20);
		FIFO.insert(30);
		FIFO.insert(40);
		FIFO.insert(50);
		FIFO.insert(60);
		System.out.println(pr);
	}
}
