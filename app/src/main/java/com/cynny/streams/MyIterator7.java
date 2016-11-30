package com.cynny.streams;

import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyIterator7<T> {
    private Iterator<T> iterator;

    private MyIterator7() {
    }

    public MyIterator7(Iterable<T> iterable) {
        this.iterator = iterable.iterator();
    }

    @NonNull MyIterator7<T> filter(Predicate<T> p) {
        MyIterator7<T> originalIterator = this;
        return new MyIterator7<T>() {

            private T next;

            @Override public boolean hasNext() {
                while (originalIterator.hasNext() && next == null) {
                    T el = originalIterator.next();
                    if (p.test(el)) {
                        next = el;
                    }
                }
                return next != null;
            }

            @Override public T next() {
                if (hasNext()) {
                    T ret = next;
                    next = null;
                    return ret;
                } else {
                    return null;
                }
            }
        };
    }

    @NonNull <R> MyIterator7<R> map(Function<T, R> function) {
        MyIterator7<T> original = this;
        return new MyIterator7<R>() {

            @Override public boolean hasNext() {
                return original.hasNext();
            }

            @Override public R next() {
                return function.apply(original.next());
            }
        };
    }

    public T reduce(T startValue, BiFunction<T, T, T> accumulator) {
        T sum = startValue;
        while (hasNext()) {
            T i = next();
            sum = accumulator.apply(sum, i);
        }
        return sum;
    }

    @NonNull public MyIterator7<T> limit(int l) {
        MyIterator7<T> original = this;
        return new MyIterator7<T>() {
            int count;

            @Override public boolean hasNext() {
                count++;
                if (count > l) {
                    return false;
                } else {
                    return original.hasNext();
                }
            }

            @Override public T next() {
                return original.next();
            }
        };
    }

    public T next() {
        return iterator.next();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }
}
