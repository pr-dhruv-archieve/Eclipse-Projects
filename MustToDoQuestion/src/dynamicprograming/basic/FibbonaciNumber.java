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
		long[] mem = new long[n + 2];
		mem[1] = 1;
		for (int i = 2; i <= n; i++)
			mem[i] = mem[i - 1] + mem[i - 2];
		return mem[n];
	}
	
	//Space optimized method
	public static long method4(int n) {
		
		if (n == 0)
			return 0;
		else  {
			int a = 0;
			int b = 1;
			int c = 0;
			
			for (int i = 2; i <= n; i++) {
				c = a + b;
				a = b;
				b = c;
			}
			return c;
		}
	}
 	
	//Method 5 => using 
	private static void multiply(long[][] matrix, long[][] multiply) {
		long w = matrix[0][0] * multiply[0][0] + multiply[0][1] * matrix[1][0];
		long x = matrix[0][0] * multiply[0][1] + multiply[0][1] * matrix[1][1];
		long y = matrix[1][0] * multiply[0][0] + multiply[1][1] * matrix[1][0];
		long z = matrix[1][0] * multiply[0][1] + multiply[1][1] * matrix[1][1];
		
		matrix[0][0] = w;
		matrix[0][1] = x;
		matrix[1][0] = y;
		matrix[1][1] = z;
	}
	
	private static void power(long[][] matrix, long n) {
		
		long[][] multiply = new long[][]{{1, 1},{1, 0}};
		for (int i = 2; i <= n; i++)
			multiply(matrix, multiply);
		
	}
	
	public static long method5(int n) {
		long[][] matrix = new long[][]{{1, 1},{1, 0}};
		
		if (n == 0)
			return n;
		power(matrix, n - 1);
		return matrix[0][0];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//int n = sc.nextInt();
		int n = 9;
		System.out.println("Method 1 : " + method1(n));
		System.out.println("Method 2 : " + method2(n));
		System.out.println("Method 3 : " + method3(n));
		System.out.println("Method 4 : " + method4(n));
		System.out.println("Method 5 : " + method5(n));
		
	}

}
