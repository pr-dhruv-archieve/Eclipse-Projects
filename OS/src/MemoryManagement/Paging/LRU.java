package MemoryManagement.Paging;

import java.util.HashMap;

public class LRU {
	HashMap<Integer, Node> map;
	final int MAX_CAPACITY = 5;
	
	
	public LRU() {
		map = new HashMap<Integer, Node>();
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
