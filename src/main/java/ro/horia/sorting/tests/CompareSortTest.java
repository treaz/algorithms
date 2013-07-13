package ro.horia.sorting.tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import ro.horia.sorting.CountSort;
import ro.horia.sorting.bycompare.HeapSort;

public class CompareSortTest {

	@Test
	public void test() {
		int[] input = { 2, 5, 3, 0, 2, 3, 0, 3 };
		int maxVal = 5;
		int[] result = { 0, 0, 2, 2, 3, 3, 3, 5 };
		assertTrue(Arrays.equals(new CountSort().sort(input, maxVal), result));
	}

}
