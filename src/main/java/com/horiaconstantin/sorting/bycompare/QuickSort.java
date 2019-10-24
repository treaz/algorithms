package com.horiaconstantin.sorting.bycompare;

import java.util.Objects;
import java.util.Random;

/**
 * Pick the last elem from the array as pivot. Compare the elems of the array with the pivo. The smaller go to the left, the bigger go to the right. The pivot is put between.
 * After that call quick sort on the left ad right subarrays.
 * @author Horia Constantin
 *
 */
public class QuickSort implements Sort {

	
	public int[] sort(int[] a) {
		Objects.requireNonNull(a);
		quicksort(a, 0, a.length - 1);
		return a;
	}
	
	public int[] randomizedSort(int[] a) {
		quicksortRandomized(a, 0, a.length - 1);
		return a;
	}

	private void quicksort(int[] a, int p, int r) {
		if (p < r) {
			int q = partition(a, p, r);
			quicksort(a, p, q);
			quicksort(a, q + 1, r);
		}

	}
	
	private void quicksortRandomized(int[] a, int p, int r) {
		if (p < r) {
			int q = partitionRandomized(a, p, r);
			quicksort(a, p, q);
			quicksort(a, q + 1, r);
		}

	}

	private int partitionRandomized(int[] a, int p, int r) {
		int newPivotIndex = new Random().nextInt(r+1);
		int tmp = a[r];
		a[r] = a[newPivotIndex];
		a[newPivotIndex] = tmp;
		return partition(a,p,r);
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
