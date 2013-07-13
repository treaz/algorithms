package ro.horia.dynaProgging;

public class OptimalBST {

	public static double[][] calc(double[] probNodes, double[] probLeafs,
			int length) {
		double[][] e = new double[length + 1][length];
		double[][] w = new double[length + 1][length];
		int[][] root = new int[length][length];
		// populating the initial matrix
		for (int i = 0; i < length; i++) {
			e[i + 1][i] = probLeafs[i];
			w[i + 1][i] = probLeafs[i];
		}
		for (int l = 1; l <= length; l++) {
			for (int i = 1; i < length - l + 1; i++) {
				int j = i + l - 1;
				e[i][j] = Integer.MAX_VALUE;
				// w[i][j] is previous value from row + the cumulated
				// probability of leaf+nodes
				w[i][j] = w[i][j - 1] + probNodes[j] + probLeafs[j];
				for (int rs = i; rs <= j; rs++) {
					double t = e[i][rs - 1] + e[rs + 1][j] + w[i][j];
					if (t < e[i][j]) {
						e[i][j] = t;
						root[i][j] = rs;
					}
				}
			}
		}
		constructOptimalBST(root);
		return e;
	}

	public static void constructOptimalBST(int[][] root) {
		int n = root.length;
		System.out.println(root[1][n-1] + " is root");
		PRINTOBST(root, 1, n-1);
	}

	private static void PRINTOBST(int[][] root, int i, int j) {

		int m = root[i][j];
		if (i == m) {
			System.out.println((m - 1) + " left child of K" + m);
		} else {
			System.out.println(root[i][m - 1] + " left child of K" + m);
			PRINTOBST(root, i, m - 1);
		}

		if (j == m) {
			System.out.println((m) + " right child of K" + m);
		} else {
			System.out.println(root[m + 1][j] + " right child of K" + m);
			PRINTOBST(root, m + 1, j);
		}
	}

	public static void main(String[] args) {
		double[] probNodes = { 0, 0.15, 0.10, 0.05, 0.10, 0.20 };
		double[] probLeafs = { 0.05, 0.10, 0.05, 0.05, 0.05, 0.10 };
		double[][] res = calc(probNodes, probLeafs, probNodes.length);
		System.out.println(res[1][res.length - 2]);
	}
}
