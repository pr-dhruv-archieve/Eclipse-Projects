package MemoryManagement.allocation;

import java.util.ArrayList;
import java.util.Scanner;

public class MVT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		char ch = 'y';
		int n = 0;
		
		System.out.print("Total Size available in memory(in bytes) : ");
		int totalMemory = sc.nextInt();
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		int temp = totalMemory;
		
		for (int i = 0; ch == 'y'; i++,n++) {
			al.add(sc.nextInt());
			if (al.get(i) <= temp) {
				System.out.println("Memory is allocated to the process " + (i+1));
				temp -= al.get(i);
			}
			else {
				System.out.println("Memory is full");
				break;
			}
			System.out.print("Do you want to continue  (Y/N) : ");
			ch = sc.next().charAt(0);
		}
		
		System.out.println("total Memory available : " + totalMemory);
		System.out.println("No.\tMem. req.");
		for (int i = 0; i < n; i++)
			System.out.println((i+1)+"\t"+al.get(i));
		System.out.println("Total Internal fragmenatation : " + (totalMemory - temp));
		System.out.println("Total external fragmenatation : " + (temp));
		
	}

}
