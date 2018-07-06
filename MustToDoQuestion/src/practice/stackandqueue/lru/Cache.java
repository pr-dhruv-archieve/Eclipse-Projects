package practice.stackandqueue.lru;

import java.util.HashMap;

public class Cache {
	
	HashMap<Integer, Node> map;
	DoublyLinkedList list;
	
	Cache() {
		map = new HashMap<Integer, Node>();
		list = new DoublyLinkedList();
	}
	
	public void insert(Integer data) {
		if (map.containsKey(data)) {
			list.access((Node) map.get(data));
		}
		else {
			map.remove(list.removeFirst());
			list.insertLast(new Node (data));
		}
		System.out.println(list);
	}
	
	public void remove(Integer data)  {
		if (map.containsKey(data))  {
			Node node = map.get(data);
			map.remove(data);
			list.remove(node);
		}
		else {
			System.out.println("No entry found.");
		}
		System.out.println(list);
	}
	
}
