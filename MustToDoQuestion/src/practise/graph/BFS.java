package practise.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import datastructure.graph.Graph;

public class BFS {

	public static void bfs(int[][] adj, int current) {
		
		//for the vertices wheather its been visited or not
		boolean[] visited = new boolean[adj.length];
	
		Queue<Integer> q = new LinkedList<Integer>();
		
		//Initial visit the starting node
		visited[current] = true;
		q.offer(current);
		
		while (!q.isEmpty()) {
			
			current = q.poll();
			System.out.println(current + " ");
			
			int[] temp = adj[current];
			
			for (int i = 0; i < temp.length; i++) {
				if (!visited[i] && temp[i] != 0) {
					visited[i] = true;
					q.offer(i);
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph g = new Graph(4);
		System.out.print("Starting vertex from 0 to 3 : ");
		bfs(g.getAdjacencyMatrix(), new Scanner(System.in).nextInt());
		
	}

}
