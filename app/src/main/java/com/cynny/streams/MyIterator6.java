package com.cynny.streams;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyIterator6<T> {
    private Iterator<T> iterator;

    public MyIterator6(Iterable<T> iterable) {
        this.iterator = iterable.iterator();
    }

    @NonNull MyIterator6<T> filter(Predicate<T> p) {
        List<T> l2 = new ArrayList<>();
        while (hasNext()) {
            T result = next();
            if (p.test(result)) {
                l2.add(result);
            }
        }
        return new MyIterator6<>(l2);
    }

    @NonNull <R> MyIterator6<R> map(Function<T, R> function) {
        List<R> integers = new ArrayList<>();
        while (hasNext()) {
            T result = next();
            integers.add(function.apply(result));
        }
        return new MyIterator6<>(integers);
    }

    public T reduce(T startValue, BiFunction<T, T, T> accumulator) {
        T sum = startValue;
        while (hasNext()) {
            T i = next();
            sum = accumulator.apply(sum, i);
        }
        return sum;
    }

    @NonNull public MyIterator6<T> limit(int l) {
        List<T> res = new ArrayList<>();
        while (hasNext()) {
            T next = next();
            res.add(next);
            if (res.size() == l) {
                break;
            }
        }
        return new MyIterator6<>(res);
    }

    public T next() {
        return iterator.next();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }
}
