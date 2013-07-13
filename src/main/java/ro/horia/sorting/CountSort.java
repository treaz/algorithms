package ro.horia.sorting;


public class CountSort {

	/**
	 * creates a new array and places the input values in the new array in the position corresponding to their value.
	 * @author Horia Constantin
	 * @param a
	 * @param largestValue
	 * @return
	 */
	public int[] sort(int[] a, int largestValue) {
		int[] result = new int[a.length];
		int[] c = new int[largestValue + 1];
		for (int i : a) {
			c[i]++;
		}
		for (int i = 1; i <= largestValue; i++) {
			c[i] = c[i] + c[i - 1];
		}

		for (int j = a.length - 1; j >= 0; j--) {
			result[c[a[j]] - 1] = a[j];
			c[a[j]] = c[a[j]] - 1;
		}

		return result;
	}

	public int[] sort(int[] fullArray, int[] a, int largestValue) {
		int[] result = new int[a.length];
		int[] c = new int[largestValue + 1];
		for (int i : a) {
			c[i]++;
		}
		for (int i = 1; i <= largestValue; i++) {
			c[i] = c[i] + c[i - 1];
		}

		// with increasing traversal of the array the sort is inversely stable
		// for (int j = 0; j <a.length ; j++) {
		
		// by iterating from the end to the beginning the sort is stable
		// numbers with the samevalue appear in the output array in the same
		// order as they do in the input array
		for (int j = a.length - 1; j >= 0; j--) {
			result[c[a[j]] - 1] = fullArray[j];
			c[a[j]] = c[a[j]] - 1;
		}

		return result;
	}
}
