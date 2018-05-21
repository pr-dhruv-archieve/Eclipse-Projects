package practice.stack;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		String[] data = new String[n];
		
		for(int i = 0 ; i < n ; i++)
			data[i] = sc.next();
		
		for(int i = 0 ; i < n ; i++) {
			String[] reversed = data[i].split("\\.");
			System.out.print(reversed[reversed.length - 1]);
			for(int j = reversed.length - 2 ; j >= 0 ; j--)
				System.out.print("." + reversed[j]);
			System.out.println();
		}

	}

}
