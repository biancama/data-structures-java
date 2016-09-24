package org.biancama.algorithms.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by massimo on 24/09/16.
 */
public class StackImpl<E> implements Stack<E> {
	private List<E> collection = new ArrayList<>();
	private int topIndex = -1;
	
	@Override
	public void push(E e) {
		collection.add(e);
		topIndex++;
	}

	@Override
	public E pop() {
		E lastElement = top();
		if (topIndex != -1) {
			collection.remove(topIndex--);
		}
		return lastElement;
	}

	@Override
	public E top() {
		if (isEmpty()) {
			return null;
		} else {
			return collection.get(topIndex);
		}
	}

	@Override
	public int size() {
		return topIndex + 1;
	}

	@Override
	public boolean isEmpty() {
		return topIndex == -1;
	}
}
