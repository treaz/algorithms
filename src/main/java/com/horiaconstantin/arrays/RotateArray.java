package com.horiaconstantin.arrays;

/**
 * Given an array of integers, rotate the array by NNN elements where NNN is an integer:
 * <p>
 * For positive values of NNN, perform a right rotation.
 * For negative values of NNN, perform a left rotation.
 * <p>
 * Make sure you make changes to the original array.
 */
public class RotateArray {

	void rotateArray(int[] arr, int N) {
		int[] rotated = rotate(arr, N);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rotated[i];
		}
	}

	public static int[] rotate(int[] arr, int times) {
		times = times % arr.length;
		if (times < 0) {
			times = arr.length + times;
		}

		int[] rotated = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int newIndex = (i + times) % arr.length;
			rotated[newIndex] = arr[i];
		}
		return rotated;
	}
}
