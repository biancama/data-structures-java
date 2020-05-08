package org.biancama.algorithms.tuple;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.biancama.algorithms.tuple.contract.Value1;

@EqualsAndHashCode
@ToString
public final class Unit<A> implements Tuple<Unit<A>>, Value1<A> {

    private final A a;

    private Unit(A a) {
        this.a = a;
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public A apply(int value) {
        switch (value) {
            case 0:
                return a;
            default:
                throw new IndexOutOfBoundsException();
        }
    }

    public static <A> Unit<A> valueOf(A _0) {
        return new Unit<>(_0);
    }

    @Override
    public A _1() {
        return a;
    }
}
