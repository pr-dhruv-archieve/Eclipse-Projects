package practice.array;

import java.util.Scanner;

public class MaximumSumIncreasingSubsequence {

	private static int method(int[] a) {
		
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for (int i = 0; i <= tc; i++) {
			
			int n = sc.nextInt();
			int[] a = new int[n];
			
			for (int j = 0; j < n; j++)
				a[i] = sc.nextInt();
			
			System.out.println(method(a));
			
		}
		
		sc.close();
	}

}
