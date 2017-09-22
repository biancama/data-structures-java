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

    private boolean isDone = false;

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
        if (!isDone) {
            compute();
        }
        return solution;
    }

    private void compute() {

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < maxWeight + 1; j++) {
                if (j < weights.get(i)) {
                    computedValues[i][j] = computedValues[Math.max(i -1, 0)][j];
                    include[i][j] = false;
                } else {
                    computedValues[i][j] = Math.max(computedValues[Math.max(i -1, 0)][j], values.get(i) + computedValues[Math.max(i -1, 0)][j - weights.get(i)]) ;
                    include[i][j] = updateSolution(computedValues[i][j]);
                }
            }
        }
        isDone = true;
    }

    private boolean updateSolution(int i) {
        boolean updated = solution != i;
        solution = Math.max(solution, i);
        return updated;
    }

    public List<Integer> getOptimalChoice() {
        if (!isDone) {
            compute();
        }
        List<Integer> result = new ArrayList<>();
        int w = maxWeight;

        for (int i = n-1; i >= 0; i--) {
            if (include[i][w]) {
                result.add(i);
                w -= weights.get(i);
            }
        }


        return result;
    }
}
