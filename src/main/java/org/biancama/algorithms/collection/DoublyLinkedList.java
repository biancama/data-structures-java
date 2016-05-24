package org.biancama.algorithms.collection;

import lombok.AllArgsConstructor;

import java.util.Iterator;

/**
 * Created by massimo on 24/05/16.
 */
public class DoublyLinkedList<E> implements List<E> {
	private int size = 0;
	Node<E> head;

	@AllArgsConstructor
	private static class Node<E> {
		private E elem;
		Node<E> prev, next;
	}

	private static<E> Node<E> getNode(int position, final Node<E> pointer) {
		Node<E> internalPointer = pointer;
		for (int j = 0; j < position; j++) {
			internalPointer = internalPointer.next;
		}
		return internalPointer;
	}
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i > size() - 1 ) {
			throw new IndexOutOfBoundsException("The index is negative or greater than size() - 1 ");
		}
		Node<E> pointer = head;
		pointer = getNode(i, pointer);
		return pointer.elem;
	}

	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i > size() - 1 ) {
			throw new IndexOutOfBoundsException("The index is negative or greater than size() - 1 ");
		}
		Node<E> pointer = head;
		pointer = getNode(i, pointer);
		pointer.elem = e;
		return e;
	}

	@Override
	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i > size() ) {
			throw new IndexOutOfBoundsException("The index is negative or greater than size() ");
		}
		size++;
		if (i == 0) {
			Node<E> newElem = new Node<>(e, null, head);
			if (head != null) {
				head.prev = newElem;
			}
			head = newElem;

		} else {
			Node<E> pointer = getNode(i-1, head);
			Node<E> newElem = new Node<>(e, pointer,  pointer.next);
			pointer.next =  newElem;
		}
	}

	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i > size() ) {
			throw new IndexOutOfBoundsException("The index is negative or greater than size() ");
		}
		size--;
		Node<E> pointer = head;
		if (i == 0) {
			head = head.next;
			pointer.next = null;
			pointer.prev = null;
			if (head != null) {
				head.prev = null;
			}
			return pointer.elem;
		} else {
			pointer = getNode(i-1, head);
			Node<E> pointerApp = pointer.next;
			pointer.next =  pointer.next.next;
			if (pointerApp.next != null) {
				pointerApp.next.prev = pointer;
			}
			pointerApp.next = null;
			pointerApp.prev = null;
			return pointerApp.elem;
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			Node<E> pointerApp = head;
			@Override
			public void remove() {
				throw new UnsupportedOperationException("remove");
			}

			@Override
			public boolean hasNext() {
				return pointerApp != null;
			}

			@Override
			public E next() {
				E result = pointerApp.elem;
				pointerApp = pointerApp.next;
				return result;
			}
		};
	}

	@Override
	public E first() {
		return head != null ? head.elem : null;
	}

	@Override
	public E last() {
		if (head == null) {
			return null;
		} else {
			return getNode(size - 1, head).elem;
		}
	}

	@Override
	public void addLast(E e) {
		add(size, e);
	}

	@Override
	public void addFirst(E e) {
		add(0, e);
	}

	@Override
	public E removeFirst() throws IndexOutOfBoundsException {
		return remove(0);
	}
}
