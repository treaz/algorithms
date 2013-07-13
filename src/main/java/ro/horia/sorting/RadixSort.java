package ro.horia.sorting;

public class RadixSort {

	/**
	 * assumes that each elem in the array has d digits
	 * 
	 * RADIX-SORT.A; d/ for i = 0 to d use a stable sort to sort array A on
	 * digit i
	 * 
	 * @author Horia Constantin
	 * @param a
	 */
	public int[] sort(int[] a, int d) {
		for (int i = 0; i < d; i++) {
			int[] decimals = new int[a.length];
			for (int j = 0; j < a.length; j++) {
				decimals[j] = (a[j] / (int) Math.pow(10, i)) % 10;
			}
			a = new CountSort().sort(a, decimals, 9);
		}
		return a;
	}
}
