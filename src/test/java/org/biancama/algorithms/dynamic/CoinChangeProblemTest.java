package org.biancama.algorithms.dynamic;

import static java.util.Arrays.asList;
import static java.util.Collections.sort;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by massimo.biancalani on 04/10/2017.
 */
public class CoinChangeProblemTest {

    @Test
    public void test01() {
        CoinChangeProblem coinChangeProblem = new CoinChangeProblem(5, new HashSet<Integer>(){{add(1);add(2);add(3);}});
        assertThat(coinChangeProblem.solution()).isEqualTo(5);
    }

    @Test
    public void test02() {
        CoinChangeProblem coinChangeProblem = new CoinChangeProblem(5, new HashSet<Integer>(){{add(1);add(2);add(5);}});
        assertThat(coinChangeProblem.solution()).isEqualTo(4);
    }

    @Test
    public void test03() {
        CoinChangeProblem coinChangeProblem = new CoinChangeProblem(5, new HashSet<Integer>(){{add(1);add(2);add(3);}});
        assertThat(coinChangeProblem.solutionWithArray()).isEqualTo(5);
    }

    @Test
    public void test04() {
        CoinChangeProblem coinChangeProblem = new CoinChangeProblem(5, new HashSet<Integer>(){{add(1);add(2);add(5);}});
        assertThat(coinChangeProblem.solutionWithArray()).isEqualTo(4);
    }

    @Test
    public void test05() {
        CoinChangeProblem coinChangeProblem = new CoinChangeProblem(5, new HashSet<Integer>(){{add(1);add(2);add(5);}});
        Set<List<Integer>> expectedSolutionSets = Set.of(asList(1, 1, 1, 1, 1), asList(1, 1, 1, 2), asList(1, 2, 2), asList(5));
        Set<List<Integer>> actualSolutionSets = coinChangeProblem.solutionSet();
        checkSolution(expectedSolutionSets, actualSolutionSets);
    }

    @Test
    public void test06() {
        CoinChangeProblem coinChangeProblem = new CoinChangeProblem(5, new HashSet<Integer>(){{add(1);add(2);add(3);}});
        Set<List<Integer>> expectedSolutionSets = Set.of(asList(1, 1, 1, 1, 1), asList(1, 1, 1, 2), asList(1, 2, 2), asList(1, 1, 3), asList(2, 3));
        Set<List<Integer>> actualSolutionSets = coinChangeProblem.solutionSet();
        checkSolution(expectedSolutionSets, actualSolutionSets);
    }

    @Test
    public void test07() {
        CoinChangeProblem coinChangeProblem = new CoinChangeProblem(5, new HashSet<Integer>(){{add(1);add(2);add(5);}});
        Set<List<Integer>> expectedSolutionSets = Set.of(asList(1, 1, 1, 1, 1), asList(1, 1, 1, 2), asList(1, 2, 2), asList(5));
        Set<List<Integer>> actualSolutionSets = coinChangeProblem.solutionSetWithMemoization();
        checkSolution(expectedSolutionSets, actualSolutionSets);
    }

    @Test
    public void test08() {
        CoinChangeProblem coinChangeProblem = new CoinChangeProblem(5, new HashSet<Integer>(){{add(1);add(2);add(3);}});
        Set<List<Integer>> expectedSolutionSets = Set.of(asList(1, 1, 1, 1, 1), asList(1, 1, 1, 2), asList(1, 2, 2), asList(1, 1, 3), asList(2, 3));
        Set<List<Integer>> actualSolutionSets = coinChangeProblem.solutionSetWithMemoization();
        checkSolution(expectedSolutionSets, actualSolutionSets);
    }

    private void checkSolution(Set<List<Integer>> expectedSolutionSets, Set<List<Integer>> actualSolutionSets) {
        assertThat(actualSolutionSets.size()).isEqualTo(expectedSolutionSets.size());
        // for comparing I need to sort
        for (List<Integer> actualSolutionSet : actualSolutionSets) {
            sort(actualSolutionSet);
        }
        for (List<Integer> expectedSolutionSet : expectedSolutionSets) {
            sort(expectedSolutionSet);
        }
        for (List<Integer> expectedSolutionSet : expectedSolutionSets) {
            assertThat(actualSolutionSets).contains(expectedSolutionSet);
        }
    }
}
