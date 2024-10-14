package com.shvetsov.quetion2.dto.match;

import com.shvetsov.quetion2.models.Team;
import lombok.Data;
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
    private String nameHomeTeamDTO;
    /**
     * field homeTeamDTO
     */
    private String nameAwayTeamDTO;
    /**
     * field dateMatchDTO
     */
    private Date dateMatchDTO;
    /**
     * field seasonDTO
     */
    private String seasonDTO;
    /**
     * field numberPointsHomeTeamDTO
     */
    private Integer numberPointsHomeTeamDTO;
    /**
     * field numberPointsAwayTeamDTO
     */
    private Integer numberPointsAwayTeamDTO;
}
