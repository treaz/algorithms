package com.horia.array;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MaxContiguousSequenceTest {
	@Test
	public void test() {
		int[] array = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22,
				15, -4, 7 };
		assertTrue(43 == MaxContiguousSequence.maxSumRec(array, 0, array.length - 1));
	}
}