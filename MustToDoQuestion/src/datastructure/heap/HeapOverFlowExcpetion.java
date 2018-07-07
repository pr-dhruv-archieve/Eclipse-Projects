package datastructure.heap;

@SuppressWarnings("serial")
public class HeapOverFlowExcpetion extends RuntimeException {
	
	public HeapOverFlowExcpetion() {
		super();
		System.out.println("Current heap object is full");
	}
	
	public HeapOverFlowExcpetion(String msg) {
		super();
		System.out.println(msg);
	}
	
}
