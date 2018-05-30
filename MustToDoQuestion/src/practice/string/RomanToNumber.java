package practice.string;

import java.util.Scanner;

public class RomanToNumber {

	public static int romanToNumber(String data) {
		int number = 0;

		for (int i = 0; i < data.length(); i++) {
			if(data.charAt(i) == 'M')
				number += 1000;
			else if(data.charAt(i) == 'D')
				number += 500;
			else if(data.charAt(i) == 'C')
				number += 100;
			else if(data.charAt(i) == 'L')
				number += 50;
			else if(data.charAt(i) == 'X')
				number += 10;
			else if(data.charAt(i) == 'V')
				number += 5;
			else if(data.charAt(i) == 'I' && data.charAt(i+1) == 'V') {
				number += 4;
				break;
			}
			else if(data.charAt(i) == 'I' && data.charAt(i+1) == 'X') {
				number += 9;
				break;
			}
			else if(data.charAt(i) == 'I')
				number += 1;
		}
		return number;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		String[] data = new String[n];

		for (int i = 0; i < n; i++)
			data[i] = sc.next();

		for (int i = 0; i < n; i++)
			System.out.println(romanToNumber(data[i]));
	}

}
