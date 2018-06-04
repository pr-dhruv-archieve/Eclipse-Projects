package practice.stackandqueue.lru;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
	
	HashMap<Integer, Integer> hm;
	LinkedList<Integer> ll;
	Integer capacity;
	Integer cur;
	
	public LRUCache (int capacity) {
		this.capacity = capacity;
		hm = new HashMap<Integer, Integer>();
		ll = new LinkedList<Integer>();
		this.cur = 0;
	}
	
	public int get(int x) {
		if (!hm.containsKey(x))
			return -1;
		else {
			int index = ll.indexOf(x);
			int value = ll.get(index);
			ll.remove(index);
			this.cur--;
			return hm.get(value);
			
		}
	}
	
	public void set(int x, int y) {
		if (hm.containsKey(x)) {
			int index = ll.indexOf(x);
			int value = ll.get(index);
			ll.remove(index);
			hm.remove(value);
			this.cur--;
			
			hm.put(x, y);
			ll.add(x);
			this.cur++;
		}
		if (this.cur < this.capacity ) {
			hm.put(x, y);
			ll.add(x);
			this.cur++;
		}
		else {
			Integer i = ll.getFirst();
			ll.removeFirst();
			this.cur--;
			
			hm.put(x, y);
			ll.add(x);
			this.cur++;
		}
		
	}
}
