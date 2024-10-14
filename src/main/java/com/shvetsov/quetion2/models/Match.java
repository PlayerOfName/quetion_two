package com.shvetsov.quetion2.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * model team
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "match")
public class Match {
    /**
     * field id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    /**
     * field awayTeam
     */
    @OneToOne
    @JoinColumn(name = "away_team_id")
    private Team awayTeam;
    /**
     * field homeTeam
     */
    @OneToOne
    @JoinColumn(name = "home_team_id")
    private Team homeTeam;
    /**
     * field dateMatch
     */
    @Column(name = "date_match")
    private Date dateMatch;
    /**
     * field season
     */
    @Column(name = "season")
    private String season;
    /**
     * field numberPointsHomeTeam
     */
    @Column(name = "number_points_home_team")
    private Integer numberPointsHomeTeam;
    /**
     * field numberPointsAwayTeam
     */
    @Column(name = "number_points_away_team")
    private Integer numberPointsAwayTeam;

    /**
     * constructor for Match
     * @param awayTeam
     * @param homeTeam
     * @param dateMatch
     * @param season
     * @param numberPointsHomeTeam
     * @param numberPointsAwayTeam
     */
    public Match(Team awayTeam, Team homeTeam, Date dateMatch, String season, Integer numberPointsHomeTeam, Integer numberPointsAwayTeam){
        this.awayTeam = awayTeam;
        this.homeTeam = homeTeam;
        this.dateMatch = dateMatch;
        this.season = season;
        this.numberPointsHomeTeam = numberPointsHomeTeam;
        this.numberPointsAwayTeam = numberPointsAwayTeam;
    }

}
