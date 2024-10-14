package com.shvetsov.quetion2.services;

import com.shvetsov.quetion2.models.Match;
import com.shvetsov.quetion2.models.StatisticsTeam;
import com.shvetsov.quetion2.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository matchRepository;


    public Map<String, StatisticsTeam> getStandings(Date date) {
        Map<String, StatisticsTeam> stats = new HashMap<>();
        List<Match> matches = matchRepository.findByDate(date);

        for (Match match : matches) {
            String awayTeam = match.getAwayTeam().getName();
            String homeTeam = match.getHomeTeam().getName();

            stats.putIfAbsent(awayTeam, new StatisticsTeam());
            stats.putIfAbsent(homeTeam, new StatisticsTeam());

            stats.get(homeTeam).incrementMatches();
            stats.get(awayTeam).incrementMatches();

            Integer numberPointsHomeTeam = match.getNumberPointsHomeTeam();
            Integer numberPointsAwayTeam = match.getNumberPointsAwayTeam();

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
}
