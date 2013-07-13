package ro.horia.sorting;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class BucketSortTest {

	@Test
	public void test() {
		double[] input = { .78, .17, .39, .72, .94, .21, .12, .23, .68 };
		double[] result = { .12, .17, .21, .23, .39, .68, .72, .78, .94 };
		assertTrue(Arrays.equals(
				new BucketSort().sort(1, input.length - 1, input), result));
	}

}
