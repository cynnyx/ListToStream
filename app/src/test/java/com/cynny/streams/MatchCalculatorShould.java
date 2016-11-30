package com.cynny.streams;

import java.util.List;
import org.junit.Test;

public class MatchCalculatorShould {
    @Test
    public void addition_isCorrect() throws Exception {
        //pareggi fiorentina
        //la prima partita in cui non ha segnato
        //filter con functional parameter

        List<MatchResult> matchResults = MatchCalculator6.calculateDraws(MatchResult.create(), "ACF Fiorentina");

        for (MatchResult matchResult : matchResults) {
            System.out.println(matchResult);
        }

        MatchResult result = MatchCalculator6.calculateFirstMatchWithGoals(MatchResult.create(), "ACF Fiorentina", 4);

        System.out.println(result);
    }
}