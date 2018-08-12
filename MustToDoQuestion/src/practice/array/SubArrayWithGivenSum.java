package practice.array;

import java.util.HashMap;
import java.util.Scanner;

public class SubArrayWithGivenSum {

	//Method 1
	public static void method1 (int[] a, int sum) {
		
		int cur_sum = 0;
		
		for (int i = 0; i < a.length; i++) {
			
			cur_sum = a[i];
			
			for (int j = i + 1; j <= a.length; j++) {
				if (cur_sum == sum) {
					System.out.println("Index : "+ i + " -> " + (j-1));
					return ;
				}
				if (cur_sum > sum || j == a.length)
					break;
				cur_sum = cur_sum + a[j];
			}
			
		}
		
		System.out.println("No sb array.");
		return ;
		
	}
	
	//Method 2
	public static void method2(int[] a, int sum) {
		int cur = a[0];
		int start = 0;
		
		for (int i = 1; i < a.length; i++) {
			
			while (cur > sum && start < i-1) {
				cur -= a[start++];
			}
			
			if (cur == sum) {
				System.out.println("Index : " + start + " -> " + (i-1));
				return ;
			}
			
			if ( i < a.length ) 
				cur += a[i];
		}
		
		System.out.println("No sub-array found.");
	}
	
	//Best Way
	public static void method3(int[] a, int sum) {
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int cur = 0;
		int i = 0;
		for (i = 0; i < a.length; i++) {
			
			cur += a[i];
			
			if (cur == sum) {
				System.out.println("Index : 0 -> " + i);
			}
			
			if (map.containsKey(cur - sum)) {
				System.out.println("Index : "+ (map.get(cur - sum) + 1) + " -> " + i);
			}
			
			map.put(cur, i);
		}
		map.put(sum, i);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			int sum = sc.nextInt();
			
			int[] a = new int[n];
			
			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();
			
			//method1(a, sum);
			//method2(a, sum);
			method3(a, sum);
		}
		
		sc.close();
	}

}
