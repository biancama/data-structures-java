package org.biancama.algorithms.dynamic;

import java.util.Set;

/**
 * Created by massimo.biancalani on 04/10/2017.
 */
public class CoinChangeProblem {

    private final int amount;
    private final Set<Integer> coins;

    final private Integer[] utilityArray;
    final private int [][] m;
    final private int [] m_1;

    public CoinChangeProblem(int amount, Set<Integer> coins) {
        this.amount = amount;
        this.coins = coins;
        utilityArray = coins.toArray(new Integer[0]);
        m = new int[utilityArray.length + 1][amount + 1];
        m_1 = new int[amount + 1];

        for (int i = 1; i < amount + 1; i++) {
            m[0][i] = 0;
        }
        for (int i = 0; i < utilityArray.length + 1; i++) {
            m[i][0] = 1;
        }
        m_1[0] = 1;
    }


    public int solution() {
        for (int i = 1; i < utilityArray.length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if ( j - utilityArray[i-1] >=0 ) {
                    m[i][j] = m[i][j - utilityArray[i-1]] + m[i -1][j];
                } else {
                    m[i][j] = m[i - 1][j];
                }
            }
        }
        return m[utilityArray.length][amount];
    }

    public int solutionWithArray() {
        for (int i = 0; i < utilityArray.length; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j - utilityArray[i] >= 0) {
                    m_1[j] += m_1[j - utilityArray[i]];
                }
            }
        }

        return m_1[amount];
    }
}
