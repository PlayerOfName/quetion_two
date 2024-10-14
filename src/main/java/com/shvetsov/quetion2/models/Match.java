package com.shvetsov.quetion2.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "match")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @OneToOne
    @JoinColumn(name = "away_team_id")
    private Team awayTeam;
    @OneToOne
    @JoinColumn(name = "home_team_id")
    private Team homeTeam;
    @Column(name = "date_match")
    private Date dateMatch;
    @Column(name = "season")
    private String season;
    @Column(name = "number_points_home_team")
    private Integer numberPointsHomeTeam;
    @Column(name = "number_points_away_team")
    private Integer numberPointsAwayTeam;

    public Match(Team awayTeam, Team homeTeam, Date dateMatch, String season, Integer numberPointsHomeTeam, Integer numberPointsAwayTeam){
        this.awayTeam = awayTeam;
        this.homeTeam = homeTeam;
        this.dateMatch = dateMatch;
        this.season = season;
        this.numberPointsHomeTeam = numberPointsHomeTeam;
        this.numberPointsAwayTeam = numberPointsAwayTeam;
    }

}
