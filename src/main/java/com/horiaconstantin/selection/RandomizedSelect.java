package com.horiaconstantin.selection;

/**
 * The problem of order statistics can be described as following. Given a set of
 * N elements, find k-th smallest element in it. For example, the minimum of a
 * set is the first order statistic (k = 1) and the maximum is the N-th order
 * statistic (k = N).
 * 
 * 
 * the array MUST have distinct elements the ith smallest element of an array is
 * the elem that has i-1 smaller elem that it.
 * 
 * @author Horia Constantin
 * 
 */
public class RandomizedSelect {

	public static void main(String[] args) {
		RandomizedSelect rs = new RandomizedSelect();
		int[] a = { 3, 9, 0, 7, 5, 4, 8, 6, 1 };
		System.out.println(rs.randomizedSelect(a, 0, a.length - 1, 3));
	}

	public int randomizedSelect(int[] a, int beginning, int end, int select) {
		if (beginning == end) {
			return a[beginning];
		}
		int pivotElement = partition(a, beginning, end);
		int positionOfPivot = pivotElement - beginning + 1;
		if (positionOfPivot == select) {
			return a[pivotElement];
		} else if (positionOfPivot > select) {
			return randomizedSelect(a, beginning, pivotElement - 1, select);
		} else {
			return randomizedSelect(a, pivotElement + 1, end, select
					- positionOfPivot);
		}
	}

	private int partition(int[] a, int p, int r) {
		int i = p - 1;
		int x = a[r];
		for (int j = p; j < r; j++) {
			if (a[j] < x) {
				i = i + 1;
				int tmp = a[j];
				a[j] = a[i];
				a[i] = tmp;
			}
		}
		int tmp = a[r];
		a[r] = a[i + 1];
		a[i + 1] = tmp;
		return i;
	}

}
