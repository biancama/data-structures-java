package org.biancama.algorithms.dynamic;

import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by massimo.biancalani on 22/09/2017.
 */
public class LongestCommonSubSequence {
    final String firstString;
    final String secondString;

    private Solution[][] m;
    private boolean isDone = false;

    @AllArgsConstructor
    private static class Solution {
        private Set<String> solutions;
        private int length;
    }
    public LongestCommonSubSequence(String firstString, String secondString) {
        if(firstString == null || secondString == null ) {
            throw new IllegalArgumentException("The strings cannot be null");
        }
        this.firstString = firstString;
        this.secondString = secondString;
        m = new Solution[firstString.length() + 1][secondString.length() + 1];
        for (int i = 0; i < firstString.length() + 1; i++) {
            for (int j = 0; j < secondString.length() + 1; j++) {
                m[i][j] = new Solution(new HashSet<String>(), 0);
            }
        }

    }

    public int longestCommonSubSequenceLength() {
        if (!isDone) {
            compute();
        }
        return m[firstString.length()][secondString.length()].length;
    }

    private void compute() {
        for (int i = 1; i < firstString.length() + 1; i++) {
            for (int j = 1; j < secondString.length() + 1; j++) {
                if (firstString.charAt(i-1) == secondString.charAt(j -1)) {
                    m[i][j] = extend(m[i-1][j-1], secondString.charAt(j -1));
                } else {
                    m[i][j] = longest(m[i][j-1], m[i-1][j]);
                }
            }
        }
        isDone = true;
    }
    // it returns the longest. If they are equal in length, but different on content then it returns the union
    private Solution longest(Solution left, Solution up) {
        if (left.length == 0 || left.length < up.length) {
            return copyOf(up);
        } else if (up.length == 0 || left.length > up.length) {
            return copyOf(left);
        } else {
            return union(left, up);
        }
    }

    private Solution union(Solution left, Solution up) {
        Set<String> result = new HashSet<>();
        for (String solution : left.solutions) {
            result.add(solution);
        }
        for (String solution : up.solutions) {
            result.add(solution);
        }
        return new Solution(result, left.length);
    }

    private Solution copyOf(Solution up) {
        Set<String> result = new HashSet<>();
        for (String s : up.solutions) {
            result.add(s);
        }
        return new Solution(result, up.length);
    }

    // Extend every element of the set with current character
    private Solution extend(Solution solution, char c) {
        Set<String> result = new HashSet<>();
        if (solution.length == 0) {
            result.add(String.valueOf(c));
        } else {
            for (String string : solution.solutions) {
                result.add(string.concat(String.valueOf(c)));
            }
        }
        return new Solution(result, solution.length + 1);
    }

    public Set<String> longestCommonSubSequence() {
        if (!isDone) {
            compute();
        }
        return m[firstString.length()][secondString.length()].solutions;
    }
}
