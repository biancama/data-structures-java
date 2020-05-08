package org.biancama.algorithms.dynamic;

import org.biancama.algorithms.stack.CallStack;
import org.biancama.algorithms.tuple.Tuple;
import org.biancama.algorithms.tuple.Unit;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FibonacciProblem {
    private static Map<Integer, Integer> mapForMemoization = new HashMap<>();

    public static int fibonacciRecursive(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        }
    }

    public static int fibonacciRecursiveMemoization(int n) {
        if (mapForMemoization.containsKey(n)) {
            return mapForMemoization.get(n);
        } else {
            if (n == 0 || n == 1) {
                return n;
            } else {
                var result = fibonacciRecursiveMemoization(n - 1) + fibonacciRecursiveMemoization(n - 2);
                mapForMemoization.put(n, result);
                return result;
            }
        }
    }


    public static int fibonacciRecursiveMemoizationAnUseOfCallStack(int n) {
        var callStack = new CallStack<Integer, Unit<Integer>>();
        callStack.init(Tuple.valueOf(n));

        if (mapForMemoization.containsKey(n)) {
            return mapForMemoization.get(n);
        } else {
            while (!callStack.isCallStackOver()) {
                var currentParameterArray = callStack.getCurrentCallInputParameters();
                n = currentParameterArray._1();
                if (n < 2) {
                    callStack.returnResult(n);
                } else {
                    switch (callStack.getResumePoint()) {
                        case 0:
                            callStack.recursiveCall(Tuple.valueOf(n - 1));
                            break;
                        case 1:
                            callStack.recursiveCall(Tuple.valueOf(n - 2));
                            break;
                        case 2:
                            var outputs = callStack.getOutputs();
                            var solution = outputs.get(0) + outputs.get(1);
                            mapForMemoization.put(n, solution);
                            callStack.returnResult(solution);
                    }
                }
            }
        }
        return callStack.getLastReturn();
    }
}

