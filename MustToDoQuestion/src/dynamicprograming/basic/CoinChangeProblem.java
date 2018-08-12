package dynamicprograming.basic;

import java.util.Arrays;
import java.util.Scanner;

public class CoinChangeProblem {

	// Recursive Method TC : (2^n)
	public static int getCoin(int[] coin, int n, int sum) {

		// If the sum is 0 then only one solution
		if (sum == 0)
			return 1;

		// If the sum is less than zero then no solution
		if (sum < 0)
			return 0;

		// If sum is more than 1 and no coins are available
		if (n <= 0 && sum >= 1)
			return 0;

		return getCoin(coin, n - 1, sum) + getCoin(coin, n, sum - coin[n - 1]);
	}

	// Dynamic Programming
	public static long countWays(int[] coin, int n, int sum) {
		long[] table = new long[sum + 1];
		//System.out.println(Arrays.toString(table));
		
		//base condition
		table[0] = 1;

		for (int i = 0; i < n; i++) {
			for (int j =coin[i]; j <= sum; j++)
				table[j] += table[j - coin[i]];
			//System.out.println(Arrays.toString(table));
		}
		
		//checking for the each coin
		
		return table[sum];
		
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("No of coins : ");
		int n = sc.nextInt();

		int[] coin = new int[n];

		for (int i = 0; i < n; i++)
			coin[i] = sc.nextInt();
		System.out.println(Arrays.toString(coin));
		
		System.out.print("Sum Required : ");
		int sum = sc.nextInt();

		System.out.println("Coins : " + getCoin(coin, n, sum));
		System.out.println("Coins : " + countWays(coin, n, sum));

		sc.close();
	}

}
