package com.horiaconstantin.searching;

import java.util.Arrays;

public class ArraySearch {

	/**
	 * 
	 * @author Horia Constantin
	 * @return -1 if the value is not found in the inputArray
	 */
	public static int linearSearch(int[] inputArray, int value) {
		Arrays.sort(inputArray);
		int index = -1;
		for (int i = 0; i < inputArray.length; i++) {
			if (value == inputArray[i]) {
				index = i;
				break;
			}
		}
		return index;
	}
}
