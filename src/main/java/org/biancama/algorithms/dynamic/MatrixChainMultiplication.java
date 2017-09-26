package org.biancama.algorithms.dynamic;

import static org.apache.commons.collections.CollectionUtils.isEmpty;

import lombok.AllArgsConstructor;

import java.util.List;

/**
 * Created by massimo.biancalani on 25/09/2017.
 */

public class MatrixChainMultiplication {

    private final List<MatrixDimension> matrices;

    private boolean isDone = false;

    private int[][] m;
    private int[][] s;

    private int[] dimensions;

    public MatrixChainMultiplication(List<MatrixDimension> matrices) {
        if (isEmpty(matrices)) {
            throw new IllegalArgumentException("matrices can't be empty");
        }
        this.matrices = matrices;
        dimensions = new int[matrices.size() + 1];
        for (int i = 0; i < matrices.size(); i++) {
            dimensions[i] = matrices.get(i).left;
            if ( i != matrices.size() -1 &&  matrices.get(i).right != matrices.get(i + 1).left) {
                throw new IllegalArgumentException("Wrong matrix dimension");
            }
        }
        dimensions[matrices.size()] = matrices.get(matrices.size() - 1).right;
        m = new int[matrices.size()][matrices.size()];
        s = new int[matrices.size()][matrices.size()];
    }

    public int minimunNumberOfOperations() {
        if (!isDone) {
            compute();
        }
        return m[0][matrices.size() - 1];
    }

    public String optimalSplit() {
        if (!isDone) {
            compute();
        }
        return printOptimalParens(0, matrices.size() - 1);
    }

    private String printOptimalParens(int i, int j) {
        if (i == j) {
            return "A" + (i+1);
        } else {
            return "(" + printOptimalParens(i, s[i][j]) +  printOptimalParens(s[i][j] + 1, j) +")";
        }
    }

    private void compute() {
        for (int i = 0; i < matrices.size(); i++) {
            m[i][i] = 0;
        }
        for (int l = 1; l < matrices.size(); l++) {
            for (int i = 0; i < matrices.size() - l; i++) {
                int j = i + l;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k + 1][j] + dimensions[i] * dimensions[k+1] * dimensions[j+1];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
        isDone = true;
    }

    @AllArgsConstructor
    public static class MatrixDimension {
        private final int left;
        private final int right;
    }
}
