package practice.stackandqueue.lru;

public class LRUstart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache cache = new LRUCache(2);
		cache.set(1,2);
		cache.set(2,3);
		cache.set(1,5);
		cache.set(4,5);
		cache.set(6,7);
		System.out.println(cache.get(4));
		System.out.println(cache.get(1));
	}

}
