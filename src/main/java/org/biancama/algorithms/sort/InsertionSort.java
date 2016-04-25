package org.biancama.algorithms.sort;

/**
 * Created by massimo on 23/04/16.
 */
public class InsertionSort {
	private InsertionSort() {}

	/**
	 * Algorithm InsertionSort(A):
	 * Input: An array A of n comparable elements
	 * Output: The array A with elements rearranged in nondecreasing order
	 * for k from 1 to n−1 do
	 * Insert A[k] at its proper location within A[0], A[1], . . ., A[k].
	 * @param unsorted
	 * @return
	 */
	public static <T extends Comparable<? super T>> T[] sort(T[] unsorted) {
		int n = unsorted.length;
		for (int k = 1; k < n; k++) {
			int j = k;
			T curr = unsorted[k];
			while (j > 0 && unsorted[j-1].compareTo(curr) > 0) {
				unsorted[j] = unsorted[j-1];
				j--;
			}
			unsorted[j] = curr;
		}
		return unsorted;
	}
}
