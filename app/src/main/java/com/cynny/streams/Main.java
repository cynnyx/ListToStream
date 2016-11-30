package com.cynny.streams;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<MatchResult> results = MatchResult.create();

        int sum = 0;
        int tot = 0;
        for (MatchResult result : results) {
            if (result.getHome().getName().equals("ACF Fiorentina")) {
                sum += result.getHome().getGoals();
                tot++;
                if (tot == 5) {
                    break;
                }
            }
        }

        System.out.println(sum);
    }
}
