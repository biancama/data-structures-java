package org.biancama.algorithms.dynamic;

import static java.util.Arrays.asList;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.Test;

import java.util.List;

/**
 * Created by massimo.biancalani on 10/09/2017.
 */
public class KnapSackTest {

    @Test
    public void test01() {
        List<Integer> weights = asList(1, 3, 4, 5);
        List<Integer> values = asList(1, 4, 5, 7);
        KnapSack knapSack = new KnapSack(weights, values, 7);

        assertThat(knapSack.getOptimalValue()).isEqualTo(9);
        assertThat(knapSack.getOptimalChoice()).containsExactlyInAnyOrder(1, 2);
    }

    @Test
    public void test02() {
        List<Integer> weights = asList(1, 2, 2, 2, 2);
        List<Integer> values = asList(1, 2, 3, 4, 5);
        KnapSack knapSack = new KnapSack(weights, values, 2);

        assertThat(knapSack.getOptimalValue()).isEqualTo(5);
        assertThat(knapSack.getOptimalChoice()).containsExactlyInAnyOrder(4);
    }


    @Test
    public void test03() {
        List<Integer> weights = asList(1, 2, 2, 2, 2);
        List<Integer> values = asList(1, 2, 3, 4, 5);
        KnapSack knapSack = new KnapSack(weights, values, 5);

        assertThat(knapSack.getOptimalValue()).isEqualTo(10);
        assertThat(knapSack.getOptimalChoice()).containsExactlyInAnyOrder(0, 3, 4);
    }

}
