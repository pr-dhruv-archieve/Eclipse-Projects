import java.util.Arrays;
import java.util.Scanner;

public class Matrix {

	private static int size;
	private static boolean enc = true;
	
	private static double determinant(double[][] matrix) {
		if (matrix.length != matrix[0].length)
			throw new IllegalStateException("invalid dimensions");

		if (matrix.length == 2)
			return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

		double det = 0.0;
		for (int i = 0; i < matrix[0].length; i++)
			det += Math.pow(-1, i) * matrix[0][i] * determinant(minor(matrix, 0, i));
		return det;
	}

	private static double[][] inverse(double[][] matrix) {
		double[][] inverse = new double[matrix.length][matrix.length];

		// minors and cofactors
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[i].length; j++)
				inverse[i][j] = Math.pow(-1, i + j) * determinant(minor(matrix, i, j));

		// adjugate and determinant
		double det = determinant(matrix);
		for (int i = 0; i < inverse.length; i++) {
			for (int j = 0; j <= i; j++) {
				double temp = inverse[i][j];
				inverse[i][j] = inverse[j][i] / det;
				inverse[j][i] = temp / det;
			}
		}

		return inverse;
	}

	private static double[][] minor(double[][] matrix, int row, int column) {
		double[][] minor = new double[matrix.length - 1][matrix.length - 1];

		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; i != row && j < matrix[i].length; j++)
				if (j != column)
					minor[i < row ? i : i - 1][j < column ? j : j - 1] = matrix[i][j];
		return minor;
	}

	public static double[][] getMatrix(String plainText) {
		char[] data = plainText.toLowerCase().toCharArray();

		while (size * size <= data.length) {
			size++;
		}

		int index = 0;
		double[][] matrix = new double[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (index < data.length) {
					if (data[index] == ' ') {
						j--;
						index++;
						continue;
					} else {
						matrix[i][j] = (int) data[index] - 97;
						index++;
					}
				} else
					matrix[i][j] = 25;
			}
		}
		return matrix;
	}

	private static double[][] multiply(double[][] a, double[][] b) {
		if (a[0].length != b.length)
			throw new IllegalStateException("invalid dimensions");

		double[][] matrix = new double[a.length][b[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				double sum = 0;
				for (int k = 0; k < a[i].length; k++)
					sum += a[i][k] * b[k][j];
				matrix[i][j] = sum;
			}
		}

		return matrix;
	}

	public static double[][] encrypt(double[][] data, double[][] key) {
		if (determinant(key) == 0) {
			System.out.println("invalid key");
			System.exit(1);
		}
		double[][] result = Matrix.multiply(data, key);

		for (int i = 0; i < result.length; i++)
			for (int j = 0; j < result[0].length; j++)
				result[i][j] = result[i][j] % 26;

		return result;

	}

	public static double[][] decrypt(double[][] data, double[][] key) {
		double[][] inv = Matrix.inverse(key);
		//double[][] inv = {{2,15,22,3},{15,0,19,3},{9,9,3,11},{17,0,4,7}};
		double[][] result = Matrix.multiply(data, inv);
		for (int i = 0; i < result.length; i++)
			for (int j = 0; j < result[0].length; j++)
				result[i][j] = (result[i][j] % 26.0) + 97;
		return result;
	}
	
	private static String getMessage(double[][] matrix) {
		String s = "";
		for (int i =0 ; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				int temp = (int)matrix[i][j];
				char ch;
				if (enc)
					ch = (char)(temp + 97);
				else
					ch = (char)temp;
				s+= ch;
			}
				
		}
		return s;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String plainText = sc.nextLine();
		double[][] plain = Matrix.getMatrix(plainText);

		System.out.println("Enter the key : ");
		double[][] key = new double[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++)
				key[i][j] = sc.nextDouble();
		}

		double[][] encryptedData = encrypt(plain, key);
		System.out.println("\n\n Encrypted data : " + getMessage(encryptedData));
		for(double[] i : encryptedData)
			System.out.println(Arrays.toString(i));
		
		enc = false;
		double[][] decrypted = decrypt(encryptedData, key);
		System.out.println("\n\n Decrypted Data : " + getMessage(decrypted));
		for(double[] i : decrypted)
			System.out.println(Arrays.toString(i));
		
		sc.close();
	}

}
