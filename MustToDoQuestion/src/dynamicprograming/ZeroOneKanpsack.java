package dynamicprograming;

import java.util.Scanner;

public class ZeroOneKanpsack {
	
	public static long topDownDP(int items, int reqweight, int[] weight, int[] cost) {
		
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Total item : ");
		int n = sc.nextInt();
		
		int[] weight = new int[n];
		int[] cost = new int[n];
		
		System.out.print("Weight : ");
		for (int i = 0; i < n; i++)
			weight[i] = sc.nextInt();
		
		System.out.print("Cost : ");
		for (int i = 0; i < n; i++)
			cost[i] = sc.nextInt();
		
		System.out.print("Required Weight : ");
		int w = sc.nextInt();
		System.out.println(topDownDP(n, w, weight, cost));
		
	}

}
