package org.biancama.algorithms.stack;

/**
 * Created by massimo on 24/09/16.
 */
public interface Stack<E> {
	void push(E e);

	E pop();

	E top();

	int size();

	boolean isEmpty();

}
