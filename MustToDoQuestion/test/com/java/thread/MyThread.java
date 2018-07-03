package com.java.thread;

public class MyThread extends Thread{
	
	public void run() {
		try {
			for (int i = 0; i < 20; i++) {
				System.out.println("Child thread is lazy.");
				Thread.sleep(2000);
			}
		}
		catch(InterruptedException e) {
			System.out.println("interrupted");
		}
			
	}
	
}
