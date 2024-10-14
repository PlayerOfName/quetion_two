package com.shvetsov.quetion2.services;

import com.shvetsov.quetion2.dto.match.MatchDTO;
import com.shvetsov.quetion2.error.NotFoundTeam;
import com.shvetsov.quetion2.mappers.MatchMapper;
import com.shvetsov.quetion2.models.Match;
import com.shvetsov.quetion2.models.StatisticsTeam;
import com.shvetsov.quetion2.models.Team;
import com.shvetsov.quetion2.repository.MatchRepository;
import com.shvetsov.quetion2.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * The type Match service.
 */
@Service
@RequiredArgsConstructor
public class MatchService {

    /**
     * this is the mapper for {@link Match}
     */
    private final MatchMapper matchMapper;
    /**
     * this is the repository for {@link Match}
     */
    private final MatchRepository matchRepository;
    /**
     * this is the repository for {@link Team}
     */
    private final TeamRepository teamRepository;

    /**
     * Method for getting the tournament table
     *
     * @param date the date of the match
     * @return a map where the key is the team name and the value is an instance of {@link StatisticsTeam}
     */
    public Map<String, StatisticsTeam> getStandings(Date date) {
        Map<String, StatisticsTeam> stats = new HashMap<>();
        List<Match> matches = matchRepository.findByDateMatch(date);

        for (Match match : matches) {
            String awayTeam = match.getAwayTeam().getName();
            String homeTeam = match.getHomeTeam().getName();

            stats.putIfAbsent(awayTeam, new StatisticsTeam());
            stats.putIfAbsent(homeTeam, new StatisticsTeam());

            stats.get(homeTeam).incrementMatches();
            stats.get(awayTeam).incrementMatches();

            if (match.getNumberPointsHomeTeam() > match.getNumberPointsAwayTeam()) {
                stats.get(homeTeam).addPoints(3);
            } else if (match.getNumberPointsHomeTeam() < match.getNumberPointsAwayTeam()) {
                stats.get(awayTeam).addPoints(3);
            } else {
                stats.get(homeTeam).addPoints(1);
                stats.get(awayTeam).addPoints(1);
            }
        }

        return stats;
    }

    /**
     * Метод для создания матча из DTO
     * @param matchDTO объект MatchDTO
     * @return созданный объект Match
     */
    public Match createMatch(MatchDTO matchDTO) throws NotFoundTeam {
        // Поиск home и away команд по имени
        Team homeTeam = teamRepository.findByName(matchDTO.getNameHomeTeamDTO())
                .orElseThrow(() -> new NotFoundTeam("not found home team"));
        Team awayTeam = teamRepository.findByName(matchDTO.getNameAwayTeamDTO())
                .orElseThrow(() -> new NotFoundTeam("not found away team"));

        // Маппинг DTO в Match
        Match match = matchMapper.fromMatchCreateDto(matchDTO);

        // Установка найденных команд
        match.setHomeTeam(homeTeam);
        match.setAwayTeam(awayTeam);

        matchRepository.save(match);
        // Возвращаем объект Match
        return match;
    }
}
