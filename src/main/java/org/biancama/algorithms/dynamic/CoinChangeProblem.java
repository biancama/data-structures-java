package org.biancama.algorithms.dynamic;

import static java.lang.String.format;

import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by massimo.biancalani on 04/10/2017.
 */
@Log
public class CoinChangeProblem {

    private final int amount;
    private final Set<Integer> coins;

    final private Integer[] utilityArray;
    final private int [][] m;
    final private int [] m_1;

    private Map<String, Set<List<Integer>>> mapForMemoization;

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

        mapForMemoization = new HashMap<>();
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

    private String getKeyForMemoization(int amount, List<Integer> possibilities) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(amount);
        for (Integer possibility : possibilities) {
            stringBuilder.append(format("_%d", possibility));
        }
        return  stringBuilder.toString();
    }
    public Set<List<Integer>> solutionSet() {
        List<Integer> possibilities = new ArrayList<>(coins);
        return solutionSet(new ArrayList<>(), amount, possibilities);
    }
    private Set<List<Integer>> solutionSet(List<Integer> result, int amount, List<Integer> possibilities) {
        if (amount == 0) {
            Set<List<Integer>> partialResult = new HashSet<>();
            partialResult.add(result);
            return partialResult;
        } else if (amount < 0 || possibilities.isEmpty()) {
            return new HashSet<>();
        } else {
            var firstCoin = possibilities.get(0);
            var possibilitiesWithFirstCoin = new ArrayList<>(possibilities);
            var possibilitiesWithoutFirstCoin = new ArrayList<>(possibilities);
            possibilitiesWithoutFirstCoin.remove(0);
            var resultWithFirstCoin = new ArrayList<>(result);
            var resultWithoutFirstCoin = new ArrayList<>(result);
            resultWithFirstCoin.add(firstCoin);
            var solutionWithFirstCoin = solutionSet(resultWithFirstCoin, amount - firstCoin, possibilitiesWithFirstCoin);
            var solutionWithoutFirstCoin = solutionSet(resultWithoutFirstCoin, amount, possibilitiesWithoutFirstCoin);
            solutionWithFirstCoin.addAll(solutionWithoutFirstCoin);
            return new HashSet<>(solutionWithFirstCoin);
        }
    }

    private Set<List<Integer>> solutionSetWithMemoization(List<Integer> result, int amount, List<Integer> possibilities) {
        String key = getKeyForMemoization(amount, possibilities);
        System.out.println(key);
        if (mapForMemoization.containsKey(key)) {
            return mapForMemoization.get(key);
        } else {
            if (amount == 0) {
                Set<List<Integer>> partialResult = new HashSet<>();
                partialResult.add(result);
                return partialResult;
            } else if (amount < 0 || possibilities.isEmpty()) {
                mapForMemoization.put(key, new HashSet<>());
                return new HashSet<>();
            } else {
                var firstCoin = possibilities.get(0);
                var possibilitiesWithFirstCoin = new ArrayList<>(possibilities);
                var possibilitiesWithoutFirstCoin = new ArrayList<>(possibilities);
                possibilitiesWithoutFirstCoin.remove(0);
                var resultWithFirstCoin = new ArrayList<>(result);
                var resultWithoutFirstCoin = new ArrayList<>(result);
                resultWithFirstCoin.add(firstCoin);
                var solutionWithFirstCoin = solutionSetWithMemoization(resultWithFirstCoin, amount - firstCoin, possibilitiesWithFirstCoin);
                var solutionWithoutFirstCoin = solutionSetWithMemoization(resultWithoutFirstCoin, amount, possibilitiesWithoutFirstCoin);
                solutionWithFirstCoin.addAll(solutionWithoutFirstCoin);
                var solution = new HashSet<>(solutionWithFirstCoin);
                //mapForMemoization.put(key, solution);
                return solution;
            }

        }
    }
    public Set<List<Integer>> solutionSetWithMemoization() {
        List<Integer> possibilities = new ArrayList<>(coins);
        return solutionSetWithMemoization(new ArrayList<>(), amount, possibilities);
    }
}
