package com.cynny.streams;

import java.util.List;

public class Main7 {
    public static void main(String[] args) {
        List<MatchResult> results = MatchResult.create();

        int sum = new MyIterator7<>(results)
                .filter(result -> {
                    System.out.println(result);
                    return result.getHome().getName().equals("ACF Fiorentina");
                })
                .map(result -> {
                    System.out.println(result);
                    return result.getHome().getGoals();
                })
                .limit(5)
                .reduce(0, Integer::sum);

        System.out.println(sum);
    }
}
