package MemoryManagement.allocation;

import java.util.Scanner;

public class MVF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int i, p = 0;		
		int totalInternalFragmentation = 0;
		
		System.out.print("Total size available in memory (in bytes): ");
		int memoryAvailable = sc.nextInt();
		
		System.out.print("Block size (in bytes): ");
		int blockSize = sc.nextInt();
		
		int numberOfBlock = memoryAvailable / blockSize;
		int totalExternalFragmentation = memoryAvailable - numberOfBlock * blockSize;
		
		System.out.print("No of processes : ");
		int noProcess = sc.nextInt();
		
		int[] processMemory = new int[noProcess];
		System.out.print("Memory required for each process : ");
		for (i = 0; i < noProcess; i++)
			processMemory[i] = sc.nextInt();
		System.out.print("No of blocks available into memory : " + numberOfBlock);
		
		
		System.out.println();
		System.out.println("Process\t\tReq. Mem.\tAllocated\tInternal Fagmentation");
		
		for (i = 0; i < noProcess && p < numberOfBlock; i++ ) {
			System.out.print("\n"+(i+1)+"\t\t"+processMemory[i]+"\t\t");
			if (processMemory[i] > blockSize) {
				System.out.print("NO\t\t----");
			}
			else {
				int allocated = blockSize - processMemory[i];
				System.out.print("YES\t\t"+allocated);
				totalInternalFragmentation += allocated;
				p++;
			}
		}
		
		if(i < noProcess) {
			System.out.println("\nmemory full rest of the process cannot accomodate");
		}
		System.out.println("Total internal fragmentation : " + totalInternalFragmentation);
		System.out.println("Total external fragmentation : " + totalExternalFragmentation);
		
	}

}
