package practice.string;

import java.util.Scanner;

public class CommonPrefix {

	public static String prefix(String data[]) {
		
		if(data.length == 1)
			return data[0];
		
		String prefix = "-1";
		String temp = "";
		int flag = 0;
		for (int i = 1; i <= data[0].length(); i++) {
			temp = data[0].substring(0, i);
			for (int j = 1; j < data.length; j++){
				if(data[j].indexOf(temp) == 0)
					flag = 1;
				else
					return prefix;
			}
			if(flag == 1)
				prefix = temp;
		}
		return prefix;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		
		String[][] data = new String[t][];
		
		for (int i = 0; i < t; i++){
			int n = sc.nextInt();
			data[i] = new String[n]; 
			for (int j = 0; j < n ; j++)
				data[i][j] = sc.next();
		}

		for (int i = 0; i < t; i++)
			System.out.println(prefix(data[i]));

	}

}
