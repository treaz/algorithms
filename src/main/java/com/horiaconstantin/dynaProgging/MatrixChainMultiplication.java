package com.horiaconstantin.dynaProgging;

public class MatrixChainMultiplication {

	static int[][] s;
	static int dim;
	/**
	 * you will have a matrix with the number of multiplications (i rows, j
	 * columns)
	 */
	public static int[][] computeMinimumOps(int[] dimension) {
		dim = dimension.length - 1;
		s = new int[dim][dim];
		int[][] m = new int[dim][dim];
		
		//the matrix m has 0 on thhe main diagonal and we only fiill the upper part
		//is filled like this: starting from (0,1), (1,2), (2,3)...
		//then we go on to (0,2),(1,3)...
		//and so on.
		//m[0][m.length-1] contains the result we want.
		for (int l = 2; l < dim + 1; l++) {
			for (int i = 0; i < dim - l + 1; i++) {
				int j = i + l - 1;
				m[i][j] = Integer.MAX_VALUE;
				// this is the k that splits the matrix chain into 2 pieces
				for (int k = i; k < j; k++) {
					// we want to see which of the pieces has the smallest sum
					int val = m[i][k] + m[k + 1][j] + dimension[i]
							* dimension[k + 1] * dimension[j + 1];
					if (m[i][j] > val) {
						m[i][j] = val;
						s[i][j] = k;
					}
				}
			}
		}
		return m;
	}
	
	public static void printOptimalParanthesis(int i, int j) {
		if (i==j) {
			System.out.print("A"+(i+1));
		} else {
			System.out.print("(");
			printOptimalParanthesis(i, s[i][j]);
			printOptimalParanthesis(s[i][j]+1,j);
			System.out.print(")");
			
		}
		
	}

	public static void main(String[] args) {
		int[] dims = { 4, 10, 3, 12, 20, 7 };
		int[][] res = computeMinimumOps(dims);
		System.out.println(res[0][res.length - 1]);
		printOptimalParanthesis(0,res.length - 1);
	}
}
