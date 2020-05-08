package org.biancama.algorithms.tuple;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public final class EmptyTuple implements Tuple<EmptyTuple> {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Object apply(int value) {
        throw new IndexOutOfBoundsException();
    }

    private static final EmptyTuple INSTANCE = new EmptyTuple();
    private static final long serialVersionUID = 1015700180699730675L;

    private EmptyTuple() {
    }

    public static EmptyTuple valueOf() {
        return INSTANCE;
    }
}
