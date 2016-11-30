package com.cynny.streams;

import java.util.List;

public class Main8 {
    public static void main(String[] args) {
        List<MatchResult> results = MatchResult.create();

        int sum = results.stream()
                .filter(result -> result.getHome().getName().equals("ACF Fiorentina"))
                .map(result -> result.getHome().getGoals())
                .limit(5)
                .reduce(0, Integer::sum);

        System.out.println(sum);
    }
}
