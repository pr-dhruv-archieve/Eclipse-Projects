package practice.stack;

import java.util.Scanner;

public class StringRotationByTwoPlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		String[] data = new String[2 * n];
		
		for( int i = 0; i < 2 * n; i++) {
			data[i] = sc.next();
			data[i+1] = sc.next();
		}
		
		
		
	}

}
