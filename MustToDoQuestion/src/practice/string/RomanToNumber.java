package practice.string;

import java.util.Scanner;

public class RomanToNumber {

	public static int romanToNumber(String data) {
		int number = 0;
		
		int pos;
		
		if ((pos = data.indexOf("IV")) > 0) 
			number += 4;
		else if ((pos = data.indexOf("IX")) > 0)
			number += 9;
		else
			pos = data.length();
		
		for (int i = 0; i < pos; i++) {
			if(data.charAt(i) == 'M')
				number += 1000;
			else if(data.charAt(i) == 'D')
				number += 500;
			else if(data.charAt(i) == 'C') {
				if (i+1 < pos) {
					if (data.charAt(i + 1) == 'M'){
						number += 900;
						i++;
						continue;
					}
					else if (data.charAt(i + 1) == 'D') {
						number += 400;
						i++;
						continue;
					}
				}
				number += 100;
			}
				
			else if(data.charAt(i) == 'L')
				number += 50;
			else if(data.charAt(i) == 'X') {
				if (i+1 < pos) {
					if (data.charAt(i + 1) == 'L'){
						number += 40;
						i++;
						continue;
					}
					else if (data.charAt(i + 1) == 'C') {
						number += 90;
						i++;
						continue;
					}
				}
				number += 10;
			}
			else if(data.charAt(i) == 'V')
				number += 5;
			else if(data.charAt(i) == 'I') {
				number += 1;
			}
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
