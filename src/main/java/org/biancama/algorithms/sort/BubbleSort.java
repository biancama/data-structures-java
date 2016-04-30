package org.biancama.algorithms.sort;

import static org.biancama.algorithms.utils.ArraysUtils.swap;

/**
 * Created by massimo on 23/04/16.
 */
public class BubbleSort {
	private BubbleSort() {}

	/**
	 * Algorithm InsertionSort(A):
	 * Input: An array A of n comparable elements
	 * Output: The array A with elements rearranged in nondecreasing order
	 * for k from 1 to n−1 do
	 * compare A[k+1], A[k] if A[k+1] < A[k] then swap
	 * Continue until a complete cycle without sort
	 * @param unsorted
	 * @return
	 */
	public static <T extends Comparable<? super T>> T[] sort(T[] unsorted) {
		boolean swapped = true;
		int n = unsorted.length - 1;
		while (swapped) {
			swapped = false;
			for (int i = 0; i < n; i++) {
				if (unsorted[i + 1].compareTo(unsorted[i]) < 0) {
					swap(unsorted, i, i+1);
					swapped = true;
				}
			}
			n -= 1;
		}
		return unsorted;
	}
}
