package ro.horia.sorting.tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import ro.horia.sorting.bycompare.HeapSort;

public class HeapSortTest {

	@Test
	public void test() {
		int[] input = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
		int[] result = { 1, 2, 3, 4, 7, 8, 9, 10, 14, 16 };
		assertTrue(Arrays.equals(new HeapSort().sort(input),result));
	}

}
