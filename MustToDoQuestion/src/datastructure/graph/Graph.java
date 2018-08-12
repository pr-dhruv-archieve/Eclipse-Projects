package datastructure.graph;

import java.util.Arrays;
import java.util.Scanner;

public class Graph {

	private Scanner sc;
	
	private int vertices; // No of the vertices.
	private static int[][] adjlist; // list for the adjacent vertices

	public Graph(int vertices) {
		sc = new Scanner(System.in);
		
		this.vertices = vertices;
		adjlist = new int[vertices][vertices];
		getPosition();
	}
	
	private void getPosition() {
		int edges = sc.nextInt();
		String pos;
		for (int i = 0; i < edges; i++) {
			pos = sc.next();
			String[] temp = pos.split(",");
			int x = Integer.parseInt(temp[0]);
			int y = Integer.parseInt(temp[1]);
			adjlist[x][y] = 1;
		}
		for (int[] temp : adjlist) {
			System.out.println(Arrays.toString(temp));
		}
	}

	public int[][] getAdjacencyMatrix() {
		return adjlist;
	}
	
}
