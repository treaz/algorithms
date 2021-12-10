package com.horiaconstantin.sorting.bycompare;

import java.util.Objects;

public class SelectionSort implements Sort {

	public int[] sort(int[] input) {
		Objects.requireNonNull(input);
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
