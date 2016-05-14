package org.biancama.algorithms.iterable;

import lombok.AllArgsConstructor;

import java.util.Iterator;

/**
 * Created by massimo on 13/05/16.
 */

public class SinglyLinkedList<E> implements List<E> {

	private int size = 0;
	private Node<E> head = null;
	@AllArgsConstructor
	private static class Node<E> {
		private E elem;
		private Node<E> next;
	}

	private Node<E> getNode(int position, final Node<E> pointer) {
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
		Node<E> pointer = head;
		if (i == 0) {
			Node<E> newElem = new Node<>(e, head);
			head = newElem;
		} else {
			pointer = getNode(i-1, head);
			Node<E> newElem = new Node<>(e, pointer.next);
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
			return pointer.elem;
		} else {
			pointer = getNode(i-1, head);
			Node<E> pointerApp = pointer.next;
			pointer.next =  pointer.next.next;
			pointerApp.next = null;
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
		}
		Node<E> pointer = head;
		while (pointer.next != null) {
			pointer = pointer.next;
		}
		return pointer.elem;
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
