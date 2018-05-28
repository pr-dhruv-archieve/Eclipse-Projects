package practice.stack;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

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
			
			char[] c1 = s1.toCharArray();
			Arrays.sort(c1);
			
			char[] c2 = s2.toCharArray();
			Arrays.sort(c2);
			
			s1 = new String(c1);
			s2 = new String(c2);
			
			if(s1.equals(s2))
				System.out.println("YES");
			else
				System.out.println("NO");
			
		}

	}

}
