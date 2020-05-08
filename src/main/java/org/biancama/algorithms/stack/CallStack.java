package org.biancama.algorithms.stack;

import lombok.Getter;
import lombok.Setter;
import org.biancama.algorithms.tuple.Tuple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class CallStack<Output, Input extends Tuple> {
    private Deque<StackContext<Output, Input>> callStack = new LinkedList<>();

    private StackContext<Output, Input> currentStackContext;

    @Getter
    @Setter
    Output lastReturn = null;

    public void init(Input initParameters) {
        callStack.add(new StackContext<>(initParameters));
    }

    public boolean isCallStackOver() {
        return callStack.isEmpty();
    }

    public Input getCurrentCallInputParameters() {
        currentStackContext = callStack.peekLast();
        if (currentStackContext != null) {
            return currentStackContext.procedureInput;
        } else {
            return (Input) Tuple.valueOf();
        }
    }

    public void returnResult(Output result) {
        lastReturn = result;
        callStack.removeLast();
        var nextCall = callStack.peekLast();
        if (nextCall != null) {
            nextCall.result = result;
        }

    }

    public void recursiveCall(Input t) {
        currentStackContext.incrementResumePoint();
        var lastResult = currentStackContext.result;
        if( lastResult != null) {
            currentStackContext.procedureOutput.add(lastResult);
        }
        callStack.add(new StackContext(t));
    }

    public int getResumePoint() {
        return currentStackContext == null ? 0 : currentStackContext.resumePoint;
    }

    public List<Output> getOutputs() {
        if (currentStackContext != null) {
            var lastResult = currentStackContext.result;
            if( lastResult != null) {
                currentStackContext.procedureOutput.add(lastResult);
            }
            return currentStackContext.procedureOutput;
        } else {
            return Collections.emptyList();
        }
    }

    private class StackContext<Output, Input extends Tuple> {

        private Input procedureInput;

        List<Output> procedureOutput = new ArrayList<>();
        Output result ;
        int resumePoint = 0;

        public StackContext(Input args) {
            this.procedureInput = args;
        }

        void incrementResumePoint() {
            ++resumePoint;
        }
    }
}
