package practice.array;

import java.util.Scanner;

public class EquilibriumPoint {

	public static int equilibrium(int a[]) {
		
		int sum = 0;
		int leftsum =0;
		
		for (int i =0;i <a.length; i++)
			sum += a[i];
		
		for (int i =0;i < a.length;i++) {
			sum -= a[i];
			
			if (leftsum == sum)
				return i+1;
			
			leftsum += a[i];
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[][] data = new int[n][];

		for (int i = 0; i < n; i++) {
			int s = sc.nextInt();
			data[i] = new int[s];
			for (int j =0;j < s;j++)
				data[i][j] = sc.nextInt();
		}
		
		for (int i=0;i<n;i++)
			System.out.println(equilibrium(data[i]));

	}

}
