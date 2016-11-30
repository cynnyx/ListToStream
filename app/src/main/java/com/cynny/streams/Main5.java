package com.cynny.streams;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main5 {
    public static void main(String[] args) {
        List<MatchResult> results = MatchResult.create();

        Iterator<MatchResult> l1 = filter(results.iterator(), result -> result.getHome().getName().equals("ACF Fiorentina"));
        Iterator<MatchResult> l2 = limit(l1);
        Iterator<Integer> goals = map(l2, result -> result.getHome().getGoals());
        int sum = reduce(goals, 0, Integer::sum);

        System.out.println(sum);
    }

    @NonNull private static <T> Iterator<T> limit(Iterator<T> iterator) {
        List<T> res = new ArrayList<>();
        while (iterator.hasNext()) {
            T next = iterator.next();
            res.add(next);
            if (res.size() == 5) {
                break;
            }
        }
        return res.iterator();
    }

    private static <T> T reduce(Iterator<T> iterator, T startValue, BiFunction<T, T, T> accumulator) {
        T sum = startValue;
        while (iterator.hasNext()) {
            T i = iterator.next();
            sum = accumulator.apply(sum, i);
        }
        return sum;
    }

    @NonNull private static <T, R> Iterator<R> map(Iterator<T> iterator, Function<T, R> function) {
        List<R> integers = new ArrayList<>();
        while (iterator.hasNext()) {
            T result = iterator.next();
            integers.add(function.apply(result));
        }
        return integers.iterator();
    }

    @NonNull private static <T> Iterator<T> filter(Iterator<T> iterator, Predicate<T> p) {
        List<T> l2 = new ArrayList<>();
        while (iterator.hasNext()) {
            T result = iterator.next();
            if (p.test(result)) {
                l2.add(result);
            }
        }
        return l2.iterator();
    }
}
