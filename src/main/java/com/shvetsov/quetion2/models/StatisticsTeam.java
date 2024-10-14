package com.shvetsov.quetion2.models;

import lombok.Data;

@Data
public class StatisticsTeam {

    private int matches;
    private int points;

    public StatisticsTeam() {
        this.matches = 0;
        this.points = 0;
    }

    public void incrementMatches() {
        this.matches++;
    }

    public void addPoints(int points) {
        this.points += points;
    }


}
