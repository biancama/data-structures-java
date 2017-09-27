package org.biancama.algorithms.dynamic;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by massimo.biancalani on 26/09/2017.
 */
public class SubsetSumProblemTest {

    @Test
    public void test01() {
        SubsetSumProblem subsetSumProblem = new SubsetSumProblem(asSet(3, 34, 4, 12, 1, 2), 9);

        assertThat(subsetSumProblem.solutionExists()).isTrue();
        assertThat(subsetSumProblem.solution()).containsExactlyInAnyOrder(2, 3, 4);

    }

    private Set<Integer> asSet(Integer... i) {
        HashSet<Integer> result = new HashSet<>();
        for (Integer integer : i) {
            result.add(integer);
        }
        return result;
    }
}
