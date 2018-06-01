package practice.array;

import java.util.Scanner;

public class Sorting012 {

	public static void sort(int data[]) {
		int low = 0;
		int high = data.length-1;
		int mid = 0;
		
		while (mid <= high) {
			switch(data[mid]) {
				case 0:
					int temp = data[mid];
					data[mid] = data[low];
					data[low] = temp;
					
					low++;
					mid++;
					
					break;
				
				case 1 :
					mid++;
					break;
				
				case 2:
					int t = data[mid];
					data[mid] = data[high];
					data[high] = t;
					
					high--;
				
					break;	
			}
		}
		
		for (int i =0 ; i  <data.length; i++)
			System.out.print(data[i]+" ");
		System.out.println();
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] data = new int[n][];

		for (int i = 0; i < n; i++) {
			int size = sc.nextInt();
			data[i] = new int[size];
			for (int j = 0; j < size; j++)
				data[i][j] = sc.nextInt();
		}
		
		for (int i =0 ; i < n ; i++)
			sort(data[i]);

	}

}
