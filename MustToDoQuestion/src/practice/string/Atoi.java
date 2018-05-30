package practice.string;

import java.util.Scanner;

public class Atoi {

	public static int atoi(String data) {
		if (data.indexOf('.') >= 0)
			return -1;
		else {
			for (int i = 65, j = 97; i <= 90 || j <= 122; i++, j++)
				if (data.indexOf(i) >= 0 || data.indexOf(j) >= 0)
					return -1;
			int number = 0;
			int k,f = 0;
			if (data.charAt(0) == '-') {
				k = 1;
				f = 1;
			}
			else
				k = 0;
			for ( ; k < data.length(); k++) 
				number = number * 10 + data.charAt(k) - 48;
			if(f == 1)
				return number * -1;
			else
				return number;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		String[] data = new String[n];

		for (int i = 0; i < n; i++)
			data[i] = sc.next();

		for (int i = 0; i < n; i++)
			System.out.println(atoi(data[i]));
	}

}
