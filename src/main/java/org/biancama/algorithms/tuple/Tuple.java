package org.biancama.algorithms.tuple;

import java.io.Serializable;
import java.util.Objects;
import java.util.function.IntFunction;

public interface Tuple<T extends Tuple> extends IntFunction, Serializable, Cloneable, Comparable<T> {

    int size();

    @Override
    default int compareTo(T o) {
        Objects.requireNonNull(o);
        if (!getClass().equals(o.getClass())) {
            throw new ClassCastException(o.getClass() + " must equal " + getClass());
        }

        for (int i = 0; i < size(); i++) {
            @SuppressWarnings("unchecked")
            Comparable<Object> l = (Comparable<Object>) apply(i);
            Object r = o.apply(i);
            int c = l.compareTo(r);
            if (c != 0) {
                return c;
            }
        }

        return 0;
    }

    static Tuple valueOf() {
        return EmptyTuple.valueOf();
    }
    static <A> Unit<A> valueOf(A _0) {
        return Unit.valueOf(_0);
    }
    static <A, B> Pair<A, B> valueOf(A _0, B _1) {
        return Pair.valueOf(_0, _1);
    }
}