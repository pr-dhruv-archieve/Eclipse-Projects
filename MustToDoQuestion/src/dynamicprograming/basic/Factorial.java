package dynamicprograming.basic;

import java.util.Scanner;

public class Factorial {

	//Recursive Method
	public static long method1(int n) {
		if (n == 0 || n == 1)
			return 1;
		else
			return n * method1(n-1);
	}
	
	//Top down DP
	private static long auxMethod2(int n, long[] mem) {
		if (mem[n] != 0)
			return mem[n];
		else if (n == 0 || n == 1)
			return 1;
		else
			return mem[n] = n * auxMethod2(n - 1, mem);
	}
	
	public static long method2(int n) {
		long[] mem = new long[n+1];
		return auxMethod2(n, mem);
	}
	
	//Bottom Up DP
	public static long method3(int n) {
		long[] mem = new long[n + 1];
		mem[0] = 1;
		mem[1] = 1;
		
		if (n == 0 || n == 1)
			return 1;
		else {
			for (int i = 2; i <= n; i++)
				mem[i] = i * mem[i - 1];
			return mem[n];
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
