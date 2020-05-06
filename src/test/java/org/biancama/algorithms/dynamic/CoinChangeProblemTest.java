package org.biancama.algorithms.dynamic;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import java.util.HashSet;

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
}
