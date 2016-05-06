package org.biancama.algorithms.sort;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.swap;
import static org.apache.commons.collections.CollectionUtils.addAll;

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
	public static <T extends Comparable<? super T>> List<T> sort(final List<T> unsorted) {
		int n = unsorted.size();
		List<T> result = new ArrayList<>(unsorted.size());
		addAll(result, unsorted.iterator());
		for (int k = 0; k < n; k++) {
			int minIndex = k;
			for (int i = k + 1; i < n; i++) {
				if (result.get(i).compareTo(result.get(minIndex)) < 0) {
					minIndex = i;
				}
			}
			swap(result, k, minIndex);
		}
		return result;
	}

}
