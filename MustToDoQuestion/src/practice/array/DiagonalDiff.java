package practice.array;

import java.util.Scanner;

public class DiagonalDiff {

	public static int diff(int[][] arr) {
		int d1 = 0;
        int d2 = 0;
        int row = arr.length;
        int col = arr[0].length;
        for (int i = 0; i < row; i++ ) {
            d1 += arr[i][i];
            d2 += arr[i][row - 1 - i];
            System.out.println(d1 +"->"+d2);
        }
        
        return (int)Math.abs(d1 - d2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] a = new int[n][n];
		
		for (int i = 0 ; i < n; i++)
			for (int j = 0 ; j < n; j++)
				a[i][j] = sc.nextInt();
		System.out.println("Diff : "+diff(a));
	}

}
