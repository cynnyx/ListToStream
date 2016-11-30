package com.cynny.streams;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class Main9 {
    public static void main(String[] args) {
        List<MatchResult> results = MatchResult.create();

        Map<String, Integer> map = results.stream()
                .flatMap(result -> result.getScorers().stream())
                .collect(toMap(s -> s, s -> 1, (i1, i2) -> i1 + i2));

        System.out.println(map);
    }
}
