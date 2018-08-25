package dynamicprograming;

import java.util.Arrays;
import java.util.Scanner;

public class KnapSack01 {

	public static int recursive(int rw, int[] w, int[] v, int n) {
		if (n == 0 || rw == 0)
			return 0;

		// when the weight of the last item is higher than requirement then just
		// ignore that element
		else if (w[n - 1] > rw)
			return recursive(rw, w, v, n - 1);
		else
			return Math.max(v[n - 1] + recursive(rw - w[n - 1], w, v, n - 1), recursive(rw, w, v, n - 1));
	}

	public static int bottom_up_dp(int W, int wt[], int val[], int n) {
		int i, w;
		int mem[][] = new int[n + 1][W + 1];
		
		for (i = 0; i <= n; i++)
			for (w = 0; w <= W; w++)
				mem[i][w] = -1;
		
		// Build table K[][] in bottom up manner
		for (i = 0; i <= n; i++) {
			for (w = 0; w <= W; w++) {
				if (i == 0 || w == 0)
					mem[i][w] = 0;
				else if (wt[i - 1] <= w)
					mem[i][w] = Math.max(val[i - 1] + mem[i - 1][w - wt[i - 1]], mem[i - 1][w]);
				else
					mem[i][w] = mem[i - 1][w];
				for (int[] k : mem) {
					System.out.println(Arrays.toString(k));
				}
			}
		}

		return mem[n][W];
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Number of the items : ");
		int n = sc.nextInt();

		int[] v = new int[n];
		int[] w = new int[n];

		System.out.println("Values of the price : ");
		for (int i = 0; i < n; i++)
			v[i] = sc.nextInt();

		System.out.println("Weights : ");
		for (int i = 0; i < n; i++)
			w[i] = sc.nextInt();

		System.out.println("Required weight : ");
		int rw = sc.nextInt();

		// System.out.println(recursive(rw, w, v, n));
		System.out.println(bottom_up_dp(rw, w, v, n));
		sc.close();

	}

}
