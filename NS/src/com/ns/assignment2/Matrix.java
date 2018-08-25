package com.ns.assignment2;

public class Matrix {
	private int nrows; 
	private int ncols; 
	private double[][] data; 
	
	public Matrix(double[][] data) { 
		this.data = data; 
		this.nrows = data.length; 
		this.ncols = data[0].length; 
	} 
	
	public Matrix(int nrow, int ncol) { 
		this.nrows = nrow; 
		this.ncols = ncol; 
		data = new double[nrow][ncol]; 
	}
	
	public int getNcols() {
		return ncols;
	}
	
	public int getNrows() {
		return nrows;
	}
	
	public double getValueAt(int i, int j) {
		return this.data[i][j];
	}
	
	public void setValueAt(int i, int j, double d) {
		this.data[i][j] = (int) d;
	}
	
	public boolean isSquare() {
		if (this.ncols == this.nrows)
			return true;
		else
			return false;
	}
	public int size() {
		return this.ncols;
	}
	public static Matrix transpose(Matrix matrix) { 
		Matrix transposedMatrix = new Matrix(matrix.getNcols(), matrix.getNrows()); 
		for (int i=0;i<matrix.getNrows();i++) { 
			for (int j=0;j<matrix.getNcols();j++) { 
				transposedMatrix.setValueAt(j, i, matrix.getValueAt(i, j)); 
			} 
		} 
		return transposedMatrix; 
	}

	public static double determinant(Matrix matrix) throws NoSquareException { 
		if (!matrix.isSquare()) 
			throw new NoSquareException("matrix need to be square."); 
		if (matrix.size()==2) { 
			return (matrix.getValueAt(0, 0) * matrix.getValueAt(1, 1)) - ( matrix.getValueAt(0, 1) * matrix.getValueAt(1, 0)); 
		} 
		int sum = 0; 
		for (int i=0; i<matrix.getNcols(); i++) { 
			sum += changeSign(i) * matrix.getValueAt(0, i) * determinant(createSubMatrix(matrix, 0, i)); 
		} 
		return sum; 
	}
	
	private static int changeSign(int i) {
		return -1*i;
	}

	public static Matrix createSubMatrix(Matrix matrix, int excluding_row, int excluding_col) {
		Matrix mat = new Matrix(matrix.getNrows()-1, matrix.getNcols()-1); int r = -1; 
		for (int i=0;i<matrix.getNrows();i++) { 
			if (i==excluding_row) 
				continue; 
			r++; 
			int c = -1; 
			for (int j=0;j<matrix.getNcols();j++) { 
				if (j==excluding_col) 
					continue; 
				mat.setValueAt(r, ++c, matrix.getValueAt(i, j)); 
			} 
		} 
		return mat; 
	}

	public static Matrix cofactor(Matrix matrix) throws NoSquareException { 
		Matrix mat = new Matrix(matrix.getNrows(), matrix.getNcols()); 
		for (int i=0;i<matrix.getNrows();i++) { 
			for (int j=0; j<matrix.getNcols();j++) { 
				mat.setValueAt(i, j, sign(i) * changeSign(j) * determinant(createSubMatrix(matrix, i, j))); 
			} 
		} 
		return mat; 
	}

	private static int sign(int i) {
		// TODO Auto-generated method stub
		if(i < 0)
			return -1;
		else
			return 1;
	}

	public static Matrix inverse(Matrix matrix) throws NoSquareException { 
		return (transpose(cofactor(matrix)).multiplyByConstant(1/determinant(matrix))); 
	}

	private Matrix multiplyByConstant(double d) {
		for (int i = 0; i < this.nrows; i++) {
			for (int j =0 ; j < this.ncols; j++) {
				this.data[i][j] *= d;
			}
		}
		return this;
	}
	
	public static Matrix multiply(Matrix m1, Matrix m2) {
		Matrix m3 = new Matrix(m1.nrows, m2.ncols);
		
		for (int i =0 ; i  <m1.nrows;i++) {
			for (int j =0  ;j  < m2.ncols; j++) {
				int sum = 0;
				for (int k = 0 ; k < m1.nrows; k++)
					sum += m1.data[i][k] * m2.data[k][j];
				m3.data[i][j] = sum % 26;
			}
		}
		return m3;
	}
	
	public String toString() {
		String s = "";
		for (int i =0 ; i < this.nrows; i++) {
			for (int j = 0; j < this.ncols; j++) {
				s += this.data[i][j] + " ";
			}
			s += '\n';
		}
		return s;
	}
	
	public String getMessage() {
		String s = "";
		for (int i =0 ; i < this.nrows; i++) {
			for (int j = 0; j < this.ncols; j++) {
				s += (char) (this.data[i][j]+97);
			}
		}
		return s;
	}
	
	public void printMatrix() {
		
		for (int i =0 ; i < this.nrows; i++) {
			for (int j = 0; j < this.ncols; j++) 
				System.out.print(this.data[i][j]+" ");
			System.out.println();
		}
	}
}
