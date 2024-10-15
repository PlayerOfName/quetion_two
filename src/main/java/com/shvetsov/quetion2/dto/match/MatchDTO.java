package com.shvetsov.quetion2.dto.match;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * The type Match dto.
 */
@Getter
@Setter
public class MatchDTO {
    /**
     * field awayTeamDTO
     */
    private String nameHomeTeam;
    /**
     * field homeTeamDTO
     */
    private String nameAwayTeam;
    /**
     * field dateMatchDTO
     */
    private Date dateMatch;
    /**
     * field seasonDTO
     */
    private String season;
    /**
     * field numberPointsHomeTeamDTO
     */
    private Integer numberPointsHomeTeam;
    /**
     * field numberPointsAwayTeamDTO
     */
    private Integer numberPointsAwayTeam;
}
