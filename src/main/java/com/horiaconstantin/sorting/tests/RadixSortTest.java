package com.horiaconstantin.sorting.tests;

import com.horiaconstantin.sorting.RadixSort;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class RadixSortTest {

	@Test
	public void test() {
		int[] input = { 329, 457, 657, 839, 436, 720, 355 };
		int[] result = { 329, 355, 436, 457, 657, 720, 839 };
		assertTrue(Arrays.equals(new RadixSort().sort(input,3), result));
	}

}
