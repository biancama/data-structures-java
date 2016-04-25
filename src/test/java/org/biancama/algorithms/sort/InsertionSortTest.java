package org.biancama.algorithms.sort;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by massimo on 23/04/16.
 */
public class InsertionSortTest {

	@Test
	public void givenAnUnsortedArrayThenTheAlgorithmReturnItBackSorted01() {
		Integer[] unsortedArray = {2, 3, 8, 1, 7, 6, 4, 5};
		Integer[] expectedArray = {1, 2, 3, 4, 5, 6, 7, 8};
		Integer[] actualArray = InsertionSort.sort(unsortedArray);
		assertThat(actualArray, is(expectedArray));
	}

	@Test
	public void givenAnUnsortedArrayThenTheAlgorithmReturnItBackSorted02() {
		Integer[] unsortedArray = {8, 7, 6, 5, 4, 3, 2, 1};
		Integer[] expectedArray = {1, 2, 3, 4, 5, 6, 7, 8};
		Integer[] actualArray = InsertionSort.sort(unsortedArray);
		assertThat(actualArray, is(expectedArray));
	}
}
