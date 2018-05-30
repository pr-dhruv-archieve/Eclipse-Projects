package practice.string;

import java.util.*;
import java.lang.*;
import java.io.*;
class ParenthesisChecker2 {
    public static void check(String data) {
    int i = 0;
    int top = -1;
    char[] stack = new char[30]; 
    
    for ( i = 0;i < data.length();i++) {
        char c = data.charAt(i);
        if (c == '(' || c == '{' || c == '[')
            stack[++top] = c;
        else if (c == ')') {
        	 if( top >= 0) {
        		 if (stack[top] == '(')
        			 top--;
        		 else {
        			 System.out.println("not balanced");
                     return ;
        		 }
        	 }
        	 else {
                 System.out.println("not balanced");
                 return ;
        	 }
        }
        else if (c == '}') {
       	 if( top >= 0) {
       		 if (stack[top] == '{')
       			 top--;
       		 else {
       			 System.out.println("not balanced");
                    return ;
       		 }
       	 }
       	 else {
                System.out.println("not balanced");
                return ;
       	 }
       }
        else if (c == ']') {
       	 if( top >= 0) {
       		 if (stack[top] == '[')
       			 top--;
       		 else {
       			 System.out.println("not balanced");
                    return ;
       		 }
       	 }
       	 else {
                System.out.println("not balanced");
                return ;
       	 }
       }
        else {
            System.out.println("not balanced");
            return ;
        }
    }
    if (top == -1)
        System.out.println("balanced");
    else
        System.out.println("not balanced");
    }
    
    public static void main(String arhv[]) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        String[] data = new String[n];
        
        for (int i = 0; i < n; i++)
            data[i] = sc.next();
        
        long stime = System.currentTimeMillis();
        for (int i = 0; i < n; i++)
            check(data[i]);
        long etime = System.currentTimeMillis();
        System.out.println((etime-stime)/1000);
        
    }
}