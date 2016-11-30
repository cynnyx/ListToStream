package com.cynny.streams;

import java.util.List;

public class MainStream {
    public static void main(String[] args) {
        List<MatchResult> results = MatchResult.create();

        int sum = results
                .stream()
                .map(MatchResult::getHome)
                .filter(team -> team.getName().equals("ACF Fiorentina"))
                .limit(5)
                .map(TeamScore::getGoals)
                .reduce(0, Integer::sum);

        System.out.println(sum);

        sum = results
                .stream()
                .filter(result -> result.getHome().getName().equals("ACF Fiorentina"))
                .limit(5)
                .map(result -> result.getHome().getGoals())
                .reduce(0, Integer::sum);

        System.out.println(sum);
    }
}
