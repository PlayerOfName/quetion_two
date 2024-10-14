package com.shvetsov.quetion2.dto.match;

import com.shvetsov.quetion2.models.Team;
import lombok.Data;

import java.util.Date;

@Data
public class MatchDTO {
    private Team awayTeam;
    private Team homeTeam;
    private Date dateMatch;
    private String season;
    private Integer numberPointsHomeTeam;
    private Integer numberPointsAwayTeam;
}
