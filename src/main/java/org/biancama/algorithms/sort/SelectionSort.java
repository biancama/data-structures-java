package org.biancama.algorithms.sort;

import static org.biancama.algorithms.utils.ArraysUtils.swap;

/**
 * Created by massimo on 27/04/16.
 */
public class SelectionSort {
	private SelectionSort() {}
	/**
	 * Algorithm InsertionSort(A):
	 * Input: An array A of n comparable elements
	 * Output: The array A with elements rearranged in nondecreasing order
	 * for k from 0 to n−1 do
	 * Insert in A[k] the min of A[K], A[k + 1], . . ., A[n].
	 * @param unsorted
	 * @return
	 */
	public static <T extends Comparable<? super T>> T[] sort(T[] unsorted) {
		int n = unsorted.length;
		for (int k = 0; k < n; k++) {
			int minIndex = k;
			for (int i = k + 1; i < n; i++) {
				if (unsorted[i].compareTo(unsorted[minIndex]) < 0) {
					minIndex = i;
				}
			}
			swap(unsorted, k, minIndex);
		}
		return unsorted;
	}

}
