package Outlier;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class BoxPlot {

	// No of the Attributes
	private int n;
	// Attributes values
	private LinkedList<LinkedList<Double>> attr;

	// Scanner for input
	private Scanner sc = null;

	public BoxPlot() {
		attr = new LinkedList<LinkedList<Double>>();
		new LinkedList<Double>();
	}

	public void input() {
		sc = new Scanner(System.in);

		System.out.print("Enter number of attributes : ");
		this.n = sc.nextInt();

		for (int i = 0; i < this.n; i++) {

			attr.add(new LinkedList<Double>());

			System.out.print("Attribute " + (i + 1) + " Enter the values (seperated by comma) : ");
			String data = sc.next();
			String[] value = data.split(",");

			for (int j = 0; j < value.length; j++)
				attr.get(i).add(Double.parseDouble(value[j]));

		}

	}

	public void summary() {
		for (int i = 0; i < this.n; i++) {
			System.out.println("Attribute "+(i+1)+" : "+attr.get(i));
			displayProperties(attr.get(i));
			System.out.println();
			System.out.println();
		}
	}
	
	private void displayProperties(LinkedList<Double> list) {
		Double min = Double.MAX_VALUE;
		Double max = Double.MIN_VALUE;
		Double mean = 0.0;
		Double q1 = 0.0;
		Double q2 = 0.0;
		Double q3 = 0.0;
		// For calculating the MIN MAX SUM for list
		@SuppressWarnings("unchecked")
		LinkedList<Double> temp = (LinkedList<Double>) list.clone();
		Collections.sort(temp);
		
		//Finding Min
		min = temp.get(0);
		
		//Finding max
		max = temp.get(temp.size() - 1);

		// Calculating the Q1, Q2, Q3, IQR, MEAN
		//Creating table with frequency and cumulative frequency 
		SortedSet<Double> set = new TreeSet<Double>(temp);
		double[][] item = new double[set.size()][3];
		int i = -1;
		for (Double it : set) {
			double d = it;
			item[++i][0] = d;
		}
		
		//Counting frequency
		for (i = 0; i < set.size(); i++) {
			double t = item[i][0];
			int count = 0;
			for (int j = 0; j < temp.size(); j++)
				if (temp.get(j) == t)
					count++;
			item[i][1] = count;
		}
		//Calculating Cumulative frequency
		item[0][2] = item[0][1];
		for (i = 1; i < item.length; i++) {
			item[i][2] = item[i - 1][2] + item[i][1];
		}
		
		//Finding the Quartiles
		double N = item[item.length - 1][2];
		q1 = (N + 1) / 4;
		q3 = 3 * q1;
		q2 = (N + 1) / 2;
		
		double quar1 = 0.0;
		double quar2 = 0.0;
		double quar3 = 0.0;
		
		for (i = 0; i < item.length; i++) {
			if(item[i][2] >= q1) {
				quar1 = item[i][0];
				break;
			}				
		}
		for (i = 0; i < item.length; i++) {
			if(item[i][2] >= q2) {
				quar2 = item[i][0];
				break;
			}				
		}
		for (i = 0; i < item.length; i++) {
			if(item[i][2] >= q3) {
				quar3 = item[i][0];
				break;
			}				
		}
		
		//Calculating Mean
		double sum = 0.0;
		for(i = 0 ; i < item.length; i++) {
			sum += item[i][0] * item[i][1];
		}
		mean = sum / N;
		
		// Calculating the Outlier
		double upper = quar2 + 1.5 * (quar3 - quar1);
		double lower = quar2 - 1.5 * (quar3 - quar1);
		
		LinkedList<Double> outliers = new LinkedList<Double>();
		for (i = 0 ;i  < temp.size(); i++)
			if(temp.get(i) > upper || temp.get(i) < lower)
				outliers.add(temp.get(i));
		
		System.out.println("Min : "+min);
		System.out.println("1st Quartile : "+quar1);
		System.out.println("Median : "+quar2);
		System.out.println("Mean : "+mean);
		System.out.println("3rd Quartile : "+quar3);
		System.out.println("Max : "+max);
		System.out.println("Upper Outlier : "+upper);
		System.out.println("Lower Outlier : "+lower);
		System.out.println("Outliers : " + outliers);

	}
	
	public void showAttributes() {

		for (int i = 0; i < this.n; i++) {
			System.out.print((i + 1) + " Attribute :\t");
			System.out.println(attr.get(i));
		}
	}
}
