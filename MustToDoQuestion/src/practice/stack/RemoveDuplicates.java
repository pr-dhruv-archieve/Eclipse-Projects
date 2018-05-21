package practice.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RemoveDuplicates {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		sc.useDelimiter("\\n");
		String[] s = new String[n];
		for (int i = 0; i < n && sc.hasNext(); i++)
			s[i] = sc.nextLine();
		
		for (int i = 0; i < n; i++) {
			String temp = "";
			for (int j = 0 ; j < s[i].length(); j++) {
				if(temp.indexOf(s[i].charAt(j)) < 0)
					temp += s[i].charAt(j) + "";
			}
			System.out.println(temp);
		}
		
	}

}
