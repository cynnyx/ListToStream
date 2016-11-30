package com.cynny.streams;

import java.util.ArrayList;
import java.util.List;

public class TeamScore {
    private final String name;
    private final int goals;
    private final List<String> scorers;

    public TeamScore(String name, int goals) {
        this.name = name;
        this.goals = goals;
        this.scorers = new ArrayList<>();
        for (int i = 0; i < goals; i++) {
             scorers.add("Player " + i);
        }
    }

    public String getName() {
        return name;
    }

    public int getGoals() {
        return goals;
    }

    public List<String> getScorers() {
        return scorers;
    }

    @Override public String toString() {
        return name + " " + goals;
    }
}
