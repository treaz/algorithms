package ro.horia.sorting.tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import ro.horia.sorting.RadixSort;
import ro.horia.sorting.bycompare.HeapSort;

public class RadixSortTest {

	@Test
	public void test() {
		int[] input = { 329, 457, 657, 839, 436, 720, 355 };
		int[] result = { 329, 355, 436, 457, 657, 720, 839 };
		assertTrue(Arrays.equals(new RadixSort().sort(input,3), result));
	}

}
