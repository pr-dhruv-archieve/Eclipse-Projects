package com.ns.assignment2;

import java.util.Arrays;
import java.util.Scanner;

public class HillCipher {

	public static Scanner sc = new Scanner(System.in);
	public static int[][] inverseMatrix = null;
	public static int dim = 0;

	public static int[][] readData(String text) {

		int n = text.length();
		int size = 0;

		while (size * size <= n) {
			size++;
		}
		System.out.println(text.length() + "->" + size);
		int[][] matrix = new int[size][size];
		int index = 0;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (index < text.length()) {
					int ch = (int) text.charAt(index);
					if (ch == 32) {
						j--;
						index++;
						continue;
					}
					matrix[i][j] = ch - 97;
					index++;
				} else
					matrix[i][j] = 25;
			}
		}

		for (int i = 0; i < size; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		return matrix;
	}

	private static int determinant(int[][] key, int size) {
		int det = 0;
		int[][] m_minor = new int[key.length][key.length];
		if (key.length == 1 && key[0].length == 1)
			return key[0][0];
		else {

			int i, j, m, n, c;
			int s = 1;
			for (c = 0; c < size; c++) {
				m = 0;
				n = 0;
				for (i = 0; i < size; i++) {
					for (j = 0; j < size; j++) {
						m_minor[i][j] = 0;
						if (i != 0 && j != c) {
							m_minor[m][n] = key[i][j];
							if (n < size - 2)
								n++;
							else {
								n = 0;
								m++;
							}
						}
					}
				}
				det += s * (key[0][c] * determinant(m_minor, size - 1));
				s = (-1 * s);
			}
		}
		return det;
	}

	public static void cofactor(int[][] matrix, int size) {
		int[][] m_cofactor = new int[size][size];
		int[][] matrix_cofactor = new int[size][size];
		int p, q, m, n, i, j;

		for (q = 0; q < size; q++) {
			for (p = 0; p < size; p++) {
				m = 0;
				n = 0;
				for (i = 0; i < size; i++) {
					for (j = 0; j < size; j++) {
						if (i != q && j != p) {
							m_cofactor[m][n] = matrix[i][j];
							if (n < (size - 2))
								n++;
							else {
								n = 0;
								m++;
							}
						}
					}
				}
				matrix_cofactor[q][p] = (int) (Math.pow(-1, q + p) * determinant(m_cofactor, size - 1));
			}
		}
		transpose(matrix, matrix_cofactor, size);
	}

	public static void transpose(int[][] matrix, int[][] martix_cofactor, int size) {
		int i,j;
	    int[][] m_transpose = new int[size][size];
	    int d;
	 
	    for (i=0;i<size;i++) {
	         for (j=0;j<size;j++) {
	             m_transpose[i][j]=martix_cofactor[j][i];
	         }
	    }
	    d=determinant(matrix,size);
	    for (i=0;i<size;i++) {
	         for (j=0;j<size;j++) {
	             inverseMatrix[i][j]=m_transpose[i][j] / d;
	         }
	    }
	}

	private static boolean check(int[][] key) {
		dim = key.length;
		inverseMatrix = new int[dim][dim];
		int d = determinant(key, key.length);
		if (d == 0)
			return false;
		else {
			cofactor(key, dim);
			return true;
		}
	}

	public static int[][] generateKey(int size) {
		int[][] key = new int[size][size];
		System.out.println("Enter " + (size * size) + " element of the key : ");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++)
				key[i][j] = sc.nextInt();
		}
		if (check(key))
			return key;
		else
			return null;
	}

	public static int[][] encrypt(int[][] data, int[][] key) {
		int n = data.length;
		int[][] matrix = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int sum = 0;
				for (int k = 0; k < n; k++)
					sum += data[i][k] * key[k][j];
				matrix[i][j] = sum % 26;
			}
		}
		return matrix;
	}

	public static String hillCipherEncrypt(String plainText) {
		int[][] data = readData(plainText);
		int[][] key = generateKey(data.length);
		int[][] encrypted = encrypt(data, key);

		String encryptedData = "";
		for (int i = 0; i < encrypted.length; i++) {
			for (int j = 0; j < encrypted[i].length; j++)
				encryptedData += (char) (encrypted[i][j] + 97);
		}
		return encryptedData;
	}

	public static void main(String[] args) {

		// Encryption
		String plainText = sc.nextLine();
		String cipherText = hillCipherEncrypt(plainText);
		System.out.println(cipherText);

		// Decrytpion

		sc.close();
	}

}
