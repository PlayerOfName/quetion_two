package com.shvetsov.quetion2.match;

import com.shvetsov.quetion2.dto.match.MatchDTO;
import com.shvetsov.quetion2.error.NotFoundTeam;
import com.shvetsov.quetion2.models.Match;
import com.shvetsov.quetion2.models.StatisticsTeam;
import com.shvetsov.quetion2.models.Team;
import com.shvetsov.quetion2.repository.MatchRepository;
import com.shvetsov.quetion2.repository.TeamRepository;
import com.shvetsov.quetion2.services.MatchService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Match service test.
 */
@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MatchServiceTest {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private MatchService matchService;

    /**
     * Test create match.
     *
     * @throws NotFoundTeam   the not found team
     * @throws ParseException the parse exception
     */
    @Test
    public void testCreateMatch() throws NotFoundTeam, ParseException {
        teamRepository.save(new Team(1L, "HomeTeam"));
        teamRepository.save(new Team(2L, "AwayTeam"));

        MatchDTO matchDTO = new MatchDTO();
        matchDTO.setNameHomeTeam("HomeTeam");
        matchDTO.setNameAwayTeam("AwayTeam");
        matchDTO.setDateMatch(new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-01"));
        matchDTO.setSeason("2024");
        matchDTO.setNumberPointsHomeTeam(3);
        matchDTO.setNumberPointsAwayTeam(1);

        Match createdMatch = matchService.createMatch(matchDTO);

        assertNotNull(createdMatch);
        assertEquals("HomeTeam", createdMatch.getHomeTeam().getName());
        assertEquals("AwayTeam", createdMatch.getAwayTeam().getName());
        assertEquals("2024", createdMatch.getSeason());
        assertEquals(3, createdMatch.getNumberPointsHomeTeam());
        assertEquals(1, createdMatch.getNumberPointsAwayTeam());
    }

    /**
     * Test get standings.
     *
     * @throws ParseException the parse exception
     */
    @Test
    public void testGetStandings() throws ParseException { // TODO: testGetStandings
        Team homeTeam = teamRepository.save(new Team(1L, "TestTeam"));
        Team awayTeam = teamRepository.save(new Team(2L, "TestTeam2"));
        Team homeTeam2 = teamRepository.save(new Team(3L, "TestTeam3"));
        Team awayTeam2 = teamRepository.save(new Team(4L, "TestTeam4"));

        Match match = new Match();
        match.setId(1L);
        match.setHomeTeam(homeTeam);
        match.setAwayTeam(awayTeam);
        match.setDateMatch(new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-01"));
        match.setSeason("TestSeason");
        match.setNumberPointsHomeTeam(1);
        match.setNumberPointsAwayTeam(2);

        Match match2 = new Match();
        match2.setId(2L);
        match2.setHomeTeam(homeTeam2);
        match2.setAwayTeam(awayTeam2);
        match2.setDateMatch(new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-01"));
        match2.setSeason("TestSeason2");
        match2.setNumberPointsHomeTeam(12);
        match2.setNumberPointsAwayTeam(2);

        matchRepository.save(match);
        matchRepository.save(match2);

        Map<String, StatisticsTeam> expectedStats = new HashMap<>();
        expectedStats.put("TestTeam", new StatisticsTeam(1, 0));
        expectedStats.put("TestTeam2", new StatisticsTeam(1, 3));
        expectedStats.put("TestTeam3", new StatisticsTeam(1, 3));
        expectedStats.put("TestTeam4", new StatisticsTeam(1, 0));

        Map<String, StatisticsTeam> actualStats = matchService.getStandings(new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-01"));

        assertNotNull(actualStats);
        assertEquals(expectedStats.size(), actualStats.size());

        for (String teamName : expectedStats.keySet()) {
            assertTrue(actualStats.containsKey(teamName));
            assertEquals(expectedStats.get(teamName).getMatches(), actualStats.get(teamName).getMatches());
            assertEquals(expectedStats.get(teamName).getPoints(), actualStats.get(teamName).getPoints());
        }
    }
}

