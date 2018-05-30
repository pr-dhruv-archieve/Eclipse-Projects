package practice.string;

import java.util.Scanner;

public class DistinctCharactersInString {

	public static void dcis(String data) {
		String temp = "";
		String ds = "";
		for (int i = 0; i < data.length() - 1; i++) {
			if (temp.indexOf(data.charAt(i)) < 0)
				temp += data.charAt(i) + "";
			else {
				if(ds.length() <= temp.length())
					ds = temp;
				temp = "";
				i--;
			}
		}
		System.out.println(ds.length());
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		String[] data = new String[n];

		for (int i = 0; i < n; i++)
			data[i] = sc.next();

		for (int i = 0; i < n; i++)
			dcis(data[i]);

	}

}
