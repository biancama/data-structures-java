package org.biancama.algorithms.utils;

/**
 * Created by massimo on 27/04/16.
 */
public class ArraysUtils {
	private ArraysUtils() {}

	public static final <T> void swap (T[] a, int i, int j) {
		T t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
