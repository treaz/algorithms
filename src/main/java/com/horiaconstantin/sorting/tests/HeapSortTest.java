package com.horiaconstantin.sorting.tests;

import com.horiaconstantin.sorting.bycompare.HeapSort;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class HeapSortTest {

	@Test
	public void test() {
		int[] input = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
		int[] result = { 1, 2, 3, 4, 7, 8, 9, 10, 14, 16 };
		assertTrue(Arrays.equals(new HeapSort().sort(input),result));
	}

}
