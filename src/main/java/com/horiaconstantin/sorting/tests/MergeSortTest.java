package com.horiaconstantin.sorting.tests;

import com.horiaconstantin.sorting.bycompare.MergeSort;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {

	int[] testArray = new int[10];
	int[] sortedArray;

	{
		for (int i = 0; i < testArray.length; i++) {
			testArray[i] = (int) (Math.random() * 1000);
		}
		sortedArray = testArray.clone();
		Arrays.sort(sortedArray);
	}

	@Test
	public void sortUnsorted() {
		for (int i = 0; i < testArray.length; i++) {
			System.out.print(testArray[i]+" ");
		}
		int[] sortedByMergeSort=MergeSort.sort(testArray);
		System.out.println("");
		for (int i = 0; i < testArray.length; i++) {
			System.out.print(sortedByMergeSort[i]+" ");
		}
		assertArrayEquals(sortedArray,sortedByMergeSort);
		
	}

}
