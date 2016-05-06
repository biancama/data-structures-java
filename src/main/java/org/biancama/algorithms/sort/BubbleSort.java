package org.biancama.algorithms.sort;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.swap;
import static org.apache.commons.collections.CollectionUtils.addAll;

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
	public static <T extends Comparable<? super T>> List<T> sort(final List<T> unsorted) {
		boolean swapped = true;
		int n = unsorted.size() - 1;
		List<T> result = new ArrayList<>(unsorted.size());
		addAll(result, unsorted.iterator());
		while (swapped) {
			swapped = false;
			for (int i = 0; i < n; i++) {
				if (result.get(i + 1).compareTo(result.get(i)) < 0) {
					swap(result, i, i+1);
					swapped = true;
				}
			}
			n -= 1;
		}
		return result;
	}
}
