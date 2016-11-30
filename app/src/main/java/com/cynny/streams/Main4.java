package com.cynny.streams;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main4 {
    public static void main(String[] args) {
        List<MatchResult> results = MatchResult.create();

        List<MatchResult> l1 = filter(results, result -> result.getHome().getName().equals("ACF Fiorentina"));
        List<MatchResult> l2 = limit(l1);
        List<Integer> goals = map(l2, result -> result.getHome().getGoals());
        int sum = reduce(goals, 0, Integer::sum);

        System.out.println(sum);
    }

    @NonNull private static <T> List<T> limit(List<T> results) {
        return results.subList(0, 5);
    }

    private static <T> T reduce(List<T> integers, T startValue, BiFunction<T, T, T> accumulator) {
        T sum = startValue;
        for (T i : integers) {
            sum = accumulator.apply(sum, i);
        }
        return sum;
    }

    @NonNull private static <T, R> List<R> map(List<T> l3, Function<T, R> function) {
        List<R> integers = new ArrayList<>();
        for (T result : l3) {
            integers.add(function.apply(result));
        }
        return integers;
    }

    @NonNull private static <T> List<T> filter(List<T> results, Predicate<T> p) {
        List<T> l2 = new ArrayList<>();
        for (T result : results) {
            if (p.test(result)) {
                l2.add(result);
            }
        }
        return l2;
    }
}
