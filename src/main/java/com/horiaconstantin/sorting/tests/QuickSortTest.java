package com.horiaconstantin.sorting.tests;

import com.horiaconstantin.sorting.bycompare.QuickSort;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

	QuickSort qs = new QuickSort();
	int[] result = { 1, 2, 3, 4, 7, 8, 9, 10, 14, 16 };
	
	@Test
	public void testSimple() {
		int[] input = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
		
		assertArrayEquals(qs.sort(input),result);
	}
	
	@Test
	public void testRandomized() {
		int[] input = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
		assertArrayEquals(qs.randomizedSort(input),result);
	}

}
