package dynamicprograming.basic;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LongestIncreasingSubsequence {

	// to store the longest length of the increasing subsequence of the list
	static int max_ref;
	
	private static int lisAux(int space, int[] arr, int n) {
		
		/*
		 * Base Condition;
		 * if only single element is there in the list then return count = 1;
		 * so returning 1
		 */
		if (n == 1) {
			for (int k = 1; k <= space; k++)
				System.out.print(" ");
			System.out.print(Arrays.toString(arr)+":"+n);
			System.out.println(" => n == 1 so Returning 1");
			return 1;
		}
		/*
		 * max_ending_here is 1 because there will be at least one element in the list which sorted.
		 * res is used to catch the recursive call result;
		 */
		int res, max_ending_here = 1;
		
		//going from 1 to n-1 in the list in bottom up manner of DP
		for (int i = 1; i < n; i++) {
			
			for (int k = 1; k <= space; k++)
				System.out.print(" ");
			System.out.print("At i : " + i + " => Array : ");
			System.out.println(Arrays.toString(arr)+":"+n);
			res = lisAux(space + 4, arr, i);
			for (int k = 1; k <= space; k++)
				System.out.print(" ");
			System.out.println(" " + arr[i-1] + " < " + arr[n-1] +" && ("+ res + " + 1) > " +max_ending_here);
			if (arr[i-1] < arr[n-1] && res + 1 > max_ending_here)
				max_ending_here = res + 1;
		}
		
		//Now comparing the final result with max_ref
		if (max_ref < max_ending_here)
			max_ref = max_ending_here;
		
		return max_ending_here;
	}
	
	public static int lis(int[] arr, int n) {
		max_ref = 1;
		
		lisAux(2, arr, n);
		
		return max_ref;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		int n = 4;
		
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			int e = sc.nextInt() % 20;
			if (e < 0)
				e *= -1;
			arr[i] = e;
		}

		System.out.println(Arrays.toString(arr));
		
		System.out.println(lis(arr, n));
		
		sc.close();

	}

}
