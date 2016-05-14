package org.biancama.algorithms.collection;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by massimo on 13/05/16.
 */
public class SinglyLinkedListTest {
	@Test
	public void givenAListPerformAllOperations() {
		List<Integer> list = new SinglyLinkedList<>();
		assertThat(list.size(), is(0));
		assertThat(list.isEmpty(), is(true));
		list.addFirst(new Integer(10));
		assertThat(list.size(), is(1));
		assertThat(list.isEmpty(), is(false));
		assertThat(list.first(), is(10));
		assertThat(list.get(0), is(10));
		list.addFirst(new Integer(10));
		assertThat(list.size(), is(2));
		assertThat(list.isEmpty(), is(false));
		assertThat(list.first(), is(10));
		list.set(1, 20);
		assertThat(list.get(1), is(20));
		assertThat(list.last(), is(20));
		list.addFirst(new Integer(40));
		assertThat(list.get(0), is(40));
		list.add(2, new Integer(50));
		assertThat(list.get(2), is(50));
		assertThat(list.remove(1), is(10));
		assertThat(list.size(), is(3));
		assertThat(list.get(1), is(50));
		list.addFirst(5);
		assertThat(list.size(), is(4));
		assertThat(list.get(0), is(5));
		list.addLast(60);
		assertThat(list.size(), is(5));
		assertThat(list.get(4), is(60));
		assertThat(list.removeFirst(), is(5));
		assertThat(list.size(), is(4));
		assertThat(list.get(0), is(40));
		int counter = 0;
		for (Integer integer : list) {
			assertThat(integer, is (list.get(counter++)));
		}

	}
}
