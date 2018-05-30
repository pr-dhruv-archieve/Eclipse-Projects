package practice.string;

import java.util.Scanner;

public class ParenthesisChecker1 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		String[] data = new String[n];
		char[] stack = new char[20 ];
		
		
		for(int i = 0; i < n; i++)
			data[i] = sc.next();
		
		for(int i = 0; i < n; i++) {
			int top = -1;
			int flag = 0;
			if(data[i].length() % 2 == 1){
				System.out.println("not balanced");
				continue;
			}
			for(int j = 0; j < data[i].length(); j++) {
				if(data[i].charAt(j) == '(' || data[i].charAt(j) == '{' || data[i].charAt(j) == '[' )
		            stack[++top] = data[i].charAt(j);
		        else if(data[i].charAt(j) == ')' && stack[top] == '(' )
		            top--;
		        else if(data[i].charAt(j) == '}' && stack[top] == '{' )
		            top--;
		        else if(data[i].charAt(j) == ']' && stack[top] == '[' )
		            top--;
		        else
		            break;
			}
			
			if(flag == 0)
				System.out.println("balanced");
			else
				System.out.println("not balanced");
		}

	}

}
