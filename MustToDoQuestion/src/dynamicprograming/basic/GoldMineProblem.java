package dynamicprograming.basic;

import java.util.Scanner;

public class GoldMineProblem {

	public static void print(int[][] grid, int m, int n) {
		String table = "";
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++)
				table += grid[i][j] + " ";
			table += "\n";
		}
		System.out.println(table);
	}
	
	public static int goldMining(int[][] grid, int m, int n) {
		
		int[][] gridTable = new int[m][n];
		
		for (int col = n-1; col >= 0; col--) {
			for (int row = 0; row < m; row++) {
				
				//Going to -> (right direction)
				int right = (col == n-1) ? 0 : gridTable[row][col+1];
				
				int right_up = (row == 0 || col == n-1) ? 0 : gridTable[row - 1][col + 1];
				
				int right_down = (row == m-1 || col == n-1) ? 0 : gridTable[row + 1][col + 1];
				
				gridTable[row][col] = grid[row][col] + Math.max(right, Math.max(right_up, right_down));
			}	
			//print(gridTable, m, n);
		}
		
		int res = gridTable[0][0];
		
		for (int i =0 ;i < m; i++)
			res = Math.max(res, gridTable[i][0]);
		
		return res;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int row = sc.nextInt();
		int col = sc.nextInt();
		
		int[][] grid = new int[row][col];
		
		for (int i =0 ; i < row; i++)
			for (int j = 0; j < col; j++)
				grid[i][j] = sc.nextInt();
		
		System.out.println(goldMining(grid, row, col));
	}

}
