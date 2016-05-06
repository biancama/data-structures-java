package org.biancama.algorithms.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by massimo on 23/04/16.
 */
public class MergeSort {
	private MergeSort() {}

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
		if (unsorted == null ||  unsorted.size() < 2) {
			return unsorted;
		} else {
			int middleIndex = unsorted.size() / 2;
			List<T> left = unsorted.subList(0, middleIndex);
			List<T> right = unsorted.subList(middleIndex, unsorted.size());
			left = sort(left);
			right = sort(right);
			return merge(left, right);
		}
	}



	private static <T extends Comparable<? super T>> List<T> merge(final List<T> left, final List<T> right ) {
		final List<T> result = new ArrayList<>(left.size() + right.size()) ;
		int i = 0, j = 0;
		for (int k = 0; k < left.size() + right.size(); k++) {
			if (i == left.size() || j < right.size() && left.get(i).compareTo(right.get(j)) > 0) {
				result.add(right.get(j));
				j++;
			} else {
				result.add(left.get(i));
				i++;
			}
		}
		return result;
	}

}
