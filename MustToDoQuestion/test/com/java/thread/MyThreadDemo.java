package com.java.thread;

public class MyThreadDemo {

	public static void main(String[] args) {
		
		MyThread t = new MyThread();
		t.start();
		t.interrupt();
		for (int i = 0 ; i < 20; i++)
			System.out.println("main()");

	}

}
 