package com.cynny.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatchResult {

    private final TeamScore home;

    private final TeamScore away;

    public MatchResult(TeamScore home, TeamScore away) {
        this.home = home;
        this.away = away;
    }

    public TeamScore getHome() {
        return home;
    }

    public TeamScore getAway() {
        return away;
    }

    public static MatchResult create(String home, String away, int homeGoals, int awayGoals) {
        return new MatchResult(new TeamScore(home, homeGoals), new TeamScore(away, awayGoals));
    }

    public static List<MatchResult> create() {
        return Arrays.asList(
                create("ACF Fiorentina", "AC Milan", 2, 0),
                create("Torino FC", "ACF Fiorentina", 3, 1),
                create("ACF Fiorentina", "Genoa CFC", 1, 0),
                create("Carpi FC", "ACF Fiorentina", 0, 1),
                create("ACF Fiorentina", "Bologna FC", 2, 0),
                create("FC Internazionale Milano", "ACF Fiorentina", 1, 4),
                create("ACF Fiorentina", "Atalanta BC", 3, 0),
                create("SSC Napoli", "ACF Fiorentina", 2, 1),
                create("ACF Fiorentina", "AS Roma", 1, 2),
                create("Hellas Verona FC", "ACF Fiorentina", 0, 2),
                create("ACF Fiorentina", "Frosinone Calcio", 4, 1),
                create("UC Sampdoria", "ACF Fiorentina", 0, 2),
                create("ACF Fiorentina", "Empoli FC", 2, 2),
                create("US Sassuolo Calcio", "ACF Fiorentina", 1, 1),
                create("ACF Fiorentina", "Udinese Calcio", 3, 0),
                create("Juventus Turin", "ACF Fiorentina", 3, 1),
                create("ACF Fiorentina", "AC Chievo Verona", 2, 0),
                create("US Cittá di Palermo", "ACF Fiorentina", 1, 3),
                create("ACF Fiorentina", "SS Lazio", 1, 3),
                create("AC Milan", "ACF Fiorentina", 2, 0),
                create("ACF Fiorentina", "Torino FC", 2, 0),
                create("Genoa CFC", "ACF Fiorentina", 0, 0),
                create("ACF Fiorentina", "Carpi FC", 2, 1),
                create("Bologna FC", "ACF Fiorentina", 1, 1),
                create("ACF Fiorentina", "FC Internazionale Milano", 2, 1),
                create("Atalanta BC", "ACF Fiorentina", 2, 3),
                create("ACF Fiorentina", "SSC Napoli", 1, 1),
                create("AS Roma", "ACF Fiorentina", 4, 1),
                create("ACF Fiorentina", "Hellas Verona FC", 1, 1),
                create("Frosinone Calcio", "ACF Fiorentina", 0, 0),
                create("ACF Fiorentina", "UC Sampdoria", 1, 1),
                create("Empoli FC", "ACF Fiorentina", 2, 0),
                create("ACF Fiorentina", "US Sassuolo Calcio", 3, 1),
                create("Udinese Calcio", "ACF Fiorentina", 2, 1),
                create("ACF Fiorentina", "Juventus Turin", 1, 2),
                create("AC Chievo Verona", "ACF Fiorentina", 0, 0),
                create("ACF Fiorentina", "US Cittá di Palermo", 0, 0),
                create("SS Lazio", "ACF Fiorentina", 2, 4)
        );
    }

    @Override public String toString() {
        return home + " - " + away;
    }

    public boolean isWithTeam(String teamName) {
        return getHome().getName().equals(teamName) || getAway().getName().equals(teamName);
    }

    public int getTotalGoals() {
        return getHome().getGoals() + getAway().getGoals();
    }

    public boolean isDraw() {
        return getHome().getGoals() == getAway().getGoals();
    }

    public List<String> getScorers() {
        List<String> ret = new ArrayList<>();
        ret.addAll(home.getScorers());
        ret.addAll(away.getScorers());
        return ret;
    }
}
