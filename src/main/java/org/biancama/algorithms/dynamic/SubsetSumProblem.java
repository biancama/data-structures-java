package org.biancama.algorithms.dynamic;

import static org.apache.commons.collections.CollectionUtils.isEmpty;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by massimo.biancalani on 26/09/2017.
 */
public class SubsetSumProblem {
    final private Set<Integer> numbers;
    final private int sum;

    final private Integer[] utilityArray;
    
    final private boolean[][] m;

    private boolean isDone = false;
    
    public SubsetSumProblem(Set<Integer> numbers, int sum) {
        this.numbers = numbers;
        this.sum = sum;
        if (isEmpty(numbers)) {
            throw new IllegalArgumentException("Set of numbers can't be empty");
        }
        utilityArray = numbers.toArray(new Integer[0]);
        m = new boolean[numbers.size() + 1][sum + 1];
        for (int i = 0; i < numbers.size() + 1; i++) {
            m[i][0] = true; // if the sum is zero the solution is complete
        }
        for (int i = 1; i < sum + 1; i++) {
            m[0][i] = false; // if the sum is not zero but te number set is empty
        }
    }

    public boolean solutionExists() {
        if (!isDone) {
            compute();
        }
        return m[numbers.size()][sum];
    }
    public Set<Integer> solution() {
        Set<Integer> result = new HashSet<>();
        int indexX = numbers.size();
        int indexY = sum;
        while (indexX > 0 ) {
            if (!m[indexX-1][indexY]) { // the element has been introduced
                result.add(utilityArray[indexX - 1]);
                indexY -= utilityArray[indexX - 1];
            } else {
                indexX--;
            }
        }
        return result;
    }
    private void compute() {
        for (int i  = 1; i < numbers.size() + 1 ; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (j < utilityArray[i -1]){
                    m[i][j] = m[i-1][j];
                } else {
                    m[i][j] = m[i-1][j] || m[i-1][j - utilityArray[i -1]];
                }
            }
        }
        isDone = true;
    }


}
