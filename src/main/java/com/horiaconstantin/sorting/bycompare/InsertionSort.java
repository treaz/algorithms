package com.horiaconstantin.sorting.bycompare;

public class InsertionSort {

	/**
	 * 
	 * @author Horia Constantin
	 * @param input should not be null
	 * @return
	 */
	public static int[] insertionSortIncreasing(int[] input) {
		for (int j=1; j<input.length;j++) {
			int tmp = input[j];
			int i = j-1;
			while (i>=0 && input[i]>tmp) {
				input[i+1]=input[i];
				i--;
			}
			input[i+1]=tmp;
		}
		
		return input;
	}
	
	/**
	 * 
	 * @author Horia Constantin
	 * @param input should not be null
	 * @return
	 */
	public static double[] insertionSortIncreasing(double[] input) {
		for (int j=1; j<input.length;j++) {
			double tmp = input[j];
			int i = j-1;
			while (i>=0 && input[i]>tmp) {
				input[i+1]=input[i];
				i--;
			}
			input[i+1]=tmp;
		}
		
		return input;
	}
	
	public static int[] insertionSortDecreasing(int[] input) {
		for (int j=input.length-2; j>=0;j--) {
			int key = input[j];
			int i=j+1;
			while (i<input.length && input[i]>key) {
				input[i-1]=input[i];
				i++;
			}
			input[i-1]=key;
		}
		return input;
	}
}
