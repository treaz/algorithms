package com.horiaconstantin.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RotateArrayTest {

	@Test
	void rotateRight() {
		int[] actual = RotateArray.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);

		assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, actual);
	}

	@Test
	void rotateZero() {
		int[] actual = RotateArray.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 0);

		assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7}, actual);
	}

	@Test
	void rotateLeft() {
		int[] actual = RotateArray.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, -1);

		assertArrayEquals(new int[]{2, 3, 4, 5, 6, 7, 1}, actual);
	}

	@Test
	void rotateRightBig() {
		int[] actual = RotateArray.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 10);
		assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, actual);
	}
}