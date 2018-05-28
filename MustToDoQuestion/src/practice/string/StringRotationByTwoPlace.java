package practice.stack;

import java.util.Scanner;

public class StringRotationByTwoPlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		String[] data = new String[2 * n];
		
		for( int i = 0; i < 2 * n; i++)
			data[i] = sc.next();
		
		for (int  i = 0; i < 2 * n; i+=2) {
			String s1 = data[i];
			String s2 = data[i+1];
			
			String s3 = s1.substring(2) + s1.substring(0, 2);
			String s4 = s1.substring(s1.length() - 2) + s1.substring(0,s1.length() - 2);			
			
			if(s2.equals(s3))
				System.out.println("1");
			else if(s2.equals(s4))
				System.out.println("1");
			else
				System.out.println("0");
		}
		
	}

}
