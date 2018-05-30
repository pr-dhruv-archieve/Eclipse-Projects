package practice.recusion;

import java.util.Scanner;

public class ReverseNumber {

	static int r = 0;
	public static int reverse(int n) {
		if (n==0)
			return n;
		else{
			r = r * 10 + n % 10;
			reverse(n/10);
		}
		return r;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		System.out.println("Rerverse of the "+n+" = "+reverse(n));
		
	}

}
