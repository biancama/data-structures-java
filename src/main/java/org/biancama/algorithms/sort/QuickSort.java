package org.biancama.algorithms.sort;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.collections.CollectionUtils.addAll;

/**
 * Created by massimo on 23/04/16.
 */
public class QuickSort {
	private QuickSort() {}

	/**
	 * Algorithm Quick Sort(A):
	 * Input: An array A of n comparable elements
	 * Output: The array A with elements rearranged in nondecreasing order
	 * Pick an element, called a pivot, from the array.
	 * Partitioning: reorder the array so that all elements with values less than the pivot come before the pivot, while all elements with values greater than the pivot come after it (equal values can go either way). After this partitioning, the pivot is in its final position. This is called the partition operation.
	 * Recursively apply the above steps to the sub-array of elements with smaller values and separately to the sub-array of elements with greater values.
	 * @param unsorted
	 * @return
	 */
	public static <T extends Comparable<? super T>> List<T> sort(final List<T> unsorted) {
		if (unsorted == null) {
			return null;
		}
		List<T> result = new ArrayList<>(unsorted.size());
		addAll(result, unsorted.iterator());

		if (result.size() < 2) {
			return result;
		} else {
			T pivot = getPivot(result);
			List<T> less = new ArrayList<>();
			List<T> more = new ArrayList<>();
			List<T> equal = new ArrayList<>();
			for (T t : result) {
				if (t.compareTo(pivot) < 0) {
					less.add(t);
				} else if (t.compareTo(pivot) > 0) {
					more.add(t);
				} else {
					equal.add(t);
				}
			}
			less = sort(less);
			more = sort(more);
			less.addAll(equal);
			less.addAll(more);
			return less;
 		}
	}

	private static <T extends Comparable<? super T>> T getPivot(List<T> result) {
		T first = result.get(0);
		T last = result.get(result.size() - 1);
		T center = result.get(result.size()/2);
		if (center.compareTo(first) >= 0 &&  center.compareTo(last) <= 0 || center.compareTo(first) <= 0 &&  center.compareTo(last) >= 0) {
			return center;
		} else if (first.compareTo(center) >= 0 &&  first.compareTo(last) <= 0 || first.compareTo(center) <= 0 &&  first.compareTo(last) >= 0 ) {
			return first;
		} else {
			return last;
		}
	}
}
