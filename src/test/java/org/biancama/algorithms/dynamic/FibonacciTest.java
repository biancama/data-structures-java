package org.biancama.algorithms.dynamic;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.Test;

public class FibonacciTest {

    @Test
    public void test01() {
        assertThat(FibonacciProblem.fibonacciRecursive(6)).isEqualTo(8);
    }

    @Test
    public void test02() {
        assertThat(FibonacciProblem.fibonacciRecursiveMemoization(6)).isEqualTo(8);
        assertThat(FibonacciProblem.fibonacciRecursiveMemoization(4)).isEqualTo(3);
    }

    @Test
    public void test03() {
        assertThat(FibonacciProblem.fibonacciRecursiveMemoizationAnUseOfCallStack(6)).isEqualTo(8);
        assertThat(FibonacciProblem.fibonacciRecursiveMemoizationAnUseOfCallStack(7)).isEqualTo(13);
        assertThat(FibonacciProblem.fibonacciRecursiveMemoizationAnUseOfCallStack(12)).isEqualTo(144);
    }

    @Test
    public void test04() {
        assertThat(FibonacciProblem.fibonacciDynamic(6)).isEqualTo(8);
        assertThat(FibonacciProblem.fibonacciDynamic(7)).isEqualTo(13);
        assertThat(FibonacciProblem.fibonacciDynamic(12)).isEqualTo(144);
    }
}
