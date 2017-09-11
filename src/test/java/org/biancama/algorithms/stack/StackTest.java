package org.biancama.algorithms.stack;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.Test;


/**
 * Created by massimo on 24/09/16.
 */
public class StackTest {
	@Test
	public void givenAStackPerformAllOperations() {
		Stack<Integer> stack = new StackImpl<>();
		assertThat(stack.isEmpty()).isTrue();
		assertThat(stack.pop()).isNull();
		stack.push(1);
		stack.push(2);
		assertThat(stack.isEmpty()).isFalse();
		assertThat(stack.size()).isEqualTo(2);
		assertThat(stack.top()).isEqualTo(2);
		assertThat(stack.pop()).isEqualTo(2);
		assertThat(stack.size()).isEqualTo(1);
		assertThat(stack.top()).isEqualTo(1);
		assertThat(stack.pop()).isEqualTo(1);
		assertThat(stack.isEmpty()).isTrue();

	}
}
