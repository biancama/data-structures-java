package org.biancama.algorithms.sort;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.collections.CollectionUtils.addAll;

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
	public static <T extends Comparable<? super T>> List<T> sort(final List<T> unsorted) {
		int n = unsorted.size();
		List<T> result = new ArrayList<>(unsorted.size());
		addAll(result, unsorted.iterator());
		for (int k = 1; k < n; k++) {
			int j = k;
			T curr = result.get(k);
			while (j > 0 && result.get(j-1).compareTo(curr) > 0) {
				result.set(j, result.get(j - 1));
				j--;
			}
			result.set(j, curr);
		}
		return result;
	}
}
