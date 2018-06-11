package practice.string;

import java.util.Scanner;

public class LongestDistinctCharacters {

	public static int count(String data) {
		int max = Integer.MIN_VALUE;
		
		String temp = "";

		int match;
		
		for (int i = 0; i < data.length(); i++) {
			char ch = data.charAt(i);
			match = temp.indexOf(ch);
			if (match == -1) {
				//Uniq
				temp += ch+"";
			}
			else {
				//Element Found
				int len = temp.length();
				if (max < len)
					max = len;
				temp = "";
				i = data.indexOf(ch);
			}
			
		}

		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		String[] data = new String[n];

		for (int i = 0; i < n; i++)
			data[i] = sc.next();

		long st = System.currentTimeMillis();
		for (int i = 0; i < n; i++)
			System.out.println(count(data[i]));
		long et = System.currentTimeMillis();
		System.out.printf("%.5f",(double)(et-st)/1000);

	}

}
