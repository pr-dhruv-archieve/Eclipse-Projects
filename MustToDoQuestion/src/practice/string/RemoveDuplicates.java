package practice.string;

import java.util.Scanner;

public class RemoveDuplicates {

	public static String uniq(String data) {
		String str = "";

		for (int i = 0; i < data.length(); i++) {
			char ch = data.charAt(i);
			if (str.indexOf(ch) == -1)
				str += ch+"";
		}

		return str;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		String[] data = new String[n];

		sc.nextLine();
		for (int i = 0; i < n; i++)
			data[i] = sc.nextLine();

		for (int i = 0; i < n; i++)
			System.out.println(uniq(data[i]));

	}

}
