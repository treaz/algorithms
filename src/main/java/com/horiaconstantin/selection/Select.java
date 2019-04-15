package com.horiaconstantin.selection;

import java.util.Collections;
import java.util.HashMap;


/**
 * Selection in worst-case linear time page 241
 * 
 * 
 * @author Horia Constantin
 * 
 */
public class Select {
//	public int select(int[] a, int selectElem) {
//		List<int[]> subarrays = new ArrayList<>();
//		for (int i = 0; i < a.length / 5; i++) {
//			subarrays.add(Arrays.copyOfRange(a, i, i + 1));
//		}
//		int[] medianArray = new int[subarrays.size()];
//		for (int i = 0; i < subarrays.size(); i++) {
//			int[] boo = InsertionSort.insertionSortIncreasing(subarrays
//					.get(i));
//			medianArray[i] = boo[2];
//		}
//		int median = select(medianArray);
//		int k = partition(a, 0, a.length-1,median);
//
//		return i;
//	}
	
	private int partition(int[] a, int p, int r, int x) {
		Collections.synchronizedMap(new HashMap<>());
		int i = p - 1;
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
