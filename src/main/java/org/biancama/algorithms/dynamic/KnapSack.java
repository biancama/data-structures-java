package org.biancama.algorithms.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by massimo.biancalani on 10/09/2017.
 */
public class KnapSack {

    private final List<Integer> weights;

    private final List<Integer> values;

    private final int maxWeight;

    private int solution = 0;

    private int n;

    private int[][] computedValues;

    private boolean[][] include;

    public KnapSack(List<Integer> weights, List<Integer> values, int maxWeight) {
        this.maxWeight = maxWeight;
        if(weights == null || values == null || weights.size() != values.size()) {
            throw new IllegalArgumentException("weights and values must be same size");
        }
        this.weights = weights;
        this.values = values;
        n = weights.size();

        // matrix
        computedValues = new int[n][maxWeight + 1];
        include = new boolean[n][maxWeight + 1];
        for (int i = 0; i < n; i++) {
            computedValues[i][0] = 0;
            include[i][0] = false;
        }

    }

    public int getOptimalValue() {
        compute();
        return solution;
    }

    private void compute() {
        for (int i = 0; i < 1; i++) {
            for (int j = 1; j < maxWeight + 1; j++) {
                if (j < weights.get(i)) {
                    computedValues[i][j] = 0;
                    include[i][j] = false;
                } else {
                    computedValues[i][j] = values.get(i);
                    updateSolution(computedValues[i][j]);
                    include[i][j] = true;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < maxWeight + 1; j++) {
                if (j < weights.get(i)) {
                    computedValues[i][j] = computedValues[i -1][j];
                    include[i][j] = false;
                } else {
                    computedValues[i][j] = Math.max(computedValues[i -1][j], values.get(i) + computedValues[i-1][j - weights.get(i)]) ;
                    updateSolution(computedValues[i][j]);
                    include[i][j] = computedValues[i][j] != computedValues[i -1][j];
                }
            }
        }
    }

    private void updateSolution(int i) {
        solution = Math.max(solution, i);
    }

    public List<Integer> getOptimalChoice() {
        List<Integer> result = new ArrayList<>();
        int w = maxWeight;
        while (w > 0) {
            for (int i = n-1; i >= 0; i--) {
                if (include[i][w]) {
                    result.add(i);
                    w -= weights.get(i);
                    break;
                }
            }
        }

        return result;
    }
}
