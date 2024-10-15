package com.shvetsov.quetion2.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatisticsTeam {

    private int matches;
    private int points;

    public void incrementMatches() {
        this.matches++;
    }

    public void addPoints(int points) {
        this.points += points;
    }


}
