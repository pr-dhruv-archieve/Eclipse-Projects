package dynamicprograming.basic;

import java.util.Scanner;

public class FibbonaciNumber {

	//Recursive Method
	public static long method1(int n) {
		if (n == 0 || n == 1)
			return n;
		else
			return method1(n-1) + method1(n-2);
			
	}
	
	//Top down DP
	private static long auxMethod2(int n, long[] mem) {
		if (mem[n] != 0)
			return mem[n];
		else if (n == 0 || n == 1)
			return mem[n] = n;
		else
			return mem[n] = auxMethod2(n - 1, mem) + auxMethod2(n - 2, mem);
	}
	
	public static long method2(int n) {
		long[] mem = new long[n + 1];
		auxMethod2(n, mem);
		return mem[n];
	}
	
	//Bottom Up DP
	public static long method3(int n)	 {
		long[] mem = new long[n + 1];
		mem[2] = 1;
		for (int i = )
		return mem[n];
	}
	
	//Space optimized method
	public static long method4(int n) {
		
		if (n == 1)
			return 0;
		else if (n == 2)
			return 1;
		else {
			int a = 0, b = 1;
			int c;
			int count = 2;
			
			while (count != n) {
				c = a + b;
				count ++;
				if (count == n)
					return c;
				a = b;
				b = c;
				
			}
		}
	}
 	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		System.out.println("Method 1 : " + method1(n));
		System.out.println("Method 2 : " + method2(n));
		System.out.println("Method 3 : " + method3(n));
		
	}

}
