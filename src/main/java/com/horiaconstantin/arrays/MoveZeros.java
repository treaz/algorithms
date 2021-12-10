package com.horiaconstantin.arrays;

class MoveZeros {
	static void moveZerosToLeft(int[] A) {
		if (A == null || A.length == 0) {
			return;
		}
		int readIndex = A.length - 1;
		int writeIndex = A.length - 1;

		while (readIndex >= 0) {
			if (A[readIndex] != 0) {
				A[writeIndex] = A[readIndex];
				writeIndex--;
			}
			readIndex--;
		}

		while (writeIndex >= 0) {
			A[writeIndex] = 0;
			writeIndex--;
		}

	}
}
