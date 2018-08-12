package practise.graph;

import java.util.Scanner;
import java.util.Stack;

import datastructure.graph.Graph;

public class DFS {

	/*
	 * Method 1
	 * Using iteration
	 */
	public static void dfsIterative(int[][] adj, int current) {
		
		boolean[] visited = new boolean[adj.length];
		
		Stack<Integer> s = new Stack<Integer>();
		s.push(current);
		visited[current] = true;
		
		while (!s.isEmpty()) {
			current = s.pop();
			System.out.print(current +  " ");
			
			int[] temp = adj[current];
			for (int i = temp.length - 1; i >= 0; i--) {
				if (temp[i] != 0 && !visited[i]) {
					visited[i] = true;
					s.push(i);
				}
			}
		}
		
	}
	
	/*
	 * Method 2
	 * using Recursion By default stack mechanism
	 */
	private static void dfsAux(int[][] adj, boolean[] visited, int current) {
		
		visited[current] = true;
		System.out.print(current + " ");
		
		int[] temp = adj[current];
		for (int i =0 ; i < temp.length; i++) {
			if (temp[i] != 0 && !visited[i]) {
				visited[i] = true;
				dfsAux(adj, visited, i);
			}
		}
		
	}
	
	
	public static void dfsRecursive(int[][] adj, int current) {
		
		boolean[] visited = new boolean[adj.length];
		
		dfsAux(adj, visited, current);
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		int[][] adj = new Graph(4).getAdjacencyMatrix(); 
		System.out.print("Starting vertex : ");
		int n = sc.nextInt();
		
		dfsRecursive(adj, n);
		dfsIterative(adj, n);
		
	}

}
