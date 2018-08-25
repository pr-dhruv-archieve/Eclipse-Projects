package com.ns.assignment2;

import java.util.Scanner;

import javax.swing.plaf.metal.MetalIconFactory.PaletteCloseIcon;

public class HillCipherCode {

	public static Matrix getMatrix (String plainText) {
		char[] data = plainText.toLowerCase().toCharArray();
		int size = 0;
		while (size * size <= data.length) {
			size++;
		}
		
		int index = 0;
		double[][] matrix = new double[size][size];
		for (int i =0 ;i < size;i++) {
			for (int j =0 ; j < size;j++) {
				if (index < data.length) {
					if (data[index] == ' ') {
						j--;
						index++;
						continue;
					}
					else {
						matrix[i][j] = (int) data[index] - 97;
						index++;
					}
				}
				else
					matrix[i][j] = 25; 
			}
		}
		return new Matrix(matrix);
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String data = sc.nextLine();

		//Encryption
		Matrix plainText = getMatrix(data);
		System.out.println("Enter the "+plainText.getNcols()*plainText.getNrows()+" digit for the key : ");
		double[][] keyData = new double[plainText.getNrows()][plainText.getNcols()];
		for (int i = 0; i < keyData.length; i++) {
			for (int j = 0;j < keyData[i].length; j++) {
				keyData[i][j] = sc.nextInt();
			}
		}
		Matrix key = new Matrix(keyData);
		Matrix encrypted = null;
		if (Matrix.determinant(key) == 0) {
			System.out.println("Invalid key");
			System.exit(1);
		}
		else {
			encrypted = Matrix.multiply(plainText, key);
			System.out.println(encrypted.getMessage());
		}
		encrypted.printMatrix();
		Matrix.inverse(key).printMatrix();
		
		//Decryption
/*		Matrix inv = Matrix.inverse(key);
		Matrix returnedText = Matrix.multiply(encrypted, inv);
		System.out.println(returnedText);
		System.out.println(plainText.getMessage());
		*/
	}

}
