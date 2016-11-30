package com.cynny.streams;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main3 {
    public static void main(String[] args) {
        List<MatchResult> results = MatchResult.create();

        List<MatchResult> l1 = filter(results, result -> result.getHome().getName().equals("ACF Fiorentina"));
        List<MatchResult> l2 = limit(l1);
        int sum = reduce(l2);

        System.out.println(sum);
    }

    @NonNull private static List<MatchResult> limit(List<MatchResult> results) {
        return results.subList(0, 5);
    }

    private static int reduce(List<MatchResult> l3) {
        int sum = 0;
        for (MatchResult result : l3) {
            sum += result.getHome().getGoals();
        }
        return sum;
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
