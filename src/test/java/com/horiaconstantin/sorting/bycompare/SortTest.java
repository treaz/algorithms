package com.horiaconstantin.sorting.bycompare;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SortTest {

	private int[] unsorted = {4, 1, Integer.MAX_VALUE, 3, 2, 7, 16, Integer.MIN_VALUE, 9, -55, 10, 14, 8};
	private int[] sorted = {Integer.MIN_VALUE, -55, 1, 2, 3, 4, 7, 8, 9, 10, 14, 16, Integer.MAX_VALUE};

	@ParameterizedTest
	@ValueSource(classes = {HeapSort.class, InsertionSort.class, MergeSort.class, QuickSort.class, SelectionSort.class})
	void sortUnsorted(Class<Sort> clazz) throws Exception {
		Sort algo = clazz.getConstructor().newInstance();

		int[] result = algo.sort(unsorted);

		assertArrayEquals(sorted, result);
	}

	@ParameterizedTest
	@ValueSource(classes = {HeapSort.class, InsertionSort.class, MergeSort.class, QuickSort.class, SelectionSort.class})
	void sortSorted(Class<Sort> clazz) throws Exception {
		Sort algo = clazz.getConstructor().newInstance();

		int[] result = algo.sort(sorted);

		assertArrayEquals(sorted, result);
	}

	@ParameterizedTest
	@ValueSource(classes = {HeapSort.class, InsertionSort.class, MergeSort.class, QuickSort.class, SelectionSort.class})
	void sortEmpty(Class<Sort> clazz) throws Exception {
		Sort algo = clazz.getConstructor().newInstance();

		int[] result = algo.sort(new int[]{});

		assertArrayEquals(new int[]{}, result);
	}

	@ParameterizedTest
	@ValueSource(classes = {HeapSort.class, InsertionSort.class, MergeSort.class, QuickSort.class, SelectionSort.class})
	void sortOneElement(Class<Sort> clazz) throws Exception {
		Sort algo = clazz.getConstructor().newInstance();

		int[] result = algo.sort(new int[]{0});

		assertArrayEquals(new int[]{0}, result);
	}

	@ParameterizedTest
	@ValueSource(classes = {HeapSort.class, InsertionSort.class, MergeSort.class, QuickSort.class, SelectionSort.class})
	void sortNull(Class<Sort> clazz) throws Exception {
		Sort algo = clazz.getConstructor().newInstance();

		assertThrows(NullPointerException.class, () -> algo.sort(null));
	}

}
