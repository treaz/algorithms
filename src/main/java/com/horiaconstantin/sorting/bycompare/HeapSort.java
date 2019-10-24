package com.horiaconstantin.sorting.bycompare;

import java.util.Objects;

/**
 * when you use an array to implement a binary tree, you do what is called
 * "level ordered traversal of the binary tree".
 * 
 * heap property: If A is a parent node of B then key(A) is ordered with respect
 * to key(B) with the same ordering applying across the heap. Either the keys of
 * parent nodes are always greater than or equal to those of the children and
 * the highest key is in the root node (this kind of heap is called max heap) or
 * the keys of parent nodes are less than or equal to those of the children and
 * the least key is in the root node (min heap).
 * 
 * @author Horia Constantin
 * 
 */
public class HeapSort implements Sort {

	int heapSize;

	public int[] sort(int[] a) {
		Objects.requireNonNull(a);
		int[] result = new int[a.length];
		heapSize = a.length - 1;
		buildMaxHeap(a);
		for (int i = a.length - 1; i >= 0; i--) {
			result[i] = a[0];
			int tmp;
			tmp = a[0];
			a[0] = a[i];
			a[i] = tmp;
			heapSize--;
			maxHeapify(a, 0);
		}
		return result;
	}

	/**
	 * uses siftdown to make the binary tree a maxheap (ordered values)
	 * 
	 * @author Horia Constantin
	 * @param a
	 * @param i
	 */
	void maxHeapify(int[] a, int i) {
		int left = getLeft(i);
		int right = getRight(i);
		int largest;
		if (left <= heapSize && a[left] > a[i]) {
			largest = left;
		} else {
			largest = i;
		}
		if (right <= heapSize && a[right] > a[largest]) {
			largest = right;
		}
		if (largest != i) {
			int tmp = a[largest];
			a[largest] = a[i];
			a[i] = tmp;
			maxHeapify(a, largest);
		}
	}

	/**
	 * the leaves are the nodes indexed (n/2)+1....n. These elements don't need
	 * to be sorted as a single leaf is already sorted. In this part we just
	 * create the maxheap using maxHeapify
	 */
	private void buildMaxHeap(int[] a) {
		for (int i = (a.length - 1) / 2; i >= 0; i--) {
			maxHeapify(a, i);
		}
	}

	public int getLeft(int i) {
		return 2 * i + 1;
	}

	public int getRight(int i) {
		return 2 * i + 2;
	}

	public int getParent(int i) {
		return (i - 1) / 2;
	}
}
