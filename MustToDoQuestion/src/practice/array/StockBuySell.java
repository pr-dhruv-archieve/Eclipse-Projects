package practice.array;

import java.util.LinkedList;
import java.util.Scanner;

public class StockBuySell {

	public static void buySell(int[] arr) {
		int count = 0;
		int n = arr.length;

		LinkedList<LinkedList<Integer>> ll = new LinkedList<LinkedList<Integer>>();

		for (int i = 0; i < n ; i++) {

			// finding local minima
			while ((i < n - 1) && arr[i + 1] <= arr[i])
				i++;

			if (i == n - 1)
				break;

			ll.add(new LinkedList<Integer>());
			ll.get(count).add(i++);
			
			while ((i < n - 1) && (arr[i] >= arr[i - 1]))
				i++;

			ll.get(count).add(i-1);
			count++;
			i--;
		}

		if (count == 0) {
			System.out.println("No day for max profit");
			return;
		} else {
			for (LinkedList<Integer> l : ll) {
				for (Integer j : l) {
					System.out.print(j + " ");
				}
				System.out.println();
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		buySell(arr);

	}

}
