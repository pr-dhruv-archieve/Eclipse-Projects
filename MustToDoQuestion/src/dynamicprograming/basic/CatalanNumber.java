package dynamicprograming.basic;

import java.util.Scanner;

public class CatalanNumber {

	//method 1
	public static long method1(int n) {
		long result = 0;
		if (n <= 1)
			return 1;
		else {
			for (int i = 0; i < n; i++)
				result += method1(i) * method1(n - i - 1);
			return result;
		}
	}
	
	//method 2
	private static long ncr(int n, int r) {
		if (r > n-r)
			r = n - r;
		long result = 1;
		
		for (int i = 0; i < r; i++) {
			result *= (n - r);
			result /= (i + 1);
		}
		return result;		
	}
	public static long method2(int n) {
		
		return ncr(2 * n, n) / (n + 1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 						n-1
		 * 						___	
		 * nth catalan P(n)	  = \	P(k) * P(n - k - 1) 
		 * 						/__
		 * 						k=1
		 */
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		System.out.println("Method 1 : " + method1(n));
		
		sc.close();
	}

}
