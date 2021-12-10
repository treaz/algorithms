package com.horiaconstantin.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MoveZerosTest {

	@Test
	void moveZerosToLeft() {
		int[] v = new int[]{1, 10, 20, 0, 59, 63, 0, 88, 0};
		int[] expected = new int[]{0, 0, 0, 1, 10, 20, 59, 63, 88};

		MoveZeros.moveZerosToLeft(v);

		assertArrayEquals(expected, v);
	}

	@Test
	void oneElementArray() {
		int[] v = new int[]{0};
		int[] expected = new int[]{0};

		MoveZeros.moveZerosToLeft(v);

		assertArrayEquals(expected, v);
	}
}