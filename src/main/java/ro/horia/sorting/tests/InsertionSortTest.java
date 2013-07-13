package ro.horia.sorting.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ro.horia.sorting.bycompare.InsertionSort;





public class InsertionSortTest {
//sadsfsdgghgfhsss
	int[] sortedAscending = { 1, 2, 3, 5, 6, 7, 8 };
	int[] sortedDescending = { 30, 8, 6, 5, 3, 2, 1 };

	@Test
	public void nothingToSort() {
		assertArrayEquals(sortedAscending,
				InsertionSort.insertionSortIncreasing(sortedAscending));
	}

	@Test
	public void sortUnsorted() {
		assertArrayEquals(
				sortedAscending,
				InsertionSort.insertionSortIncreasing(new int[] { 8, 7, 6, 5,
						3, 2, 1 }));
	}

	@Test
	public void sortSameArray() {
		assertArrayEquals(
				new int[] { 8, 8, 8, 8, 8, 8, 8 },
				InsertionSort.insertionSortIncreasing(new int[] { 8, 8, 8, 8,
						8, 8, 8 }));
	}

	@Test
	public void sortDescending() {
		assertArrayEquals(
				sortedDescending,
				InsertionSort.insertionSortDecreasing(new int[] { 8, 30, 6, 2,
						3, 5, 1 }));
	}

}
