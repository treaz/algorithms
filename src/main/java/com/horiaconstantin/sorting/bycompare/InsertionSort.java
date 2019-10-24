package com.horiaconstantin.sorting.bycompare;

import java.util.Objects;

public class InsertionSort implements Sort {

	/**
	 * @param a should not be null
	 * @author Horia Constantin
	 */
	public int[] sort(int[] a) {
		Objects.requireNonNull(a);
		for (int j = 1; j < a.length; j++) {
			int tmp = a[j];
			int i = j - 1;
			while (i >= 0 && a[i] > tmp) {
				a[i + 1] = a[i];
				i--;
			}
			a[i + 1] = tmp;
		}
		return a;
	}

	public static int[] insertionSortDecreasing(int[] input) {
		for (int j = input.length - 2; j >= 0; j--) {
			int key = input[j];
			int i = j + 1;
			while (i < input.length && input[i] > key) {
				input[i - 1] = input[i];
				i++;
			}
			input[i - 1] = key;
		}
		return input;
	}
}
