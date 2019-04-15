package com.horiaconstantin.sorting.bycompare;

/**
 * A priority queue is a data structure for maintaining a set S of elements, each
 * with an associated value called akey. A max-priority queue supports the
 * following operations:
 * 
 * INSERT(S; x) - inserts the element x into the set S
 * 
 * MAXIMUM(S) - returns the element of S with the largest key.
 * 
 * EXTRACT-MAX(S) - removes and returns the element of S with the largest key.
 * 
 * INCREASE-KEY(S;x;k) - increases the value of element x�s key to the new value
 * k, which is assumed to be at least as large as x�s current key value.
 * 
 * @author Horia Constantin
 * 
 * 
 *         ALSO IMPLEMENTED IN JAVA API
 */
public class MaxPrioQueue extends HeapSort {

	private int heapSize;

	public int heapMax(int[] a) {
		return a[0];
	}

	public int extractMax(int[] a) throws Exception {
		if (heapSize < 1) {
			throw new Exception("no elems in the heap");
		}
		int max = a[0];
		a[0] = a[heapSize - 1];
		heapSize--;
		maxHeapify(a, 0);
		return max;
	}

	public void increasekey(int[] a, int i, int key) throws Exception {
		if (a[i] > key) {
			throw new Exception("key smaller than current value");
		}
		a[i] = key;
		while (i > 0 && a[getParent(i)] < a[i]) {
			int tmp = a[i];
			a[i] = a[getParent(i)];
			a[getParent(i)] = tmp;
			i = getParent(i);
		}
	}
	
	public int[] insertKey(int[] a, int key) throws Exception {
		heapSize++;
		int [] ret = new int[heapSize];
		for (int i=0;i<a.length;i++) {
			ret[i]=a[i];
		}
		increasekey(ret,heapSize-1,key);
		return ret;
	}
}
