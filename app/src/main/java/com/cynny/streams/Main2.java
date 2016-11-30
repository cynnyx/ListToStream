package com.cynny.streams;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<MatchResult> results = MatchResult.create();

        List<MatchResult> l2 = new ArrayList<>();
        for (MatchResult result : results) {
            if (result.getHome().getName().equals("ACF Fiorentina")) {
                l2.add(result);
            }
        }
        List<MatchResult> l3 = l2.subList(0, 5);
        int sum = 0;
        for (MatchResult result : l3) {
            sum += result.getHome().getGoals();
        }

        System.out.println(sum);
    }
}
