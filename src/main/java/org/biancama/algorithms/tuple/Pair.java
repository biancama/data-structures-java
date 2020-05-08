package org.biancama.algorithms.tuple;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.biancama.algorithms.tuple.contract.Value1;
import org.biancama.algorithms.tuple.contract.Value2;

@EqualsAndHashCode
@ToString
public final class Pair<A, B> implements Tuple<Pair<A, B>>, Value1<A>, Value2<B> {

    private final A a;
    private final B b;

    private Pair(A a, B b) {
        this.a = a;
        this.b = b;
    }

    static <A, B> Pair<A, B> valueOf(A _0, B _1) {
        return new Pair<>(_0, _1);
    }

    @Override
    public int size() {
        return 2;
    }

    @Override
    public Object apply(int value) {
        switch (value) {
            case 0:
                return a;
            case 1:
                return b;
            default:
                throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public A _1() {
        return a;
    }

    @Override
    public B _2() {
        return b;
    }
}
