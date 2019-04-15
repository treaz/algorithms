package com.horiaconstantin.sorting.bycompare;

public class SelectionSort {

	public static int[] selectionSortIncreasing(int[] input) {
		for (int j = 0; j < (input.length - 1); j++) {
			int minIndex = j;
			for (int i=j+1; i< input.length;i++) {
				if (input[minIndex]>input[i]) {
					minIndex=i;
				}
			}
			int tmp = input[j];
			input[j]=input[minIndex];
			input[minIndex] = tmp;
		}
		return input;
	}
}
